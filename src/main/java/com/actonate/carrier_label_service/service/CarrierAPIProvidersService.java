package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.exceptions.BadRequestException;
import com.actonate.carrier_label_service.exceptions.ErrorCodes;
import com.actonate.carrier_label_service.exceptions.NotFoundException;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.repository.CarrierAPIProvidersRepository;
import com.actonate.carrier_label_service.utils.CopyObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarrierAPIProvidersService {

    @Autowired
    private CarrierAPIProvidersRepository carrierAPIProvidersRepository;

    @Autowired
    private CopyObjectUtil copyObjectUtil;

    public CarrierAPIProviders create(CarrierAPIProviders toCreate) throws BadRequestException {

        // validate the input payload and throw exception if not satisfying condition
        this.validate(toCreate);

        CarrierAPIProviders saved = this.carrierAPIProvidersRepository.save(toCreate);
        return saved;
    }


    public CarrierAPIProviders update(CarrierAPIProviders toUpdate,final String id) throws BadRequestException, NotFoundException {

        // validate the input payload and throw exception if not satisfying condition
        this.validateUpdate(toUpdate);

        CarrierAPIProviders toSave = this.findById(id);

        this.copyObjectUtil.copyNonNullProperties(toUpdate, toSave);
        CarrierAPIProviders saved = this.carrierAPIProvidersRepository.save(toSave);

        return saved;
    }

    private Boolean validateUpdate(CarrierAPIProviders toValidate) throws BadRequestException{

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

    private Boolean validate(final CarrierAPIProviders toValidate ) throws BadRequestException {
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

    public List<CarrierAPIProviders> findAll() {
        return this.carrierAPIProvidersRepository.findAll();
    }

    public CarrierAPIProviders findById(String id) throws BadRequestException,NotFoundException {
        Optional<CarrierAPIProviders> optionalData = this.carrierAPIProvidersRepository.findById(id);

        if (optionalData.isPresent()) {
           return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found CarrierAPIProvider with Id " + id
            );

        }
    }

    public CarrierAPIProviders findByCode(String code) throws BadRequestException,NotFoundException {
        Optional<CarrierAPIProviders> optionalData = this.carrierAPIProvidersRepository.findByCode(code);

        if (optionalData.isPresent()) {
            return optionalData.get();
        } else {
            throw new NotFoundException(
                    "Could not found CarrierAPIProvider with code " + code
            );

        }
    }

    public Boolean delete(String id) throws BadRequestException,NotFoundException {
        CarrierAPIProviders carrierAPIProvider = this.findById(id);


        carrierAPIProvider.setDeleted(true);
        carrierAPIProvider.setDeletedAt(new Date());

        this.update(carrierAPIProvider, id);
//            carrierAPIProvidersRepository.save(carrierAPIProvider);
            return true;

    }
}
