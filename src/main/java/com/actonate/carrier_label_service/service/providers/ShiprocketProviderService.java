package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.constants.ShiprocketConstants;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.service.CarrierAPIProvidersService;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.shprocket.ShiprocketLabelResponseViewModel;
import com.actonate.carrier_label_service.view_model.shprocket.ShiprocketTokenResponseViewModel;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Service
public class ShiprocketProviderService extends ProviderService {

    private String baseUrl = "https://apiv2.shiprocket.in/v1/external";


    @Autowired
    CarrierAPIProvidersService carrierAPIProvidersService;

    @Override
    public void generateLabel(CarrierShipmentInfoViewModel shipmentDetail, JSONObject config) {

        System.out.println("inside ShiprocketProviderService.generateLabel");
        // generate label logic here
//        String token = generateAccessToken(config);
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEyODU0NTAsImlzcyI6Imh0dHBzOi8vYXBpdjIuc2hpcHJvY2tldC5pbi92MS9leHRlcm5hbC9hdXRoL2xvZ2luIiwiaWF0IjoxNjM2NjM0MTk3LCJleHAiOjE2Mzc0OTgxOTcsIm5iZiI6MTYzNjYzNDE5NywianRpIjoiTFptWUNTWThPRDV2aWo3UyJ9.rpZTJwVgrWNJyxmxmt-fm_qc2gZhoVQ0IbYA5BYSZXo";

        String printLabelURL = config.get("baseUrl") + ShiprocketConstants.LABEL_URL;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token);

        System.out.println("printLabelURL:"+printLabelURL);

        JSONObject personJsonObject = new JSONObject();
        ArrayList<String> shipmentIds = new ArrayList();
        // shipment_tracking_number is needed from shipment creation response - as of now shipments.trackingCode
        shipmentIds.add(shipmentDetail.getShipmentInfo().getTrackingCode());
        personJsonObject.put("shipment_id", shipmentIds);

        HttpEntity<JSONObject> request = new HttpEntity<>(personJsonObject, headers);

        ResponseEntity<ShiprocketLabelResponseViewModel> responseEntityPerson = restTemplate.
                postForEntity(printLabelURL, request, ShiprocketLabelResponseViewModel.class);

        System.out.println("responseEntityPerson:"+responseEntityPerson+ responseEntityPerson.getBody() );
        System.out.println("Label URL:"+responseEntityPerson.getBody().getLabel_url());

        // save link in shipment
        // download their doc & save in s3
    }

    public void generateAccessToken(JSONObject config) {
        System.out.println("inside ShiprocketProviderService.generateAccessToken");

        String loginUrl = baseUrl + ShiprocketConstants.TOKEN_GEN_URL;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        System.out.println("loginUrl:"+loginUrl);

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("email", config.get("username"));
        personJsonObject.put("password", config.get("password"));

        HttpEntity<JSONObject> request = new HttpEntity<>(personJsonObject, headers);

        System.out.println("personJsonObject:"+personJsonObject+request);

        ResponseEntity<ShiprocketTokenResponseViewModel> responseEntityPerson = restTemplate.
                postForEntity(loginUrl, request, ShiprocketTokenResponseViewModel.class);

        System.out.println("responseEntityPerson:"+responseEntityPerson+ responseEntityPerson.getBody() );

        System.out.println("Here::"+responseEntityPerson.getBody().getToken());
//        assertNotNull(responseEntityPerson.getBody());
//        assertNotNull(responseEntityPerson.getBody().getName());
    }
}

/*

baseURL = https://apiv2.shiprocket.in/v1/external
 async printLabelForOrder(shipment_id) {
    const printLabelURL = `${baseURL}/courier/generate/label`;
    const shiprocket_token = await strapi.services.shipments.getShiprocketToken();

    const headers = {
        Authorization: `Bearer ${shiprocket_token}`,
        "Content-Type": "application/json",
      };

    try {
      const result = await axios.post(
        printLabelURL,
        {
          shipment_id: [shipment_id],
        },
        {
          headers,
        }
      );

      console.log("result:", result.data);
      return result.data;
    } catch (error) {
      console.log("error:", error);
      throw error;
    }
  },


  async loginToShiprocket() {
    // call shipment api
    const loginURL = `${baseURL}/auth/login`;
    try {
      const requestBody = {
        email: process.env.SHIPROCKET_EMAIL,
        password: process.env.SHIPROCKET_PASSWORD,
      };
      console.log("loginURL:", loginURL, requestBody);
      const result = await axios.post(loginURL, requestBody, {
        "Content-Type": "application/json",
      });

      console.log("result:", result.data);
      return result.data;
    } catch (error) {
      console.log("error:", error);
      throw error;
    }
  }

 */