
package ru.terramarket.gui.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sellItemDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sellItemDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{}commonDTO">
 *       &lt;sequence>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prod" type="{}productDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sellItemDTO", propOrder = {
    "count",
    "prod"
})
public class SellItemDTO
    extends CommonDTO
{

    protected Integer count;
    protected ProductDTO prod;

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Gets the value of the prod property.
     * 
     * @return
     *     possible object is
     *     {@link ProductDTO }
     *     
     */
    public ProductDTO getProd() {
        return prod;
    }

    /**
     * Sets the value of the prod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductDTO }
     *     
     */
    public void setProd(ProductDTO value) {
        this.prod = value;
    }

}
