package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.constants.DelhiveryConstants;
import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import com.actonate.carrier_label_service.view_model.delhivery.DelhiveryLabelResponseViewModel;
import com.actonate.carrier_label_service.view_model.shprocket.ShiprocketLabelResponseViewModel;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
public class DelhiveryProviderService extends ProviderService {

    @Override
    public CarrierLabels generateLabel(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        CarrierLabels labelInfo = new CarrierLabels();

        try{

            String token = config.getToken();

            String printLabelURL = config.getBaseUrl() + DelhiveryConstants.LABEL_URL + shipmentDetail.getShipmentInfo().getAwbNo();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Token "+token);

            System.out.println("printLabelURL:"+printLabelURL);

            HttpEntity<JSONObject> request = new HttpEntity<>(headers);

            ResponseEntity<DelhiveryLabelResponseViewModel> responseEntityLabel = restTemplate.exchange(
                    printLabelURL,
                    HttpMethod.GET,
                    request,
                    DelhiveryLabelResponseViewModel.class,1

            );

            assertNotNull(responseEntityLabel.getBody());
//            assertNotNull(responseEntityLabel.getBody().getPackages());

            System.out.println("responseEntityLabel:"+responseEntityLabel+ responseEntityLabel.getBody() );


            String responseLabelStr = responseEntityLabel.toString();
            // check response status if other than 200 , set error status

            labelInfo.setLabelGenerateResponseRaw(responseLabelStr);

            System.out.println("Validate:"+responseEntityLabel.getBody().getPackages_found() + responseEntityLabel.getBody().getPackages_found() instanceof String);
            System.out.println("Validate:"+responseEntityLabel.getBody().getPackages().size() + responseEntityLabel.getBody().getPackages().size() instanceof String);

            // gives 1 status on success & not_created is []
            if(responseEntityLabel.getBody().getPackages_found() == 1 && responseEntityLabel.getBody().getPackages().size() > 0) {
                // save link in shipment
                // download their doc & save in s3
                String labelUrl = responseEntityLabel.getBody().getPackages().get(0); // will be replaced by AWS s3 URL
                labelInfo.setLabelDownloadUrl(labelUrl);
                labelInfo.setLabelGenerateStatus("SUCCESS");
            } else {
                labelInfo.setLabelDownloadUrl("");
                labelInfo.setLabelGenerateStatus("ERROR");
            }



        } catch (Exception e) {
            System.out.println("Error in Delhivery label:"+e.getMessage());
            labelInfo.setLabelDownloadUrl("");
            labelInfo.setLabelGenerateStatus("ERROR");

        }

        return labelInfo;
    }

    public String generateOrderForCarrier() {
        // body
        // format=json&data={"pickup_location":{"pin":520007,"add":"LETSSHAVE","phone":"9848125125","state":"Andhra Pradesh","city":"Vijayawada","country":"India","name":"LETSSHAVE"},"shipments":[{"add":"LETSSHAVE","return_name":"LETSSHAVE","return_pin":"520007","return_city":"Vijayawada","return_phone":"9848125125","return_add":"54-11-5,PLOT NO 11 7TH ROAD 7TH ROAD VIJAYAWADA JAWAHAR AUTO NAGAR , Vijayawada, Andhra Pradesh ,India","return_state":"Andhra Pradesh","return_country":"India","order":"61604e8de45b4c407cea0b68","phone":"8989898989","products_desc":"Testing","cod_amount":"45","name":"Diwahar M","order_date":"2018-05-18 06:22:43","total_amount":"510","pin":"636006","quantity":"10","payment_mode":"Pre­paid","state":"Tamil Nadu","city":"Salem","client":"LETSSHAVE"}]}
        return "";
    }

    @Override
    public String generateTrackingInfo(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {

        String trackingURL = config.getBaseUrl() + DelhiveryConstants.TRACKING_URL+"?token="+config.getToken()+"&waybill="+shipmentDetail.getShipmentInfo().getAwbNo(); // tracking with multiple AWBs

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("trackingURL:"+trackingURL);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> request = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntityTracking = restTemplate.exchange(
                trackingURL,
                HttpMethod.GET,
                request,
                String.class,1

        );

        System.out.println("======generateTrackingInfo delhivery responseEntityTracking:"+responseEntityTracking);
        assertNotNull(responseEntityTracking.getBody());

        return responseEntityTracking.getBody();
    }
}
