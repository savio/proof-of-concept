
package br.gov.receita.fazenda.ws.cnpj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Socio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Socio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PercentualParticipacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoPaisOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NomePaisOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Socio", propOrder = {
    "tipo",
    "nome",
    "numero",
    "percentualParticipacao",
    "codigoPaisOrigem",
    "nomePaisOrigem"
})
@Entity
@Table(name="socio")
public class Socio {
	@XmlTransient
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @XmlElement(name = "Tipo")
    protected String tipo;
    @XmlElement(name = "Nome")
    protected String nome;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "PercentualParticipacao")
    protected String percentualParticipacao;
    @XmlElement(name = "CodigoPaisOrigem")
    protected String codigoPaisOrigem;
    @XmlElement(name = "NomePaisOrigem")
    protected String nomePaisOrigem;

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the percentualParticipacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPercentualParticipacao() {
        return percentualParticipacao;
    }

    /**
     * Sets the value of the percentualParticipacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPercentualParticipacao(String value) {
        this.percentualParticipacao = value;
    }

    /**
     * Gets the value of the codigoPaisOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPaisOrigem() {
        return codigoPaisOrigem;
    }

    /**
     * Sets the value of the codigoPaisOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPaisOrigem(String value) {
        this.codigoPaisOrigem = value;
    }

    /**
     * Gets the value of the nomePaisOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePaisOrigem() {
        return nomePaisOrigem;
    }

    /**
     * Sets the value of the nomePaisOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePaisOrigem(String value) {
        this.nomePaisOrigem = value;
    }

}
