package com.mvc.cloud_service.comm;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
@SuppressWarnings("unused")
public class ConfigLB {


    @Bean
    @LoadBalanced
    public RestClient.Builder lbRestClientBuilder() {
        return RestClient.builder();
    }

    // Non-loadbalanced builder for internal processes (e.g., Eureka)
    @Bean
    @Primary
    public RestClient.Builder directRestClientBuilder() {
        return RestClient.builder();
    }


    // You can then inject this builder elsewhere or use it to create specific RestClient instances
    @Bean
    @Primary
    public RestClient serviceRestClient( @Qualifier("lbRestClientBuilder") RestClient.Builder loadBalancedRestClientBuilder) {
        // Use the logical service name (e.g., "provider"), not a hardcoded URL
        return loadBalancedRestClientBuilder.baseUrl("cloud").build();
    }


//
//    @Bean(name = "LB_RestClientBuilder")
//    @LoadBalanced
//    @Primary
//    public RestClient.Builder LB_RestClientBuilder() {
//        System.out.println(" Rest builder");
//        // Application already has webclient
//        // web client reactive favored over http
//        return RestClient.builder();
//    }
}
