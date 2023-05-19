package ar.com.ucema.reservation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @GetMapping(path = "/test")
    public ResponseEntity<?> getUsers() {
        List<String> users = new ArrayList<>();

        users.add("User1");
        users.add("User2");

        return ResponseEntity.ok(users);
    }
}
