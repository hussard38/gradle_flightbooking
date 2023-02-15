package org.hussard.flight.booking.business.model;

import java.time.LocalDate;


public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
