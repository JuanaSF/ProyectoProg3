package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.authentication.JwtUtilities;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Override
    public User createUser(User user) {
        String password = user.getPassword();

        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);

    }

    @Override
    public String authenticate(String username, String password) {
        User user = this.userRepository.findByEmail(username).orElse(null);
        if (user == null) { return null; }
        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole().getRoleName());
        return token;
    }
}
