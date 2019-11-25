package za.co.wvz.convert.temperature;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TemperatureMeasurementConversion {

    @Value("${convert.temperature.cenversion.rate}")
    private double CONVERSION_RATE;

    @Value("${convert.temperature.addition.subtraction.rate}")
    private double ADDITION_SUBTRACTION_NUMBER;

    /**
     * Fahrenheit = (Celsius x (9/5)) + 32
     * or
     * Fahrenheit = (Celsius x 1.8) + 32
     */
    public double convertCelsiusToFahrenheit(double degreeCelsius){
        return (degreeCelsius * CONVERSION_RATE) + ADDITION_SUBTRACTION_NUMBER;
    }

    /**
     * Celsius = (Fahrenheit - 32) x (5/9)
     * or
     * Celsius = (Fahrenheit - 32) / 1.8
     */
    public double convertFahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - ADDITION_SUBTRACTION_NUMBER) / CONVERSION_RATE;
    }

}
