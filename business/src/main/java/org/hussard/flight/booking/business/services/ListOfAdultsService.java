package org.hussard.flight.booking.business.services;

import org.hussard.flight.booking.business.adapter.in.ListOfAdults;
import org.hussard.flight.booking.business.adapter.out.ListOfAdultsRepository;
import org.hussard.flight.booking.business.model.Person;

import java.util.List;

public class ListOfAdultsService implements ListOfAdults {
    private final ListOfAdultsRepository listOfAdultsRepository;

    public ListOfAdultsService(ListOfAdultsRepository listOfAdultsRepository) {
        this.listOfAdultsRepository = listOfAdultsRepository;
    }

    @Override
    public List<Person> findAll() {
            return listOfAdultsRepository.findAll();
    }
}
