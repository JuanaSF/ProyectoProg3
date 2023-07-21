package ar.com.ucema.reservation.services;

import ar.com.ucema.reservation.dto.AttendeeDTO;
import ar.com.ucema.reservation.dto.ReservationDTO;
import ar.com.ucema.reservation.enumeration.ReservationStatusEnum;
import ar.com.ucema.reservation.exception.ResourceNotFoundException;
import ar.com.ucema.reservation.exception.ServiceException;
import ar.com.ucema.reservation.models.Activity;
import ar.com.ucema.reservation.models.Attendee;
import ar.com.ucema.reservation.models.Reservation;
import ar.com.ucema.reservation.models.User;
import ar.com.ucema.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ActivityService activityService;

    @Override
    @Transactional(readOnly = true)
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found for Id: " + id));
    }

    @Override
    @Transactional
    public Reservation createReservation(ReservationDTO reservation) {

        User client = userDetailsService.getAuthenticatedUser();
        Activity activity = activityService.getById(reservation.getActivityId());

        boolean isAvailable = activity.isAvailable(reservation.getAttendees().size());

        if (!isAvailable) {
            throw new ServiceException("ReservationError", "There are no places available for this make this reservation");
        }

        Reservation newReservation = new Reservation();

        newReservation.setClient(client);
        newReservation.setActivity(activity);
        newReservation.setReservationDate(reservation.getReservationDate());
        newReservation.setCreationDate(LocalDateTime.now());
        newReservation.setPrice(newReservation.getPrice());
        newReservation.setStatus(ReservationStatusEnum.CONFIRMED);
        newReservation.setAttendeeCount(reservation.getAttendees().size());

        if (reservation.getAttendees() != null && !reservation.getAttendees().isEmpty()) {
            newReservation.setAttendees(new ArrayList<>());

            for (AttendeeDTO a : reservation.getAttendees()) {
                Attendee attendee = new Attendee();

                attendee.setFirstName(a.getFirstName());
                attendee.setLastName(a.getLastName());
                attendee.setDateOfBirth(a.getDateOfBirth());
                attendee.setDocumentNumber(a.getDocumentNumber());
                attendee.setNationality(a.getNationality());
                attendee.setAttendeeType(a.getAttendeeType());

                newReservation.loadAttendee(attendee);
            }

        }

        save(newReservation);
        activityService.availableCapacity(activity, reservation.getAttendees().size());

        return newReservation;
    }

    private Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
