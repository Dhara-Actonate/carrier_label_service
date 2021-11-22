package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.constants.CarrierConstants;
import com.actonate.carrier_label_service.constants.ShiprocketConstants;
import com.actonate.carrier_label_service.model.CarrierAPIProviders;
import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.service.CarrierAPIProvidersService;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import com.actonate.carrier_label_service.view_model.shprocket.ShiprocketLabelResponseViewModel;
import com.actonate.carrier_label_service.view_model.shprocket.ShiprocketTokenResponseViewModel;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@Service
public class ShiprocketProviderService extends ProviderService {

    @Autowired
    CarrierAPIProvidersService carrierAPIProvidersService;

    @Override
    public CarrierLabels generateLabel(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {

        CarrierLabels labelInfo = new CarrierLabels();

        try{
            System.out.println("inside ShiprocketProviderService.generateLabel"+ config+ config.getBaseUrl());
            // generate label logic here
//            String token = generateAccessToken(config);
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEyODU0NTAsImlzcyI6Imh0dHBzOi8vYXBpdjIuc2hpcHJvY2tldC5pbi92MS9leHRlcm5hbC9hdXRoL2xvZ2luIiwiaWF0IjoxNjM3NTkwNzIzLCJleHAiOjE2Mzg0NTQ3MjMsIm5iZiI6MTYzNzU5MDcyMywianRpIjoiTGxvR3BUZ2JHNjNuRWdObCJ9.-mmcuZYFc2RcuhyNONTBJnvwv9dH2la8N9Ce5EoE6nY";

            String printLabelURL = config.getBaseUrl() + ShiprocketConstants.LABEL_URL;

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

            ResponseEntity<ShiprocketLabelResponseViewModel> responseEntityLabel = restTemplate.postForEntity(printLabelURL, request, ShiprocketLabelResponseViewModel.class);

            assertNotNull(responseEntityLabel.getBody());
            assertNotNull(responseEntityLabel.getBody().getLabel_url());

            System.out.println("responseEntityPerson:"+responseEntityLabel+ responseEntityLabel.getBody() );
            System.out.println("Label URL:"+responseEntityLabel.getBody().getLabel_url());

            String responseLabelStr = responseEntityLabel.toString();
            // check response status if other than 200 , set error status

            labelInfo.setLabelGenerateResponseRaw(responseLabelStr);

            System.out.println("Validate:"+responseEntityLabel.getBody().getLabel_created() + responseEntityLabel.getBody().getLabel_created() instanceof String);
            System.out.println("Validate:"+responseEntityLabel.getBody().getNot_created().size() + responseEntityLabel.getBody().getNot_created().size() instanceof String);

            // gives 1 status on success & not_created is []
            if(responseEntityLabel.getBody().getLabel_created() == 1 && responseEntityLabel.getBody().getNot_created().size() == 0) {
                // save link in shipment
                // download their doc & save in s3
                String labelUrl = responseEntityLabel.getBody().getLabel_url(); // will be replaced by AWS s3 URL
                labelInfo.setLabelDownloadUrl(labelUrl);
                labelInfo.setLabelGenerateStatus("SUCCESS");
            } else {
                labelInfo.setLabelDownloadUrl("");
                labelInfo.setLabelGenerateStatus("ERROR");
            }

        } catch (Exception e) {
            System.out.println("Error in shiprocket label:"+e.getMessage());
            labelInfo.setLabelDownloadUrl("");
            labelInfo.setLabelGenerateStatus("ERROR");

        }

        return labelInfo;
    }

    public String generateAccessToken(ProviderConfigViewModel config) throws Exception {
        try {
            System.out.println("inside ShiprocketProviderService.generateAccessToken");

            String loginUrl = config.getBaseUrl() + ShiprocketConstants.TOKEN_GEN_URL;

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            System.out.println("loginUrl:"+loginUrl);

            JSONObject personJsonObject = new JSONObject();
            personJsonObject.put("email", config.getUsername());
            personJsonObject.put("password", config.getPassword());

            HttpEntity<JSONObject> request = new HttpEntity<>(personJsonObject, headers);

            System.out.println("personJsonObject:"+personJsonObject+request);

            ResponseEntity<ShiprocketTokenResponseViewModel> responseEntityPerson = restTemplate.postForEntity(loginUrl, request, ShiprocketTokenResponseViewModel.class);

            System.out.println("responseEntityPerson:"+responseEntityPerson+ responseEntityPerson.getBody() );

            System.out.println("Here::"+responseEntityPerson.getBody().getToken());
            assertNotNull(responseEntityPerson.getBody());
            assertNotNull(responseEntityPerson.getBody().getToken());

            return responseEntityPerson.getBody().getToken();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            throw new Exception(e);
        }

    }

    @Override
    public String generateTrackingInfo(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        try {
            System.out.println("inside ShiprocketProviderService.generateTrackingInfo");
            // track label logic here
//            String token = generateAccessToken(config);
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEyODU0NTAsImlzcyI6Imh0dHBzOi8vYXBpdjIuc2hpcHJvY2tldC5pbi92MS9leHRlcm5hbC9hdXRoL2xvZ2luIiwiaWF0IjoxNjM3NTkwNzIzLCJleHAiOjE2Mzg0NTQ3MjMsIm5iZiI6MTYzNzU5MDcyMywianRpIjoiTGxvR3BUZ2JHNjNuRWdObCJ9.-mmcuZYFc2RcuhyNONTBJnvwv9dH2la8N9Ce5EoE6nY";

            String trackingURL = config.getBaseUrl() + ShiprocketConstants.TRACKING_URL; // racking with multiple AWBs

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer "+token);

            System.out.println("trackingURL:"+trackingURL);

            JSONObject personJsonObject = new JSONObject();
            ArrayList<String> awbs = new ArrayList();
            // awb_code is needed from shipment creation response - as of now shipments.awbCode
            awbs.add(shipmentDetail.getShipmentInfo().getAwbNo());
            personJsonObject.put("awbs", awbs);

            HttpEntity<JSONObject> request = new HttpEntity<>(personJsonObject, headers);

            ResponseEntity<String> responseEntityTracking = restTemplate.postForEntity(trackingURL, request, String.class);

            System.out.println("======generateTrackingInfo responseEntityTracking:"+responseEntityTracking);
            assertNotNull(responseEntityTracking.getBody());

            return responseEntityTracking.getBody();

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());

            return "";
        }

    }
}

/*

async getShipmentTrackingDetailsByMultipleAWBs(awbs) {
    const shipmentTrackingMultipleAWBsURL = `${baseURL}/courier/track/awbs`;
    const shiprocket_token = await strapi.services.shipments.getShiprocketToken();

    const headers = {
        Authorization: `Bearer ${shiprocket_token}`,
        "Content-Type": "application/json",
      };

    try {
      const result = await axios.post(
        shipmentTrackingMultipleAWBsURL,
        { awbs: [...awbs] },
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
  }

 */