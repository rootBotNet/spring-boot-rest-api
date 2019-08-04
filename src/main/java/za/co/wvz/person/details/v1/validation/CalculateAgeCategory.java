package za.co.wvz.person.details.v1.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculateAgeCategory {

    @Value("${v1.person.details.age.young}")
    private String YOUNG;

    @Value("${v1.person.details.age.middle}")
    private String MIDDLE;

    @Value("${v1.person.details.age.old}")
    private String OLD;

    public String getCategory(int age){

        if(age < 21){
            return YOUNG;
        }

        if(age < 45){
            return MIDDLE;
        }

        return OLD;
    }
}
