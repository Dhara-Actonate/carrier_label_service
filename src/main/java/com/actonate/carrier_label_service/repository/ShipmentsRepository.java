package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.Shipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ShipmentsRepository  extends JpaRepository<Shipments, String> {

}
