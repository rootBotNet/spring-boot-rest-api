package za.co.wvz.person.details.v1.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.wvz.person.details.v1.entity.PersonDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDetailsRowMapper implements RowMapper<PersonDetails> {
    @Override
    public PersonDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(resultSet.getInt("id"));
        personDetails.setName(resultSet.getString("name"));
        personDetails.setAge(resultSet.getInt("age"));
        personDetails.setAgeCategory(resultSet.getString("ageCategory"));
        return personDetails;
    }
}
