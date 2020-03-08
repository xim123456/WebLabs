
package Lab1.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DeleteData", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteData", namespace = "urn:SimpleService")
public class DeleteData {

    @XmlElement(name = "idData", namespace = "")
    private int idData;

    /**
     * 
     * @return
     *     returns int
     */
    public int getIdData() {
        return this.idData;
    }

    /**
     * 
     * @param idData
     *     the value for the idData property
     */
    public void setIdData(int idData) {
        this.idData = idData;
    }

}
