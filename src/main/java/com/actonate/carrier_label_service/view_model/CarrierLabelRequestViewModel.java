package com.actonate.carrier_label_service.view_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrierLabelRequestViewModel {
    public List<CarrierShipmentInfoViewModel> data = new ArrayList<>();
}
