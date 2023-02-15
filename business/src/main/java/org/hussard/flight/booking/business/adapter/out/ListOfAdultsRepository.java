package org.hussard.flight.booking.business.adapter.out;

import org.hussard.flight.booking.business.model.Person;

import java.util.List;

public interface ListOfAdultsRepository {
    List<Person> findAll();
}
