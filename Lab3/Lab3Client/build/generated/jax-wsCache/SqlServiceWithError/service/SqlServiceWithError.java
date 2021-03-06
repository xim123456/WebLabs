
package service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SqlServiceWithError", targetNamespace = "http://Service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SqlServiceWithError {


    /**
     * 
     * @param data
     * @return
     *     returns java.util.List<service.SimpleData>
     */
    @WebMethod(operationName = "SelectData")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SelectData", targetNamespace = "http://Service/", className = "service.SelectData")
    @ResponseWrapper(localName = "SelectDataResponse", targetNamespace = "http://Service/", className = "service.SelectDataResponse")
    @Action(input = "http://Service/SqlServiceWithError/SelectDataRequest", output = "http://Service/SqlServiceWithError/SelectDataResponse")
    public List<SimpleData> selectData(
        @WebParam(name = "data", targetNamespace = "")
        SimpleData data);

}
