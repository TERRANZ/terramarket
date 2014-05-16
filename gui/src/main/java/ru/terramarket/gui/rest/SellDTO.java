
package ru.terramarket.gui.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sellDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sellDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{}commonDTO">
 *       &lt;sequence>
 *         &lt;element name="sellDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sellItems" type="{}sellItemDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user" type="{}userDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sellDTO", propOrder = {
    "sellDate",
    "sellItems",
    "user"
})
public class SellDTO
    extends CommonDTO
{

    protected Long sellDate;
    @XmlElement(nillable = true)
    protected List<SellItemDTO> sellItems;
    protected UserDTO user;

    /**
     * Gets the value of the sellDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSellDate() {
        return sellDate;
    }

    /**
     * Sets the value of the sellDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSellDate(Long value) {
        this.sellDate = value;
    }

    /**
     * Gets the value of the sellItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sellItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSellItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SellItemDTO }
     * 
     * 
     */
    public List<SellItemDTO> getSellItems() {
        if (sellItems == null) {
            sellItems = new ArrayList<SellItemDTO>();
        }
        return this.sellItems;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserDTO }
     *     
     */
    public UserDTO getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserDTO }
     *     
     */
    public void setUser(UserDTO value) {
        this.user = value;
    }

}
