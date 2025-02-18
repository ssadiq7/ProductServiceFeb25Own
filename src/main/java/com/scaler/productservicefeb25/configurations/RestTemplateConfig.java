package com.scaler.productservicefeb25.configurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    // This class will be used to configure the RestTemplate bean
    // This bean will be used to make HTTP requests to the FakeStore API
    // The RestTemplate bean will be used in the FakeStoreProductService class
    // to make HTTP requests to the FakeStore API

    // Note: Name of the class and method doesn't make any difference.
    // Create a Bean of RestTemplate class and return it.

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
