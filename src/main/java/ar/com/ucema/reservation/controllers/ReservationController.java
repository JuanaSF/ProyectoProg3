package ar.com.ucema.reservation.controllers;

import ar.com.ucema.reservation.dto.ReservationDTO;
import ar.com.ucema.reservation.models.Reservation;
import ar.com.ucema.reservation.services.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/reservations")
@SecurityRequirement(name = "Bearer Auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "endpoint to create a reservation")
    @PostMapping
    public Reservation createActivityProfile(@RequestBody ReservationDTO reservation) {
        Reservation newReservation = reservationService.createReservation(reservation);

        return newReservation;
    }

    @Operation(summary = "endpoint to get a reservation info by id")
    @GetMapping(path = "/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getById(id);
    }
}
