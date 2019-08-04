package za.co.wvz.person.details.v1.validation;

import org.springframework.stereotype.Component;

@Component
public class ValidatePersonDetails {

    public boolean isUserEmpty(long id){
        if(id == 0) {
            return true;
        }
        return false;
    }
}
