package com.actonate.carrier_label_service.view_model.delhivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelhiveryLabelResponseViewModel {
    public List<String> packages = new ArrayList();
    public int packages_found = 0;
}
