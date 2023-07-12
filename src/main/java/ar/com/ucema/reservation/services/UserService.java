package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.SignUpDTO;
import ar.com.ucema.reservation.models.User;

public interface UserService {

    User createUser(SignUpDTO signUpDTO);

    String authenticate(String username, String password);

    User getById(Long userId);

    User getByEmail(String username);

    User updateUser(Long id, User user);
}
