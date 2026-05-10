package com.mvc.cloud_service.repository;

import com.mvc.cloud_service.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Long> {
}
