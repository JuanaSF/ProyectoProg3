package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.LoginDTO;
import ar.com.ucema.reservation.dto.ResponseLoginDTO;
import ar.com.ucema.reservation.dto.SignUpDTO;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UserService userService;

    @Operation(summary = "endpoint to authenticate user by email and password")
    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }

    @Operation(summary = "endpoint to register a user")
    @PostMapping(path = "/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUp) {
            User newUser = userService.createUser(signUp);

            return ResponseEntity.ok(newUser);

    }
}
