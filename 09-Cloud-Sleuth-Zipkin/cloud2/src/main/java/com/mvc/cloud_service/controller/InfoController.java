package com.mvc.cloud_service.controller;

import com.mvc.cloud_service.dto.AddressResponse;
import com.mvc.cloud_service.dto.InfoRequest;
import com.mvc.cloud_service.dto.InfoResponse;
import com.mvc.cloud_service.service.InfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    InfoService service;

    public InfoController(InfoService service){
        this.service=service;
    }

    @PostMapping("/new")
    public InfoResponse createAddress(@RequestBody InfoRequest request){
        return service.createInfo(request);
    }

    @GetMapping("/{id}")
    public InfoResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("/{id}/address")
    public AddressResponse getAddressById(@PathVariable Long id){
        return service.getAddressById(id);
    }



}
