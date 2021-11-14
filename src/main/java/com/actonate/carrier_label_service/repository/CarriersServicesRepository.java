package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.CarrierServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface CarriersServicesRepository  extends JpaRepository<CarrierServices, String> {
    Optional<CarrierServices> findByCode(String code);
}