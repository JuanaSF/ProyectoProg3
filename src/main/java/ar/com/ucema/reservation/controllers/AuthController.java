package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.LoginDTO;
import ar.com.ucema.reservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        return this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
