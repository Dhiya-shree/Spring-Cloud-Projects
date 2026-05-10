package com.mvc.cloud_service.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AddressHttpExchangeImpl {

//    @Bean
//    public RestClient.Builder restClientBuilder() {
//        // Application already has webclient
//        // web client reactive favored over http
//        return RestClient.builder();
//    }
//
//    @Lazy
//    @Autowired
//    GetEurekaClientUrl getEurekaClientUrl;

    @Bean
    @Lazy
    public AddressHttpExchange addressHttpExchange(@Qualifier("serviceRestClient") RestClient client){
        //With spring eureka use address name
        //RestClient client=builder.baseUrl("http://localhost:8080").build();

       // RestClient client=builder.baseUrl("cloud").build();

        HttpServiceProxyFactory factory=HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();

         return factory.createClient(AddressHttpExchange.class);
    }
}
