package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.ShipmentItems;
import com.actonate.carrier_label_service.model.Shipments;
import com.actonate.carrier_label_service.repository.ShipmentItemsRepository;
import com.actonate.carrier_label_service.repository.ShipmentsRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentsService {

    @Autowired
    private ShipmentsRepository shipmentsRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public Shipments create(Shipments toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        Shipments saved = this.shipmentsRepository.save(toCreate);
        return saved;
    }


    public Shipments update(Shipments toUpdate,final String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        Shipments toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        Shipments saved = this.shipmentsRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(Shipments toValidate) throws BadRequestException{

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

    private Boolean validate(final Shipments toValidate ) throws BadRequestException {
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

    public List<Shipments> findAll() {
        return this.shipmentsRepository.findAll();
    }

    public Shipments findById(String id) throws BadRequestException,NotFoundException {
        Optional<Shipments> optionalData = this.shipmentsRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found ShipmentItems with Id " + id
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        Shipments entity = this.findById(id);


        entity.setDeleted(true);
        entity.setDeletedAt(new Date());

        this.update(entity, id);
        return true;

    }
}
