
package br.gov.receita.fazenda.ws.cpf;

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
 *         &lt;element name="ListaDeCPF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CPFUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "listaDeCPF",
    "cpfUsuario"
})
@XmlRootElement(name = "ConsultarCPFP3T")
public class ConsultarCPFP3T {

    @XmlElement(name = "ListaDeCPF")
    protected String listaDeCPF;
    @XmlElement(name = "CPFUsuario")
    protected String cpfUsuario;

    /**
     * Gets the value of the listaDeCPF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListaDeCPF() {
        return listaDeCPF;
    }

    /**
     * Sets the value of the listaDeCPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListaDeCPF(String value) {
        this.listaDeCPF = value;
    }

    /**
     * Gets the value of the cpfUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFUsuario() {
        return cpfUsuario;
    }

    /**
     * Sets the value of the cpfUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFUsuario(String value) {
        this.cpfUsuario = value;
    }

}
