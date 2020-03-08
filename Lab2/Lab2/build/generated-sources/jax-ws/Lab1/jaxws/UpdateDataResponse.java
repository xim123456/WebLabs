
package Lab1.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "UpdateDataResponse", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateDataResponse", namespace = "urn:SimpleService")
public class UpdateDataResponse {

    @XmlElement(name = "UpdateData", namespace = "")
    private String updateData;

    /**
     * 
     * @return
     *     returns String
     */
    public String getUpdateData() {
        return this.updateData;
    }

    /**
     * 
     * @param updateData
     *     the value for the updateData property
     */
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

}
