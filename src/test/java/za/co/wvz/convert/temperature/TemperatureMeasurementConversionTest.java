package za.co.wvz.convert.temperature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TemperatureMeasurementConversionTest {

    @TestConfiguration
    static class DefaultTemperatureMeasurementConversionTest{
        @Bean
        public TemperatureMeasurementConversion temperatureMeasurementConversion(){
            return new TemperatureMeasurementConversion();
        }
    }

    @Autowired
    private TemperatureMeasurementConversion temperatureMeasurementConversion;

    @Before
    public void setup(){
        this.temperatureMeasurementConversion = new TemperatureMeasurementConversion();
    }

    @Test
    public void test_Convert_Celsius_To_Fahrenheit(){
        Assert.assertEquals(75.2, temperatureMeasurementConversion.convertCelsiusToFahrenheit(24), 0.00001);
    }
}
