package com.mvc.cloud.repository;

import com.mvc.cloud.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
