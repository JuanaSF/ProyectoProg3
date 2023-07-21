package ar.com.ucema.reservation.dto;

import ar.com.ucema.reservation.enumeration.AttendeeTypeEnum;

import java.time.LocalDate;

public class AttendeeDTO {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String documentNumber;
    private String nationality;
    private AttendeeTypeEnum attendeeType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public AttendeeTypeEnum getAttendeeType() {
        return attendeeType;
    }

    public void setAttendeeType(AttendeeTypeEnum attendeeType) {
        this.attendeeType = attendeeType;
    }
}
