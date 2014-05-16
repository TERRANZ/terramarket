
package ru.terramarket.gui.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loginDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loginDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{}commonDTO">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginDTO", propOrder = {
    "message",
    "logged",
    "session"
})
public class LoginDTO
    extends CommonDTO
{

    protected String message;
    protected boolean logged;
    protected String session;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the logged property.
     * 
     */
    public boolean isLogged() {
        return logged;
    }

    /**
     * Sets the value of the logged property.
     * 
     */
    public void setLogged(boolean value) {
        this.logged = value;
    }

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSession(String value) {
        this.session = value;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "message='" + message + '\'' +
                ", logged=" + logged +
                ", session='" + session + '\'' +
                "} " + super.toString();
    }
}
