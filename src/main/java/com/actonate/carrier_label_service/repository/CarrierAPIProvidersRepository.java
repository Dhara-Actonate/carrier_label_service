package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.model.Carriers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrierAPIProvidersRepository extends JpaRepository<CarrierAPIProviders, String> {

    Optional<CarrierAPIProviders> findByCode(String code);
}
