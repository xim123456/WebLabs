
/*
 * 
 */

package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.3
 * Wed May 27 15:29:20 MSK 2020
 * Generated source version: 2.2.3
 * 
 */


@WebServiceClient(name = "SqlServiceWithError", 
                  wsdlLocation = "file:/C:/Users/xxim1/Desktop/Projects/Project%201/Lab3.2Client/src/main/resources/wsdl/SqlServiceWithError.wsdl",
                  targetNamespace = "http://Service/") 
public class SqlServiceWithError_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://Service/", "SqlServiceWithError");
    public final static QName SqlServiceWithErrorPort = new QName("http://Service/", "SqlServiceWithErrorPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/xxim1/Desktop/Projects/Project%201/Lab3.2Client/src/main/resources/wsdl/SqlServiceWithError.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/Users/xxim1/Desktop/Projects/Project%201/Lab3.2Client/src/main/resources/wsdl/SqlServiceWithError.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public SqlServiceWithError_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SqlServiceWithError_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SqlServiceWithError_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns SqlServiceWithError
     */
    @WebEndpoint(name = "SqlServiceWithErrorPort")
    public SqlServiceWithError getSqlServiceWithErrorPort() {
        return super.getPort(SqlServiceWithErrorPort, SqlServiceWithError.class);
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
        return super.getPort(SqlServiceWithErrorPort, SqlServiceWithError.class, features);
    }

}
