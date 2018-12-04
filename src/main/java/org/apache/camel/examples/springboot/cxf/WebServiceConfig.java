package org.apache.camel.examples.springboot.cxf;

import java.util.Collections;
import javax.annotation.PostConstruct;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.examples.springboot.cxf.services.TemperatureConversionService;
import org.apache.cxf.Bus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @PostConstruct
    public void init() {
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);
        bus.setFeatures(Collections.singleton(loggingFeature));
    }

    @Bean
    public LoggingOutInterceptor loggingOutInterceptor() {
        return new LoggingOutInterceptor();
    }

    @Bean
    public LoggingInInterceptor loggingInInterceptor() {
        return new LoggingInInterceptor();
    }

    @Bean
    public GZIPInInterceptor gzipInInterceptor() {
        return new GZIPInInterceptor();
    }

    @Bean
    public GZIPOutInterceptor gzipOutInterceptor() {
        return new GZIPOutInterceptor();
    }

    @Bean
    public CxfEndpoint temperatureConversionServiceEndpoint() {
        CxfEndpoint endpoint = new CxfEndpoint();
        endpoint.setAddress("/TemperatureEndpoint");
        endpoint.setBeanId("temperatureConversionServiceEndpoint");
        endpoint.setServiceClass(TemperatureConversionService.class);
        return endpoint;
    }
}
