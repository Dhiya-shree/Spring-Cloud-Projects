package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api/address")
public interface AddressHttpExchange {

    @GetMapping("/{id}")
    AddressResponse getById(@PathVariable Long id);

}
