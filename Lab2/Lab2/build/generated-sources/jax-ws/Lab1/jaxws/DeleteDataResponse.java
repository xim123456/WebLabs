
package Lab1.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DeleteDataResponse", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteDataResponse", namespace = "urn:SimpleService")
public class DeleteDataResponse {

    @XmlElement(name = "DeleteData", namespace = "")
    private String deleteData;

    /**
     * 
     * @return
     *     returns String
     */
    public String getDeleteData() {
        return this.deleteData;
    }

    /**
     * 
     * @param deleteData
     *     the value for the deleteData property
     */
    public void setDeleteData(String deleteData) {
        this.deleteData = deleteData;
    }

}
