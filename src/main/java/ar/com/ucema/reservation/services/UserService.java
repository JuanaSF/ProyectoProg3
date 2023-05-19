package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.models.User;

public interface UserService {

    User createUser(User user);

    String authenticate(String username, String password);

    User getById(Long userId);
}
