package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> CreateUser(@RequestBody User user) {

        User newUser = userService.createUser(user);

        return ResponseEntity.ok(newUser);
    }
}
