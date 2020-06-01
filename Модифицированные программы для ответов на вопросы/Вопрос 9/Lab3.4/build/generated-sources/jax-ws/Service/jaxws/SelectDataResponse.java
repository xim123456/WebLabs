
package Service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import SimpleObject.SimpleData;

@XmlRootElement(name = "SelectDataResponse", namespace = "http://Service/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectDataResponse", namespace = "http://Service/")
public class SelectDataResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private SimpleData[] _return;

    /**
     * 
     * @return
     *     returns SimpleData[]
     */
    public SimpleData[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(SimpleData[] _return) {
        this._return = _return;
    }

}
