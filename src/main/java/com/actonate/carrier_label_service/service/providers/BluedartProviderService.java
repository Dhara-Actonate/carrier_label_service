package com.actonate.carrier_label_service.service.providers;

import com.actonate.carrier_label_service.model.CarrierLabels;
import com.actonate.carrier_label_service.utils.helpers.bluedart.BluedartLabelGenerationHelper;
import com.actonate.carrier_label_service.view_model.CarrierShipmentInfoViewModel;
import com.actonate.carrier_label_service.view_model.ProviderConfigViewModel;
import com.actonate.carrier_label_service.view_model.bluedart.BluedartLabelResponseViewModel;
import org.springframework.stereotype.Service;

@Service
public class BluedartProviderService extends ProviderService {

    @Override
    public CarrierLabels generateLabel(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        // generate label logic here
        System.out.println("::::::INSIDE generateLabel");
        CarrierLabels labelInfo = new CarrierLabels();
        try {


            BluedartLabelGenerationHelper helper = new BluedartLabelGenerationHelper();
            BluedartLabelResponseViewModel rawResponse = helper.generate(shipmentDetail, config);

            String responseLabelStr = rawResponse.toString();

            labelInfo.setLabelGenerateResponseRaw(responseLabelStr);

            // isError is true then Error
            if(rawResponse.getIsError()) {

                labelInfo.setLabelDownloadUrl("");
                labelInfo.setLabelGenerateStatus("ERROR");
            } else {
                // save link in shipment
                // download their doc & save in s3
        //        String labelUrl = responseEntityLabel.getBody().getLabel_url(); // will be replaced by AWS s3 URL
        //        labelInfo.setLabelDownloadUrl(labelUrl);
                labelInfo.setLabelDownloadUrl("");
                labelInfo.setLabelGenerateStatus("SUCCESS");
            }


        } catch (Exception e) {
            System.out.println("Generate Label Error:"+e.getMessage());
            labelInfo.setLabelDownloadUrl("");
            labelInfo.setLabelGenerateStatus("ERROR");
        }
        return new CarrierLabels();
    }

    @Override
    public String generateTrackingInfo(CarrierShipmentInfoViewModel shipmentDetail, ProviderConfigViewModel config) {
        return "";
    }
}
