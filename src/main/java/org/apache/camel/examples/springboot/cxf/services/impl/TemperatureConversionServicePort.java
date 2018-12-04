package org.apache.camel.examples.springboot.cxf.services.impl;

import org.apache.camel.examples.springboot.cxf.services.TemperatureConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Web Service implementation of {@link TemperatureConversionService}. <br />
 * Implemented this way to add all JAX-WS annotations to the class, being a wrapper to the actual service.
 */
@Component
public class TemperatureConversionServicePort implements TemperatureConversionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureConversionServicePort.class);
    private static final int THIRTY_TWO = 32;
    private static final double ONE_EIGHT = 1.8;

    @Override
    public Double convertFahrenheitToCelsius(Double fahrenheitValue) {
        LOGGER.info("Converting {} Fahrenheit to Celsius", fahrenheitValue);
        fahrenheitValue = this.sanitize(fahrenheitValue);

        return (fahrenheitValue - THIRTY_TWO) / ONE_EIGHT;
    }

    @Override
    public Double convertCelsiusToFahrenheit(Double celsiusValue) {
        LOGGER.info("Converting {} Celsius to Fahrenheit", celsiusValue);

        celsiusValue = this.sanitize(celsiusValue);

        return (celsiusValue * ONE_EIGHT) + THIRTY_TWO;
    }

    private Double sanitize(Double theValue) {
        if (theValue == null) {
            return 0d;
        }

        return theValue;
    }

}
