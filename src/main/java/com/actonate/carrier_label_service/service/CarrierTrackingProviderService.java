package com.actonate.carrier_label_service.service;

import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;

public interface CarrierTrackingProviderService {
    void trackShipment(CarrierShipmentInfoViewModel shipmentDetail) throws Exception;
}
