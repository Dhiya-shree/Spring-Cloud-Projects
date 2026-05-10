package com.mvc.cloud_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressResponse {
    private long addressId;
    private String street;
    private String city;

    public AddressResponse(String body) {
    }
}
