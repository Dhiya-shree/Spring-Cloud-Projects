package com.mvc.cloud.service;

import com.mvc.cloud.dto.AddressRequest;
import com.mvc.cloud.dto.AddressResponse;

public interface AddressService {
    AddressResponse createAddress(AddressRequest request);

    AddressResponse getById(long id);
}
