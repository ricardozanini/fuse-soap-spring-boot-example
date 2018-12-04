package org.apache.camel.examples.springboot.cxf.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * The service interface for temperature conversion
 * 
 * @author Ricardo Zanini
 */
@WebService(targetNamespace = "http://sample.org/", name = "TemperatureConversionService")
public interface TemperatureConversionService {

    @WebResult(name = "return", targetNamespace = "")
    Double convertFahrenheitToCelsius(@WebParam(name = "fahrenheitValue") Double fahrenheitValue);

    @WebResult(name = "return", targetNamespace = "")
    Double convertCelsiusToFahrenheit(@WebParam(name = "celsiusValue") Double celsiusValue);

}
