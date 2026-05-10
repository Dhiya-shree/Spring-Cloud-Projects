package com.mvc.cloud_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoRequest {
    private String firstName;
    private String lastName;
    private String mail;
    private long addressId;
}
