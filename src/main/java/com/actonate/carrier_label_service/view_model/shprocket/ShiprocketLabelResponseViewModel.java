package com.actonate.carrier_label_service.view_model.shprocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiprocketLabelResponseViewModel {
    public int label_created;

    public String label_url;

    public String response;

    public List<String> not_created;
}

// ,{"label_created":1,"label_url":"https:\/\/kr-shipmultichannel.s3.ap-southeast-1.amazonaws.com\/938833\/labels\/1636635000_shipping-label-120939721-281034683397.pdf","response":"Label has been created and uploaded successfully!","not_created":[]}