package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class DelhiveryProviderService extends ProviderService {

    @Override
    public void generateLabel(CarrierShipmentInfoViewModel shipmentDetail, JSONObject config) {
        // generate label logic here
    }
}
