
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

    private final static QName _BadFormatException_QNAME = new QName("http://Service/", "BadFormatException");
    private final static QName _DeleteDataResponse_QNAME = new QName("http://Service/", "DeleteDataResponse");
    private final static QName _InsertDataResponse_QNAME = new QName("http://Service/", "InsertDataResponse");
    private final static QName _SelectDataResponse_QNAME = new QName("http://Service/", "SelectDataResponse");
    private final static QName _UpdateDataResponse_QNAME = new QName("http://Service/", "UpdateDataResponse");
    private final static QName _IdNotFoundException_QNAME = new QName("http://Service/", "IdNotFoundException");
    private final static QName _SelectData_QNAME = new QName("http://Service/", "SelectData");
    private final static QName _InsertData_QNAME = new QName("http://Service/", "InsertData");
    private final static QName _DeleteData_QNAME = new QName("http://Service/", "DeleteData");
    private final static QName _UpdateData_QNAME = new QName("http://Service/", "UpdateData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IdNotFoundException }
     * 
     */
    public IdNotFoundException createIdNotFoundException() {
        return new IdNotFoundException();
    }

    /**
     * Create an instance of {@link SelectData }
     * 
     */
    public SelectData createSelectData() {
        return new SelectData();
    }

    /**
     * Create an instance of {@link UpdateData }
     * 
     */
    public UpdateData createUpdateData() {
        return new UpdateData();
    }

    /**
     * Create an instance of {@link InsertDataResponse }
     * 
     */
    public InsertDataResponse createInsertDataResponse() {
        return new InsertDataResponse();
    }

    /**
     * Create an instance of {@link DeleteData }
     * 
     */
    public DeleteData createDeleteData() {
        return new DeleteData();
    }

    /**
     * Create an instance of {@link BadFormatException }
     * 
     */
    public BadFormatException createBadFormatException() {
        return new BadFormatException();
    }

    /**
     * Create an instance of {@link SelectDataResponse }
     * 
     */
    public SelectDataResponse createSelectDataResponse() {
        return new SelectDataResponse();
    }

    /**
     * Create an instance of {@link InsertData }
     * 
     */
    public InsertData createInsertData() {
        return new InsertData();
    }

    /**
     * Create an instance of {@link UpdateDataResponse }
     * 
     */
    public UpdateDataResponse createUpdateDataResponse() {
        return new UpdateDataResponse();
    }

    /**
     * Create an instance of {@link SimpleData }
     * 
     */
    public SimpleData createSimpleData() {
        return new SimpleData();
    }

    /**
     * Create an instance of {@link ErrorBean }
     * 
     */
    public ErrorBean createErrorBean() {
        return new ErrorBean();
    }

    /**
     * Create an instance of {@link DeleteDataResponse }
     * 
     */
    public DeleteDataResponse createDeleteDataResponse() {
        return new DeleteDataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadFormatException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "BadFormatException")
    public JAXBElement<BadFormatException> createBadFormatException(BadFormatException value) {
        return new JAXBElement<BadFormatException>(_BadFormatException_QNAME, BadFormatException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "DeleteDataResponse")
    public JAXBElement<DeleteDataResponse> createDeleteDataResponse(DeleteDataResponse value) {
        return new JAXBElement<DeleteDataResponse>(_DeleteDataResponse_QNAME, DeleteDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "InsertDataResponse")
    public JAXBElement<InsertDataResponse> createInsertDataResponse(InsertDataResponse value) {
        return new JAXBElement<InsertDataResponse>(_InsertDataResponse_QNAME, InsertDataResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "UpdateDataResponse")
    public JAXBElement<UpdateDataResponse> createUpdateDataResponse(UpdateDataResponse value) {
        return new JAXBElement<UpdateDataResponse>(_UpdateDataResponse_QNAME, UpdateDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "IdNotFoundException")
    public JAXBElement<IdNotFoundException> createIdNotFoundException(IdNotFoundException value) {
        return new JAXBElement<IdNotFoundException>(_IdNotFoundException_QNAME, IdNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "SelectData")
    public JAXBElement<SelectData> createSelectData(SelectData value) {
        return new JAXBElement<SelectData>(_SelectData_QNAME, SelectData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "InsertData")
    public JAXBElement<InsertData> createInsertData(InsertData value) {
        return new JAXBElement<InsertData>(_InsertData_QNAME, InsertData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "DeleteData")
    public JAXBElement<DeleteData> createDeleteData(DeleteData value) {
        return new JAXBElement<DeleteData>(_DeleteData_QNAME, DeleteData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "UpdateData")
    public JAXBElement<UpdateData> createUpdateData(UpdateData value) {
        return new JAXBElement<UpdateData>(_UpdateData_QNAME, UpdateData.class, null, value);
    }

}
