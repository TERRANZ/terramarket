
package ru.terramarket.gui.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="groupDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{}commonDTO">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productList" type="{}productDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupDTO", propOrder = {
    "name",
    "parent",
    "productList"
})
public class GroupDTO
    extends CommonDTO
{

    protected String name;
    protected int parent;
    @XmlElement(nillable = true)
    protected List<ProductDTO> productList;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     */
    public int getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     */
    public void setParent(int value) {
        this.parent = value;
    }

    /**
     * Gets the value of the productList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductDTO }
     * 
     * 
     */
    public List<ProductDTO> getProductList() {
        if (productList == null) {
            productList = new ArrayList<ProductDTO>();
        }
        return this.productList;
    }

}
