package br.com.smc;

import java.util.Random;

import br.gov.receita.fazenda.ws.cpf.PessoaPerfil3;

public class PopularBD {
	public static void main(String[] args) {
		CPFDao dao = new CPFDao();
//
//		for (int i = 0; i < 100; i++) {
//			PessoaPerfil3 pp3 = new PessoaPerfil3();
//			pp3.setNome("Pessoa " + i);
//			pp3.setAnoObito("");
//			pp3.setBairro("ok");
//			pp3.setCEP("ok");
//			pp3.setCodigoMunicipio("ok");
//			pp3.setCodigoPaisExterior("ok");
//			pp3.setComplemento("ok");
//			pp3.setCPF(gerarCPF());
//			pp3.setDataNascimento("ok");
//			pp3.setDDD("ok");
//			pp3.setEstrangeiro("ok");
//			pp3.setExercicioOcupacao("ok");
//			pp3.setLogradouro("ok");
//			pp3.setMunicipio("ok");
//			pp3.setNaturezaOcupacao("ok");
//			pp3.setNomeMae("ok");
//			pp3.setNomePaisExterior("ok");
//			pp3.setNumeroLogradouro("ok");
//			pp3.setOcupacaoPrincipal("ok");
//			pp3.setResidenteExterior("ok");
//			pp3.setSexo("ok");
//			pp3.setTelefone("ok");
//			pp3.setUF("ok");
//			pp3.setDataAtualizacao("ok");
//			pp3.setSituacaoCadastral("ok");
//			pp3.setTituloEleitor("ok");
//			pp3.setUnidadeAdministrativa("ok");
//			pp3.setTipoLogradouro("ok");
//			
//			dao.save(pp3);
//		}
		
		System.out.println(dao.getCPFs(new String[]{"68811831512"}).get(0)
				.getNome());
	}

	public static String gerarCPF(){
		Random r = new Random(System.currentTimeMillis() + 1);
		int a1 = r.nextInt(9), a2 = r.nextInt(9), a3 = r.nextInt(9),
				a4 = r.nextInt(9), a5 = r.nextInt(9), a6 = r.nextInt(9),
				a7 = r.nextInt(9), a8 = r.nextInt(9), a9 = r.nextInt(9);
		int b1 = a1 * 10,
				b2 = a2 * 9,
				b3 = a3 * 8,
				b4 = a4 * 7,
				b5 = a5 * 6,
				b6 = a6 * 5,
				b7 = a7 * 4,
				b8 = a8 * 3,
				b9 = a9 * 2;
		int DV1 = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9;
		int T1 = DV1 / 11;
		int T2 = DV1 % 11;// Cálculo do resto da divisão
		int Primeiro_Digito_Verificador;
		if (T2 <= 2)
			Primeiro_Digito_Verificador = 0;
		else
			Primeiro_Digito_Verificador = 11 - T2;

		int c1 = a1 * 11,
				c2 = a2 * 10,
				c3 = a3 * 9,
				c4 = a4 * 8,
				c5 = a5 * 7,
				c6 = a6 * 6,
				c7 = a7 * 5,
				c8 = a8 * 4,
				c9 = a9 * 3,
				c10 = Primeiro_Digito_Verificador * 2;
		int DV2 = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10;
		int T3 = DV2 / 11;
		int T4 = DV2 % 11; // Cálculo do resto da divisão
		int Segundo_Digito_Verificador;
		if (T4 <= 2)
			Segundo_Digito_Verificador = 0;
		else
			Segundo_Digito_Verificador = 11 - T4;

		return "" + a1 + a2 + a3+
				a4 + a5 + a6 + a7 + a8 + a9 + Primeiro_Digito_Verificador + Segundo_Digito_Verificador;

	}
}
