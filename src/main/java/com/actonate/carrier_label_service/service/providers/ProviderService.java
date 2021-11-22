package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import org.json.JSONException;
import org.json.simple.JSONObject;

public abstract class ProviderService {

    public abstract CarrierLabels generateLabel(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config);

    public abstract String generateTrackingInfo(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) throws JSONException;

}
