package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;

import java.util.List;

public interface CarrierLabelGeneratorService {

//    void generateLabelBulk(List<CarrierShipmentInfoViewModel> shipmentDetails);

    void generateLabel(CarrierShipmentInfoViewModel shipmentDetail);
}
