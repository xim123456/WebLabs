
package Lab1.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import Lab1.SimpleData;

@XmlRootElement(name = "SelectDataResponse", namespace = "urn:SimpleService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectDataResponse", namespace = "urn:SimpleService")
public class SelectDataResponse {

    @XmlElement(name = "SelectData", namespace = "")
    private List<SimpleData> selectData;

    /**
     * 
     * @return
     *     returns List<SimpleData>
     */
    public List<SimpleData> getSelectData() {
        return this.selectData;
    }

    /**
     * 
     * @param selectData
     *     the value for the selectData property
     */
    public void setSelectData(List<SimpleData> selectData) {
        this.selectData = selectData;
    }

}
