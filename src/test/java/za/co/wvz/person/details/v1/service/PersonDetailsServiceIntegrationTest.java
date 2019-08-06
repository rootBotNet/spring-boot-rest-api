package za.co.wvz.person.details.v1.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.wvz.person.details.v1.entity.PersonDetails;
import za.co.wvz.person.details.v1.repository.PersonDetailsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PersonDetailsServiceIntegrationTest {

    @TestConfiguration
    static class DefaultPersonDetailsTestContextConfiguration{
        @Bean
        public PersonDetailsService personDetailsService(){
            return new DefaultPersonDetails();
        }
    }

    @Autowired
    private PersonDetailsService personDetailsService;

    @MockBean
    PersonDetailsRepository personDetailsRepository;

    @Before
    public void setup(){

        List<PersonDetails> personDetailsList;
        personDetailsList = createPersonDetails();

        Mockito.when(personDetailsRepository.findAll()).thenReturn(personDetailsList);
        Mockito.when(personDetailsRepository.getById(2)).thenReturn(personDetailsList.get(1));
    }

    @Test
    public void whenFindAll_thenAllPersonsShouldBeFound(){
        List<PersonDetails> personDetailsFound = personDetailsService.findAll();
        assertThat(personDetailsFound.size()).isEqualTo(2);

    }

    @Test
    public void whenFindById_thenPersonWithGivenIdShouldBeFound(){
        PersonDetails personDetailsFound = personDetailsService.findById(2);
        assertThat(personDetailsFound.getId()).isEqualTo(2);
        assertThat(personDetailsFound.getName()).isEqualTo("Jude");
        assertThat(personDetailsFound.getAge()).isEqualTo(44);
        assertThat(personDetailsFound.getAgeCategory()).isEqualTo("Middle");

    }

    private List<PersonDetails> createPersonDetails(){
        PersonDetails firstPersonDetails = new PersonDetails();
        firstPersonDetails.setId(1);
        firstPersonDetails.setName("James");
        firstPersonDetails.setAge(45);
        firstPersonDetails.setAgeCategory("Old");

        PersonDetails secondPersonDetails = new PersonDetails();
        secondPersonDetails.setId(2);
        secondPersonDetails.setName("Jude");
        secondPersonDetails.setAge(44);
        secondPersonDetails.setAgeCategory("Middle");

        List<PersonDetails> personDetails = new ArrayList<>();
        personDetails.add(firstPersonDetails);
        personDetails.add(secondPersonDetails);

        return personDetails;
    }

}
