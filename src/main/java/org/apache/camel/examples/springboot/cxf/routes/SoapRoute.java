package org.apache.camel.examples.springboot.cxf.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.examples.springboot.cxf.services.TemperatureConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SoapRoute extends RouteBuilder {
    
    @Autowired
    private TemperatureConversionService service;

    @Override
    public void configure() throws Exception {
        from("cxf:bean:temperatureConversionServiceEndpoint")
            .log("Hello route! Here's my body ${in.body}")
            .log("And this is my headers: ${in.headers}")
            .recipientList(simple("direct:${in.headers.operationName}"));

        from("direct:convertFahrenheitToCelsius")
            .bean(service, "convertFahrenheitToCelsius");

        from("direct:convertCelsiusToFahrenheit")
            .bean(service, "convertCelsiusToFahrenheit");
    }

}
