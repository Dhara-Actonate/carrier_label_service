package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.model.Orders;
import com.actonate.carrier_label_service.repository.CarriersRepository;
import com.actonate.carrier_label_service.repository.OrdersRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;



    public List<Orders> findAll() {
        return this.ordersRepository.findAll();
    }

    public Orders findById(String id) throws BadRequestException,NotFoundException {
        Optional<Orders> optionalData = this.ordersRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found Orders with Id " + id
            );

        }
    }

}
