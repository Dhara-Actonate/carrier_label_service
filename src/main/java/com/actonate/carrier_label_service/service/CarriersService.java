package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierServices;
import com.actonate.carrier_label_service.model.Carriers;
import com.actonate.carrier_label_service.repository.CarriersRepository;
import com.actonate.carrier_label_service.repository.CarriersServicesRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarriersService {

    @Autowired
    private CarriersRepository carriersRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public Carriers create(Carriers toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        Carriers saved = this.carriersRepository.save(toCreate);
        return saved;
    }


    public Carriers update(Carriers toUpdate,final String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        Carriers toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        Carriers saved = this.carriersRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(Carriers toValidate) throws BadRequestException{

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

    private Boolean validate(final Carriers toValidate ) throws BadRequestException {
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

    public List<Carriers> findAll() {
        return this.carriersRepository.findAll();
    }

    public Carriers findById(String id) throws BadRequestException,NotFoundException {
        Optional<Carriers> optionalData = this.carriersRepository.findById(id);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found Carriers with Id " + id
            );

        }
    }

    public Carriers findByCode(String code) throws BadRequestException,NotFoundException {
        Optional<Carriers> optionalData = this.carriersRepository.findByCode(code);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found Carriers with code " + code
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        Carriers entity = this.findById(id);


        entity.setDeleted(true);
        entity.setDeletedAt(new Date());

        this.update(entity, id);
        return true;

    }
}
