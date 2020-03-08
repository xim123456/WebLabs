
package Lab1.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import Lab1.SimpleData;

@XmlRootElement(name = "UpdateData", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateData", namespace = "urn:SimpleService")
public class UpdateData {

    @XmlElement(name = "data", namespace = "")
    private SimpleData data;

    /**
     * 
     * @return
     *     returns SimpleData
     */
    public SimpleData getData() {
        return this.data;
    }

    /**
     * 
     * @param data
     *     the value for the data property
     */
    public void setData(SimpleData data) {
        this.data = data;
    }

}
