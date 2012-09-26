package br.gov.receita.fazenda.ws.cpf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultarCPFSoap", serviceName = "ConsultarCPFSoap", portName = "ConsultarCPFSoap", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
public class CpfWS {

	/**
	 * Consultar CPF Perfil 1
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil1
	 */
	@WebMethod(operationName = "ConsultarCPFP1", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP1")
	@WebResult(name = "ConsultarCPFP1Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP1", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP1")
	@ResponseWrapper(localName = "ConsultarCPFP1Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP1Response")
	public ArrayOfPessoaPerfil1 consultarCPFP1(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		System.out.println(">>> cpf: " + listaDeCPF);
		System.out.println(">>> cpfUsuario: " + cpfUsuario);
		return null;
	}

	/**
	 * Consultar Teste CPF Perfil 1
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil1
	 */
	@WebMethod(operationName = "ConsultarCPFP1T", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP1T")
	@WebResult(name = "ConsultarCPFP1TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP1T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP1T")
	@ResponseWrapper(localName = "ConsultarCPFP1TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP1TResponse")
	public ArrayOfPessoaPerfil1 consultarCPFP1T(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar CPF Perfil 2
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil2
	 */
	@WebMethod(operationName = "ConsultarCPFP2", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP2")
	@WebResult(name = "ConsultarCPFP2Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP2", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP2")
	@ResponseWrapper(localName = "ConsultarCPFP2Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP2Response")
	public ArrayOfPessoaPerfil2 consultarCPFP2(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar Teste CPF Perfil 2
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil2
	 */
	@WebMethod(operationName = "ConsultarCPFP2T", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP2T")
	@WebResult(name = "ConsultarCPFP2TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP2T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP2T")
	@ResponseWrapper(localName = "ConsultarCPFP2TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP2TResponse")
	public ArrayOfPessoaPerfil2 consultarCPFP2T(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar CPF Perfil 3
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil3
	 */
	@WebMethod(operationName = "ConsultarCPFP3", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP3")
	@WebResult(name = "ConsultarCPFP3Result", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP3", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP3")
	@ResponseWrapper(localName = "ConsultarCPFP3Response", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP3Response")
	public ArrayOfPessoaPerfil3 consultarCPFP3(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		return null;
	}

	/**
	 * Consultar Teste CPF Perfil 3
	 * 
	 * @param listaDeCPF
	 * @param cpfUsuario
	 * @return returns br.gov.receita.fazenda.ws.cpf.ArrayOfPessoaPerfil3
	 */
	@WebMethod(operationName = "ConsultarCPFP3T", action = "https://infoconv.receita.fazenda.gov.br/ws/cpf/ConsultarCPFP3T")
	@WebResult(name = "ConsultarCPFP3TResult", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/")
	@RequestWrapper(localName = "ConsultarCPFP3T", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP3T")
	@ResponseWrapper(localName = "ConsultarCPFP3TResponse", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/", className = "br.gov.receita.fazenda.ws.cpf.ConsultarCPFP3TResponse")
	public ArrayOfPessoaPerfil3 consultarCPFP3T(@WebParam(name = "ListaDeCPF", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String listaDeCPF, @WebParam(name = "CPFUsuario", targetNamespace = "https://infoconv.receita.fazenda.gov.br/ws/cpf/") String cpfUsuario) {
		return null;
	}

}
