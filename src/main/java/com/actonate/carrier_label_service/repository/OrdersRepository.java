package com.actonate.carrier_label_service.repository;

import com.actonate.carrier_label_service.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, String> {
}
