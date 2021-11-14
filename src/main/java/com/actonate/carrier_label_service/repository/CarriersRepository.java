package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.Carriers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface CarriersRepository  extends JpaRepository<Carriers, String> {

    Optional<Carriers> findByCode(String code);
}