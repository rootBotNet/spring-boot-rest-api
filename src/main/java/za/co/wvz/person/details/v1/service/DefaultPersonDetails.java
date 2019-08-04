package za.co.wvz.person.details.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.wvz.person.details.v1.entity.PersonDetails;
import za.co.wvz.person.details.v1.repository.PersonDetailsRepository;

import java.util.List;

@Component
public class DefaultPersonDetails implements PersonDetailsService {

    @Autowired
    PersonDetailsRepository personDetailsRepository;

    @Override
    public int add(PersonDetails personDetails) {
        personDetailsRepository.insert(personDetails);
        return 0;
    }

    @Override
    public List<PersonDetails> findAll() {
        return  personDetailsRepository.findAll();
    }

    @Override
    public PersonDetails findById(int id) {
        return personDetailsRepository.getById(id);
    }
}
