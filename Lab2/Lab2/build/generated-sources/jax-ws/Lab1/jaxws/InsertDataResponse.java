
package Lab1.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertDataResponse", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertDataResponse", namespace = "urn:SimpleService")
public class InsertDataResponse {

    @XmlElement(name = "InsertData", namespace = "")
    private String insertData;

    /**
     * 
     * @return
     *     returns String
     */
    public String getInsertData() {
        return this.insertData;
    }

    /**
     * 
     * @param insertData
     *     the value for the insertData property
     */
    public void setInsertData(String insertData) {
        this.insertData = insertData;
    }

}
