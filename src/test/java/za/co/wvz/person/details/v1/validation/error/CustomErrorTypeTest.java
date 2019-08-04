package za.co.wvz.person.details.v1.validation.error;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomErrorTypeTest {

    private CustomErrorType customErrorType;

    @Before
    public void setUp() throws Exception {
        this.customErrorType = new CustomErrorType("Custom error message test string!");
    }

    @Test
    public void testCustomErrorMessageTrue(){
        String testMessage = customErrorType.getErrorMessage();
        Assert.assertEquals("Custom error message test string!", testMessage);
    }
}