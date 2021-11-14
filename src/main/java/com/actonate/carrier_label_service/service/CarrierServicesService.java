package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierServices;
import com.actonate.carrier_label_service.repository.CarriersServicesRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarrierServicesService {

    @Autowired
    private CarriersServicesRepository carriersServicesRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public CarrierServices create(CarrierServices toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        CarrierServices saved = this.carriersServicesRepository.save(toCreate);
        return saved;
    }


    public CarrierServices update(CarrierServices toUpdate,final String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        CarrierServices toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        CarrierServices saved = this.carriersServicesRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(CarrierServices toValidate) throws BadRequestException{

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

    private Boolean validate(final CarrierServices toValidate ) throws BadRequestException {
        String message = "";
        String prefix = "Invalid data in fields";

        if (toValidate.getName() == null || toValidate.getName().equals("")) {
            message += "name";
        }

        if (message.isBlank() || message.isEmpty()) {
            return true;
        }

        throw new BadRequestException(
                prefix + " " + message,
                ErrorCodes.INVALID_DATA_EXCEPTION.getCode()
        );
    }

    public List<CarrierServices> findAll() {
        return this.carriersServicesRepository.findAll();
    }

    public CarrierServices findById(String id) throws BadRequestException,NotFoundException {
        Optional<CarrierServices> optionalData = this.carriersServicesRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found CarrierServices with Id " + id
            );

        }
    }

    public CarrierServices findByCode(String code) throws BadRequestException,NotFoundException {
        Optional<CarrierServices> optionalData = this.carriersServicesRepository.findById(code);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found CarrierServices with code " + code
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        CarrierServices entity = this.findById(id);


        entity.setDeleted(true);
        entity.setDeletedAt(new Date());

        this.update(entity, id);
        return true;

    }
}
