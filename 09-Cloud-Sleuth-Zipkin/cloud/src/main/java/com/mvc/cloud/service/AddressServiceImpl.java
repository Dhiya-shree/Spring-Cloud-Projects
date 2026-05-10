package com.mvc.cloud.service;

import com.mvc.cloud.dto.AddressRequest;
import com.mvc.cloud.dto.AddressResponse;
import com.mvc.cloud.entity.Address;
import com.mvc.cloud.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    AddressRepository repo;

    AddressServiceImpl(AddressRepository repository) {
        this.repo = repository;
    }

    @Override
    public AddressResponse createAddress(AddressRequest request) {
        LOGGER.info("Creating new address .....");
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        Address saved = repo.save(address);
        return new AddressResponse(saved);
    }

    @Override
    public AddressResponse getById(long id) {
        LOGGER.info("Inside get by Id ....." + id);
        return new AddressResponse(repo.findById(id).orElse(new Address((long) 0, "Default", "Default")));
    }
}
