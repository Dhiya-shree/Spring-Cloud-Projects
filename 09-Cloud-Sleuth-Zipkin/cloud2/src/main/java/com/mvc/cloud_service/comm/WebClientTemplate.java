package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Primary
public class WebClientTemplate implements AddressTransService{


    private WebClient webClient;

    @Override
    public AddressResponse transmit(String uri) {
        webClient= WebClient.builder().baseUrl(uri).build();
        Mono<AddressResponse> resp=webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(AddressResponse.class);
        return resp.block();
    }
}
