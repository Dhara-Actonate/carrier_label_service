package com.actonate.carrier_label_service.view_model;

import com.actonate.carrier_label_service.model.Orders;
import com.actonate.carrier_label_service.model.ShipmentItems;
import com.actonate.carrier_label_service.model.Shipments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrierShipmentInfoViewModel {

    public String providerCode;

    public String carrierCode;

    public String carrierServiceCode;

    public Shipments shipmentInfo;

    public List<ShipmentItems> shipmentItems;

    public Orders orderInfo;

    public String configEnvironment =  null;
}
