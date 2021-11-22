package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.repository.CarrierLabelsRepository;
import com.actonate.carrier_label_service.repository.CarriersRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarrierLabelsService {

    @Autowired
    private CarrierLabelsRepository carrierLabelsRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public CarrierLabels create(CarrierLabels toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        CarrierLabels saved = this.carrierLabelsRepository.save(toCreate);
        return saved;
    }


    public CarrierLabels update(CarrierLabels toUpdate, String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        CarrierLabels toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        CarrierLabels saved = this.carrierLabelsRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(CarrierLabels toValidate) throws BadRequestException{

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

    private Boolean validate(final CarrierLabels toValidate ) throws BadRequestException {
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

    public List<CarrierLabels> findAll() {
        return this.carrierLabelsRepository.findAll();
    }

    public CarrierLabels findById(String id) throws BadRequestException,NotFoundException {
        Optional<CarrierLabels> optionalData = this.carrierLabelsRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found Carriers with Id " + id
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        CarrierLabels entity = this.findById(id);


        entity.setDeleted(true);
        entity.setDeletedAt(new Date());

        this.update(entity, id);
        return true;

    }
}
