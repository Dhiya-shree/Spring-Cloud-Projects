package com.mvc.cloud_service.service;

import com.mvc.cloud_service.dto.AddressResponse;
import com.mvc.cloud_service.dto.InfoRequest;
import com.mvc.cloud_service.dto.InfoResponse;

public interface InfoService {
    InfoResponse createInfo(InfoRequest request);
    InfoResponse getById(Long id);
    AddressResponse getAddressById(Long id);

}
