package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.models.Reservation;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.services.UserDetailsServiceImpl;
import ar.com.ucema.reservation.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@SecurityRequirement(name = "Bearer Auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Operation(summary = "endpoint to get information from the logged user.")
    @GetMapping("/me")
    public User getLoggedUser() {
        User user = userDetailsService.getAuthenticatedUser();
        return user;
    }

    @Operation(summary = "endpoint to get user info")
    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "endpoint to get user reservations")
    @GetMapping(path = "/reservations")
    public List<Reservation> getUserReservations() {
        User user = userDetailsService.getAuthenticatedUser();

        if (user != null) {
            return user.getReservations();
        }

        return Collections.emptyList();
    }

    @Operation(summary = "endpoint to update user info")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
}
