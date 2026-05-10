package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}",
//name = "AddressFeignClient")
@SuppressWarnings("unused")
public interface AddressServiceFeignClient {

    @GetMapping("/api/address/{id}")
    public AddressResponse getById(@PathVariable Long id);
}
