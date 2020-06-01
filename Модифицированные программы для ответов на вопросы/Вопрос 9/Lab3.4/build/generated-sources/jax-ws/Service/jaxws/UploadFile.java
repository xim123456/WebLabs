
package Service.jaxws;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DeleteData", namespace = "http://Service/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteData", namespace = "http://Service/")
public class UploadFile {

    @XmlElement(name = "file", namespace = "")
    private DataHandler file;

    /**
     * 
     * @return
     *     returns DataHandler
     */
    public DataHandler getFile() {
        return this.file;
    }

    /**
     * 
     * @param file
     *     the value for the file property
     */
    public void setFile(DataHandler file) {
        this.file = file;
    }

}
