package br.gov.receita.fazenda.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.gov.receita.fazenda.ws.cnpj.ConsultarCNPJ;
import br.gov.receita.fazenda.ws.cpf.ConsultarCPF;

public class ClientWS {

	public static void main(String[] args) {
		try {
			testCnpjWS();
			testCpfWS();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private static void testCnpjWS() throws MalformedURLException {
		// URL wsdlLocation = new URL("http://localhost:9000/di-srf-ws-cnpj/?wsdl");
		URL wsdlLocation = new URL("http://localhost:8080/indhio-ws/di-srf-cnpj-ws?wsdl");
		QName qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cnpj/", "ConsultarCNPJSoap");
		ConsultarCNPJ consultarCNPJ = new ConsultarCNPJ(wsdlLocation, qName);
		consultarCNPJ.getConsultarCNPJSoap().consultarCNPJP1("CNPJ ", "ccccc nnnnn ppppp jjjjjj");
	}

	private static void testCpfWS() throws MalformedURLException {
		// URL wsdlLocation = new URL("http://localhost:9000/di-srf-ws-cpf/?wsdl");
		URL wsdlLocation = new URL("http://localhost:8080/indhio-ws/di-srf-cpf-ws?wsdl");
		QName qName = new QName("https://infoconv.receita.fazenda.gov.br/ws/cpf/", "ConsultarCPFSoap");
		ConsultarCPF consultarCPF = new ConsultarCPF(wsdlLocation, qName);
		consultarCPF.getConsultarCPFSoap().consultarCPFP1("CPF", "cccc ppppp fff ");
	}

}
