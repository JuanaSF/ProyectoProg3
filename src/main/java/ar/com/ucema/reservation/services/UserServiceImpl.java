package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.authentication.JwtUtilities;
import ar.com.ucema.reservation.dto.SignUpDTO;
import ar.com.ucema.reservation.exception.InvalidFieldsException;
import ar.com.ucema.reservation.exception.ResourceNotFoundException;
import ar.com.ucema.reservation.exception.ServiceException;
import ar.com.ucema.reservation.models.RoleEnum;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User createUser(SignUpDTO signUpDTO) {
        User user = new User(signUpDTO.getFirstName(), signUpDTO.getLastName(),
                signUpDTO.getEmail(), signUpDTO.getPassword(), signUpDTO.getRoleEnum());
        validateUser(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private void validateUser(User user) {
        boolean hasErrors = false;
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(user.getFirstName())) {
            errors.add("The field first name cannot be null");
            hasErrors = true;
        }

        if (StringUtils.isBlank(user.getLastName())) {
            errors.add("The field last name cannot be null");
            hasErrors = true;
        }

        if (StringUtils.isBlank(user.getEmail())) {
            errors.add("The field email cannot be null");
            hasErrors = true;
        }

        if (StringUtils.isBlank(user.getPassword())) {
            errors.add("The field password cannot be null");
            hasErrors = true;
        }

        if (user.getRole() == null) {
            errors.add("The field role cannot be null");
            hasErrors = true;
        } else if (user.getRole().equals(RoleEnum.ADMIN)) {
            errors.add("The provided role is not allowed");
            hasErrors = true;
        }

        if (hasErrors) throw new InvalidFieldsException("The user contains invalid fields", errors);

        User userDB = userRepository.findByEmail(user.getEmail());

        if (userDB != null) {
            if (user.getId() == null) {
                throw new ServiceException("Email already in use", "A user is already registered with this email address");
            } else if (!userDB.getId().equals(user.getId())) {
                throw new ServiceException("Unable to change email", "Email modification is not allowed");
            }
        }

        // Aca revisar que el user nunca cambie de rol
    }

    @Override
    public String authenticate(String username, String password) {
        User user = getByEmail(username);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getEmail(), user.getId(), user.getRole().getRoleName());
        return token;
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for Id: " + userId));
    }

    @Override
    public User getByEmail(String username) {
        User user = userRepository.findByEmail(username);
        if (user == null) throw new ResourceNotFoundException("User not found for email: " + username);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        validateUser(user);

        User userDB = getById(id);

        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());
        userDB.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(userDB);
    }
}
