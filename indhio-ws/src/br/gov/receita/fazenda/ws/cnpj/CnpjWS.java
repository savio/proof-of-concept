package br.gov.receita.fazenda.ws.cnpj;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultarCNPJSoap", portName = "ConsultarCNPJSoap", serviceName = "ConsultarCNPJSoap", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
public class CnpjWS {

	/**
	 * Consultar CNPJ Perfil 1
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil1
	 */
	@WebMethod(operationName = "ConsultarCNPJP1", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP1")
	@WebResult(name = "ConsultarCNPJP1Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP1", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP1")
	@ResponseWrapper(localName = "ConsultarCNPJP1Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP1Response")
	public ArrayOfCNPJPerfil1 consultarCNPJP1(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		System.out.println(">>> cnpj: " + cnpj);
		System.out.println(">>> cpfUsuario: " + cpfUsuario);
		return null;
	}

	/**
	 * Consultar Teste CNPJ Perfil 1
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil1
	 */
	@WebMethod(operationName = "ConsultarCNPJP1T", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP1T")
	@WebResult(name = "ConsultarCNPJP1TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP1T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP1T")
	@ResponseWrapper(localName = "ConsultarCNPJP1TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP1TResponse")
	public ArrayOfCNPJPerfil1 consultarCNPJP1T(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar CNPJ Perfil 2
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil2
	 */
	@WebMethod(operationName = "ConsultarCNPJP2", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP2")
	@WebResult(name = "ConsultarCNPJP2Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP2", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP2")
	@ResponseWrapper(localName = "ConsultarCNPJP2Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP2Response")
	public ArrayOfCNPJPerfil2 consultarCNPJP2(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar Teste CNPJ Perfil 2
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil2
	 */
	@WebMethod(operationName = "ConsultarCNPJP2T", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP2T")
	@WebResult(name = "ConsultarCNPJP2TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP2T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP2T")
	@ResponseWrapper(localName = "ConsultarCNPJP2TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP2TResponse")
	public ArrayOfCNPJPerfil2 consultarCNPJP2T(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar CNPJ Perfil 3
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil3
	 */
	@WebMethod(operationName = "ConsultarCNPJP3", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP3")
	@WebResult(name = "ConsultarCNPJP3Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP3", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP3")
	@ResponseWrapper(localName = "ConsultarCNPJP3Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP3Response")
	public ArrayOfCNPJPerfil3 consultarCNPJP3(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar Teste CNPJ Perfil 3
	 * 
	 * @param cpfUsuario
	 * @param cnpj
	 * @return returns br.gov.receita.fazenda.ws.cnpj.ArrayOfCNPJPerfil3
	 */
	@WebMethod(operationName = "ConsultarCNPJP3T", action = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/ConsultarCNPJP3T")
	@WebResult(name = "ConsultarCNPJP3TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/")
	@RequestWrapper(localName = "ConsultarCNPJP3T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP3T")
	@ResponseWrapper(localName = "ConsultarCNPJP3TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/", className = "br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJP3TResponse")
	public ArrayOfCNPJPerfil3 consultarCNPJP3T(@WebParam(name = "CNPJ", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cnpj, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cnpj/") String cpfUsuario) {
		return null;
	}

}
