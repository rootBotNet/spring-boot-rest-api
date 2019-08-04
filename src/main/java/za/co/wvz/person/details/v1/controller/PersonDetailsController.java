package za.co.wvz.person.details.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import za.co.wvz.person.details.v1.entity.PersonDetails;
import za.co.wvz.person.details.v1.service.PersonDetailsService;
import za.co.wvz.person.details.v1.validation.CalculateAgeCategory;
import za.co.wvz.person.details.v1.validation.ValidatePersonDetails;
import za.co.wvz.person.details.v1.validation.error.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonDetailsController {

    private static final Logger log = LoggerFactory.getLogger(PersonDetailsController.class);

    @Autowired
    PersonDetailsService personDetailsService;

    @Autowired
    ValidatePersonDetails validatePersonDetails;

    @Autowired
    CalculateAgeCategory calculateAgeCategory;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/person/{name}/{age}", method = RequestMethod.PUT)
    public ResponseEntity add(@PathVariable("name") String personName, @PathVariable("age") int age ){

        log.info("Adding person to database with name: {} age: {}", personName, age);

        PersonDetails personDetails = new PersonDetails();
        personDetails.setName(personName);
        personDetails.setAge(age);
        personDetails.setAgeCategory(calculateAgeCategory.getCategory(age));
        personDetailsService.add(personDetails);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Secured("ROLE_GUEST")
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDetails>> findAll() {
        log.info("Retrieving all persons from database.");
        List<PersonDetails> personDetails = personDetailsService.findAll();
        return new ResponseEntity<>(personDetails, HttpStatus.OK);
    }

    @Secured("ROLE_GUEST")
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonDetails> findById(@PathVariable int id) {
        log.info("Retrieving person from database with id: {}", id);
        PersonDetails personDetails = personDetailsService.findById(id);

        if(validatePersonDetails.isUserEmpty(personDetails.getId())){
            log.info("No person in database with id: {}", id);
            return new ResponseEntity(new CustomErrorType("Unable to find person with id " + id), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personDetails, HttpStatus.OK);
    }
}
