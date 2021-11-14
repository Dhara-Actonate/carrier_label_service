package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.model.ShipmentItems;
import com.actonate.carrier_label_service.repository.CarriersRepository;
import com.actonate.carrier_label_service.repository.ShipmentItemsRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentItemsService {

    @Autowired
    private ShipmentItemsRepository shipmentItemsRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public ShipmentItems create(ShipmentItems toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        ShipmentItems saved = this.shipmentItemsRepository.save(toCreate);
        return saved;
    }


    public ShipmentItems update(ShipmentItems toUpdate,final String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        ShipmentItems toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        ShipmentItems saved = this.shipmentItemsRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(ShipmentItems toValidate) throws BadRequestException{

        String message = "";
        String prefix = "Invalid data in fields";


        if (message.isBlank() || message.isEmpty()) {
            return true;
        }

        throw new BadRequestException(
                prefix + " " + message,
                ErrorCodes.INVALID_DATA_EXCEPTION.getCode()
        );
    }

    private Boolean validate(final ShipmentItems toValidate ) throws BadRequestException {
        String message = "";
        String prefix = "Invalid data in fields";

//        if (toValidate.getName() == null || toValidate.getName().equals("")) {
//            message += "name";
//        }

        if (message.isBlank() || message.isEmpty()) {
            return true;
        }

        throw new BadRequestException(
                prefix + " " + message,
                ErrorCodes.INVALID_DATA_EXCEPTION.getCode()
        );
    }

    public List<ShipmentItems> findAll() {
        return this.shipmentItemsRepository.findAll();
    }

    public ShipmentItems findById(String id) throws BadRequestException,NotFoundException {
        Optional<ShipmentItems> optionalData = this.shipmentItemsRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found ShipmentItems with Id " + id
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        ShipmentItems entity = this.findById(id);


        entity.setIsDeleted(true);
        entity.setDeletedAt(new Date());

        this.update(entity, id);
        return true;

    }
}
