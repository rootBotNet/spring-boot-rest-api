package za.co.wvz.person.details.v1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.wvz.person.details.v1.entity.PersonDetails;
import za.co.wvz.person.details.v1.repository.rowmapper.PersonDetailsRowMapper;

import java.util.List;

@Repository
public class PersonDetailsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(PersonDetails personDetails) {
        return jdbcTemplate.update(
                "insert into person_details ( name, age, ageCategory ) " + "values(?, ?, ?)",
                new Object[]{personDetails.getName(), personDetails.getAge(), personDetails.getAgeCategory() });
    }

    public List<PersonDetails> findAll() {
        return jdbcTemplate.query("select * from person_details", new PersonDetailsRowMapper());
    }

    public PersonDetails getById(int id) {
        try{
            return jdbcTemplate.queryForObject("select * from person_details where id= ?", new Object[] {id}, new PersonDetailsRowMapper());
        } catch (Exception e){}
        return new PersonDetails();
    }
}
