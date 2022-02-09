
package com.actonate.carrier_label_service.utils.helpers.bluedart.org.tempuri;

import com.actonate.carrier_label_service.utils.helpers.bluedart.org.datacontract.schemas._2004._07.sapi_entities.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ImportDataResponseImportDataResult_QNAME = new QName("http://tempuri.org/", "ImportDataResult");
    private final static QName _GenerateWayBillRequest_QNAME = new QName("http://tempuri.org/", "Request");
    private final static QName _GenerateWayBillProfile_QNAME = new QName("http://tempuri.org/", "Profile");
    private final static QName _GenerateWayBillResponseGenerateWayBillResult_QNAME = new QName("http://tempuri.org/", "GenerateWayBillResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateWayBill }
     * 
     */
    public GenerateWayBill createGenerateWayBill() {
        return new GenerateWayBill();
    }

    /**
     * Create an instance of {@link GenerateWayBillResponse }
     * 
     */
    public GenerateWayBillResponse createGenerateWayBillResponse() {
        return new GenerateWayBillResponse();
    }

    /**
     * Create an instance of {@link ImportDataResponse }
     * 
     */
    public ImportDataResponse createImportDataResponse() {
        return new ImportDataResponse();
    }

    /**
     * Create an instance of {@link ImportData }
     * 
     */
    public ImportData createImportData() {
        return new ImportData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWayBillGenerationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ImportDataResult", scope = ImportDataResponse.class)
    public JAXBElement<ArrayOfWayBillGenerationResponse> createImportDataResponseImportDataResult(ArrayOfWayBillGenerationResponse value) {
        return new JAXBElement<ArrayOfWayBillGenerationResponse>(_ImportDataResponseImportDataResult_QNAME, ArrayOfWayBillGenerationResponse.class, ImportDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillGenerationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Request", scope = GenerateWayBill.class)
    public JAXBElement<WayBillGenerationRequest> createGenerateWayBillRequest(WayBillGenerationRequest value) {
        return new JAXBElement<WayBillGenerationRequest>(_GenerateWayBillRequest_QNAME, WayBillGenerationRequest.class, GenerateWayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Profile", scope = GenerateWayBill.class)
    public JAXBElement<UserProfile> createGenerateWayBillProfile(UserProfile value) {
        return new JAXBElement<UserProfile>(_GenerateWayBillProfile_QNAME, UserProfile.class, GenerateWayBill.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillGenerationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GenerateWayBillResult", scope = GenerateWayBillResponse.class)
    public JAXBElement<WayBillGenerationResponse> createGenerateWayBillResponseGenerateWayBillResult(WayBillGenerationResponse value) {
        return new JAXBElement<WayBillGenerationResponse>(_GenerateWayBillResponseGenerateWayBillResult_QNAME, WayBillGenerationResponse.class, GenerateWayBillResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWayBillGenerationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Request", scope = ImportData.class)
    public JAXBElement<ArrayOfWayBillGenerationRequest> createImportDataRequest(ArrayOfWayBillGenerationRequest value) {
        return new JAXBElement<ArrayOfWayBillGenerationRequest>(_GenerateWayBillRequest_QNAME, ArrayOfWayBillGenerationRequest.class, ImportData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Profile", scope = ImportData.class)
    public JAXBElement<UserProfile> createImportDataProfile(UserProfile value) {
        return new JAXBElement<UserProfile>(_GenerateWayBillProfile_QNAME, UserProfile.class, ImportData.class, value);
    }

}
