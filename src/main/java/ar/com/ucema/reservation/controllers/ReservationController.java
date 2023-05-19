package ar.com.ucema.reservation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reservations")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @GetMapping(path = "/test")
    public ResponseEntity<?> getUsers() {
        List<String> users = new ArrayList<>();

        users.add("User1");
        users.add("User2");

        return ResponseEntity.ok(users);
    }
}
