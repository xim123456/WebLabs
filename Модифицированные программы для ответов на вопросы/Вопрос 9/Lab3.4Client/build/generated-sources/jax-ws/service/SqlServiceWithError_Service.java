
package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SqlServiceWithError", targetNamespace = "http://Service/", wsdlLocation = "http://desktop-vimllah:8080/Lab3/SqlServiceWithError?wsdl")
public class SqlServiceWithError_Service
    extends Service
{

    private final static URL SQLSERVICEWITHERROR_WSDL_LOCATION;
    private final static WebServiceException SQLSERVICEWITHERROR_EXCEPTION;
    private final static QName SQLSERVICEWITHERROR_QNAME = new QName("http://Service/", "SqlServiceWithError");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://desktop-vimllah:8080/Lab3/SqlServiceWithError?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SQLSERVICEWITHERROR_WSDL_LOCATION = url;
        SQLSERVICEWITHERROR_EXCEPTION = e;
    }

    public SqlServiceWithError_Service() {
        super(__getWsdlLocation(), SQLSERVICEWITHERROR_QNAME);
    }

    public SqlServiceWithError_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SQLSERVICEWITHERROR_QNAME, features);
    }

    public SqlServiceWithError_Service(URL wsdlLocation) {
        super(wsdlLocation, SQLSERVICEWITHERROR_QNAME);
    }

    public SqlServiceWithError_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SQLSERVICEWITHERROR_QNAME, features);
    }

    public SqlServiceWithError_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SqlServiceWithError_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SqlServiceWithError
     */
    @WebEndpoint(name = "SqlServiceWithErrorPort")
    public SqlServiceWithError getSqlServiceWithErrorPort() {
        return super.getPort(new QName("http://Service/", "SqlServiceWithErrorPort"), SqlServiceWithError.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SqlServiceWithError
     */
    @WebEndpoint(name = "SqlServiceWithErrorPort")
    public SqlServiceWithError getSqlServiceWithErrorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Service/", "SqlServiceWithErrorPort"), SqlServiceWithError.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SQLSERVICEWITHERROR_EXCEPTION!= null) {
            throw SQLSERVICEWITHERROR_EXCEPTION;
        }
        return SQLSERVICEWITHERROR_WSDL_LOCATION;
    }

}
