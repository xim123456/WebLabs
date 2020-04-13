
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpleData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fild1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fild2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fild3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fild4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleData", propOrder = {
    "fild1",
    "fild2",
    "fild3",
    "fild4",
    "id"
})
public class SimpleData {

    protected String fild1;
    protected String fild2;
    protected String fild3;
    protected String fild4;
    protected String id;

    public SimpleData() {
        id = fild1 = fild2 = fild3 = fild4 = "";
    }
    
    public SimpleData(String id, String fild1, String fild2, String fild3, String fild4) {
        this.id = id;
        this.fild1 = fild1;
        this.fild2 = fild2;
        this.fild3 = fild3;
        this.fild4 = fild4;
    }
    
    /**
     * Gets the value of the fild1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFild1() {
        return fild1;
    }

    /**
     * Sets the value of the fild1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFild1(String value) {
        this.fild1 = value;
    }

    /**
     * Gets the value of the fild2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFild2() {
        return fild2;
    }

    /**
     * Sets the value of the fild2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFild2(String value) {
        this.fild2 = value;
    }

    /**
     * Gets the value of the fild3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFild3() {
        return fild3;
    }

    /**
     * Sets the value of the fild3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFild3(String value) {
        this.fild3 = value;
    }

    /**
     * Gets the value of the fild4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFild4() {
        return fild4;
    }

    /**
     * Sets the value of the fild4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFild4(String value) {
        this.fild4 = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
