package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.ShipmentItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ShipmentItemsRepository  extends JpaRepository<ShipmentItems, String> {

}