package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import org.json.simple.JSONObject;

public abstract class ProviderService {

    public abstract void generateLabel(CarrierShipmentInfoViewModel shipmentDetail, JSONObject config);
}
