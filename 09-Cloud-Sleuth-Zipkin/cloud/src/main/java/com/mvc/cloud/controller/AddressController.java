package com.mvc.cloud.controller;

import com.mvc.cloud.dto.AddressRequest;
import com.mvc.cloud.dto.AddressResponse;
import com.mvc.cloud.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    AddressService addressService;

    AddressController(AddressService service) {
        addressService = service;
    }

    @PostMapping("/new")
    public AddressResponse createAddress(@RequestBody AddressRequest request) {
        return addressService.createAddress(request);
    }

    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable Long id) {
        return addressService.getById(id);
    }


}
