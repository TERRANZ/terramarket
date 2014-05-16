
package ru.terramarket.gui.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wayBillDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wayBillDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{}commonDTO">
 *       &lt;sequence>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="selldate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="waybillItems" type="{}wayBillItemDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user" type="{}userDTO" minOccurs="0"/>
 *         &lt;element name="supplier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wayBillDTO", propOrder = {
    "count",
    "selldate",
    "waybillItems",
    "user",
    "supplier",
    "title"
})
public class WayBillDTO
    extends CommonDTO
{

    protected int count;
    protected Long selldate;
    @XmlElement(nillable = true)
    protected List<WayBillItemDTO> waybillItems;
    protected UserDTO user;
    protected String supplier;
    protected String title;

    /**
     * Gets the value of the count property.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(int value) {
        this.count = value;
    }

    /**
     * Gets the value of the selldate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSelldate() {
        return selldate;
    }

    /**
     * Sets the value of the selldate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSelldate(Long value) {
        this.selldate = value;
    }

    /**
     * Gets the value of the waybillItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the waybillItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWaybillItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WayBillItemDTO }
     * 
     * 
     */
    public List<WayBillItemDTO> getWaybillItems() {
        if (waybillItems == null) {
            waybillItems = new ArrayList<WayBillItemDTO>();
        }
        return this.waybillItems;
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

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplier(String value) {
        this.supplier = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
