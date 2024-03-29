package za.co.wvz.person.details.v1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.wvz.person.details.v1.controller.PersonDetailsController;
import za.co.wvz.person.details.v1.entity.PersonDetails;
import za.co.wvz.person.details.v1.service.PersonDetailsService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;

import org.springframework.http.MediaType;
import za.co.wvz.person.details.v1.validation.CalculateAgeCategory;
import za.co.wvz.person.details.v1.validation.ValidatePersonDetails;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonDetailsController.class)
public class PersonDetailsRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonDetailsService personDetailsService;

    @MockBean
    ValidatePersonDetails validatePersonDetails;

    @MockBean
    CalculateAgeCategory calculateAgeCategory;

    @Test
    public void givenPersonDetails_whenGetAllPersonDetails_thenReturnJsonArray_Admin_User() throws Exception{
        List<PersonDetails> personDetailsList;
        personDetailsList = createPersonDetails();

        given(personDetailsService.findAll()).willReturn(personDetailsList);

        mvc.perform(get("/v1/person")
                .with(httpBasic("admin", "p@55w0rd"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(personDetailsList.get(0).getName())))
                .andExpect(jsonPath("$[0].age", is(personDetailsList.get(0).getAge())))
                .andExpect(jsonPath("$[0].ageCategory", is(personDetailsList.get(0).getAgeCategory())))
                .andExpect(jsonPath("$[1].name", is(personDetailsList.get(1).getName())))
                .andExpect(jsonPath("$[1].age", is(personDetailsList.get(1).getAge())))
                .andExpect(jsonPath("$[1].ageCategory", is(personDetailsList.get(1).getAgeCategory())));
    }

    @Test
    public void givenPersonDetails_whenGetAllPersonDetails_thenReturnJsonArray_Guest_User() throws Exception{
        List<PersonDetails> personDetailsList;
        personDetailsList = createPersonDetails();

        given(personDetailsService.findAll()).willReturn(personDetailsList);

        mvc.perform(get("/v1/person")
                .with(httpBasic("guest", "p@55w0rd1"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(personDetailsList.get(0).getName())))
                .andExpect(jsonPath("$[0].age", is(personDetailsList.get(0).getAge())))
                .andExpect(jsonPath("$[0].ageCategory", is(personDetailsList.get(0).getAgeCategory())))
                .andExpect(jsonPath("$[1].name", is(personDetailsList.get(1).getName())))
                .andExpect(jsonPath("$[1].age", is(personDetailsList.get(1).getAge())))
                .andExpect(jsonPath("$[1].ageCategory", is(personDetailsList.get(1).getAgeCategory())));
    }

    @Test
    public void givenPersonDetails_whenGetAllPersonDetails_thenReturnJsonArray_Forbidden_User() throws Exception{
        List<PersonDetails> personDetailsList;
        personDetailsList = createPersonDetails();

        given(personDetailsService.findAll()).willReturn(personDetailsList);

        mvc.perform(get("/v1/person")
                .with(httpBasic("user", "unauthorized"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    private List<PersonDetails> createPersonDetails(){
        PersonDetails firstPersonDetails = new PersonDetails();
        firstPersonDetails.setId(1);
        firstPersonDetails.setName("Luke");
        firstPersonDetails.setAge(33);
        firstPersonDetails.setAgeCategory("Middle");

        PersonDetails secondPersonDetails = new PersonDetails();
        secondPersonDetails.setId(2);
        secondPersonDetails.setName("Mark");
        secondPersonDetails.setAge(44);
        secondPersonDetails.setAgeCategory("Middle");

        List<PersonDetails> personDetails = new ArrayList<>();
        personDetails.add(firstPersonDetails);
        personDetails.add(secondPersonDetails);

        return personDetails;
    }


}
