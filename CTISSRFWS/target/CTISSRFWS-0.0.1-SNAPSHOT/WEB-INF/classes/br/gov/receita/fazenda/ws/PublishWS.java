package br.gov.receita.fazenda.ws;

import javax.xml.ws.Endpoint;

import br.gov.receita.fazenda.ws.cnpj.CnpjWS;
import br.gov.receita.fazenda.ws.cpf.CpfWS;

public class PublishWS {

	public static void main(String[] args) {
		System.out.println(". . . ...");
		Endpoint.publish("http://localhost:9000/di-srf-ws-cnpj/", new CnpjWS());
		Endpoint.publish("http://localhost:9000/di-srf-ws-cpf/", new CpfWS());
		System.out.println("Servidor iniciado.");
	}

}
