package br.com.smc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.gov.receita.fazenda.ws.cnpj.CNPJPerfil3;

public class CNPJDao {
	
	@SuppressWarnings("unchecked")
	public List<CNPJPerfil3> getCNPJs(String... cnpj){
		Session session = HibernateUtil.getSession();
		List<CNPJPerfil3> retorno = session.createCriteria(CNPJPerfil3.class)
		.add(Restrictions.in("cnpj", cnpj))
		.list();
		session.close();
		
		return retorno;
	}
	
}
