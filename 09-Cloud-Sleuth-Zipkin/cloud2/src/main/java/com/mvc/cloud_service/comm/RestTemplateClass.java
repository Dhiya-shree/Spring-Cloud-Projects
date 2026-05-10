package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class RestTemplateClass implements AddressTransService {

    private static final RestTemplate restTemplate=new RestTemplate();

    @Override
    public AddressResponse transmit(String uri) {
        System.out.println("Rest template call ");
        return restTemplate.getForEntity(uri, AddressResponse.class).getBody();
    }
}
