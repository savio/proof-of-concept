
package br.gov.receita.fazenda.ws.cpf;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ConsultarCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", wsdlLocation = "file:/Users/indhio/workspace/java-jee-indigo/indhio-ws/src/CPF.wsdl")
public class ConsultarCPF
    extends Service
{

    private final static URL CONSULTARCPF_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.gov.receita.fazenda.ws.cpf.ConsultarCPF.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.gov.receita.fazenda.ws.cpf.ConsultarCPF.class.getResource(".");
            url = new URL(baseUrl, "file:/Users/indhio/workspace/java-jee-indigo/indhio-ws/src/CPF.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/Users/indhio/workspace/java-jee-indigo/indhio-ws/src/CPF.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CONSULTARCPF_WSDL_LOCATION = url;
    }

    public ConsultarCPF(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultarCPF() {
        super(CONSULTARCPF_WSDL_LOCATION, new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPF"));
    }

    /**
     * 
     * @return
     *     returns ConsultarCPFSoap
     */
    @WebEndpoint(name = "ConsultarCPFSoap")
    public ConsultarCPFSoap getConsultarCPFSoap() {
        return super.getPort(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFSoap"), ConsultarCPFSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConsultarCPFSoap
     */
    @WebEndpoint(name = "ConsultarCPFSoap")
    public ConsultarCPFSoap getConsultarCPFSoap(WebServiceFeature... features) {
        return super.getPort(new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFSoap"), ConsultarCPFSoap.class, features);
    }

}
