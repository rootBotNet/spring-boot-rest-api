package za.co.wvz.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestPropertiesConfiguration {

    @Value("${application.username.admin}")
    private String usernameAdmin;

    public String retrieveAdminUserNameProperty(){
        return usernameAdmin;
    }
}
