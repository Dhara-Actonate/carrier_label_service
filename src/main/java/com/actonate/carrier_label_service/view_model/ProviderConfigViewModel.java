package com.actonate.carrier_label_service.view_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderConfigViewModel {
    public String username;
    public String password;
    public String baseUrl;
}
