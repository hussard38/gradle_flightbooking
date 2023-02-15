package org.hussard.flight.booking.infrastructure.repository;

import org.hussard.flight.booking.business.adapter.out.ListOfAdultsRepository;
import org.hussard.flight.booking.business.model.Person;

import java.util.Collections;
import java.util.List;

public class ListOfAdultsRepositoryJson implements ListOfAdultsRepository {
    @Override
    public List<Person> findAll() {
        return Collections.emptyList();
    }
}
