package com.mvc.cloud_service.comm;

import com.mvc.cloud_service.dto.AddressResponse;

public interface AddressTransService {
    AddressResponse transmit(String uri);
}
