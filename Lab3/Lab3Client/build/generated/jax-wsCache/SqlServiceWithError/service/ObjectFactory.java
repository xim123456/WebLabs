
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _SelectDataResponse_QNAME = new QName("http://Service/", "SelectDataResponse");
    private final static QName _SelectData_QNAME = new QName("http://Service/", "SelectData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SelectData }
     * 
     */
    public SelectData createSelectData() {
        return new SelectData();
    }

    /**
     * Create an instance of {@link SelectDataResponse }
     * 
     */
    public SelectDataResponse createSelectDataResponse() {
        return new SelectDataResponse();
    }

    /**
     * Create an instance of {@link SimpleData }
     * 
     */
    public SimpleData createSimpleData() {
        return new SimpleData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "SelectDataResponse")
    public JAXBElement<SelectDataResponse> createSelectDataResponse(SelectDataResponse value) {
        return new JAXBElement<SelectDataResponse>(_SelectDataResponse_QNAME, SelectDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "SelectData")
    public JAXBElement<SelectData> createSelectData(SelectData value) {
        return new JAXBElement<SelectData>(_SelectData_QNAME, SelectData.class, null, value);
    }

}
