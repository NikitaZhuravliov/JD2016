//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.30 at 12:15:44 PM MSK 
//


package by.it.Baranova.JD02.JD02_09.generate;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for First_Bed_size.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="First_Bed_size">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="twin"/>
 *     &lt;enumeration value="double"/>
 *     &lt;enumeration value="queen"/>
 *     &lt;enumeration value="king"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "First_Bed_size")
@XmlEnum
public enum FirstBedSize {

    @XmlEnumValue("twin")
    TWIN("twin"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("queen")
    QUEEN("queen"),
    @XmlEnumValue("king")
    KING("king");
    private final String value;

    FirstBedSize(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FirstBedSize fromValue(String v) {
        for (FirstBedSize c: FirstBedSize.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
