package com.actonate.carrier_label_service.view_model.bluedart;

import com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities.ArrayOfWayBillGenerationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BluedartLabelResponseViewModel {
    public byte[] awbPrintContent;
    public String ccrcrdref;
    public String destinationArea;
    public String destinationLocation;
    public Boolean isError;
    public ArrayOfWayBillGenerationStatus status;
}
