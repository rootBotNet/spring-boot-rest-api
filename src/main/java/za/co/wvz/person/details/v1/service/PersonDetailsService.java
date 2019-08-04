package za.co.wvz.person.details.v1.service;

import za.co.wvz.person.details.v1.entity.PersonDetails;

import java.util.List;

public interface PersonDetailsService {
    public int add(PersonDetails personDetails);
    public List<PersonDetails> findAll();
    public PersonDetails findById(int id);
}
