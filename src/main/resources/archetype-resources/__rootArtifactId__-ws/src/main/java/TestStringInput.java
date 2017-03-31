#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package};

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="range">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="enum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Audi"/>
 *               &lt;enumeration value="Golf"/>
 *               &lt;enumeration value="BMW"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fiveDigits">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;pattern value="[0-9][0-9][0-9][0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "range",
    "_enum",
    "fiveDigits"
})
@XmlRootElement(name = "testStringInput")
public class TestStringInput {

    protected int range;
    @XmlElement(name = "enum", required = true)
    protected String _enum;
    @XmlElement(required = true)
    protected BigInteger fiveDigits;

    /**
     * Gets the value of the range property.
     * 
     */
    public int getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     */
    public void setRange(int value) {
        this.range = value;
    }

    /**
     * Gets the value of the enum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnum() {
        return _enum;
    }

    /**
     * Sets the value of the enum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnum(String value) {
        this._enum = value;
    }

    /**
     * Gets the value of the fiveDigits property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFiveDigits() {
        return fiveDigits;
    }

    /**
     * Sets the value of the fiveDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFiveDigits(BigInteger value) {
        this.fiveDigits = value;
    }

}
