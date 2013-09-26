package br.com.smc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.gov.receita.fazenda.ws.cpf.PessoaPerfil3;

public class CPFDao {
	
	@SuppressWarnings("unchecked")
	public List<PessoaPerfil3> getCPFs(String... cpf){
		Session session = HibernateUtil.getSession();
		
		List<PessoaPerfil3> retorno = session.createCriteria(PessoaPerfil3.class)
		.add(Restrictions.in("cpf", cpf))
		.list();
		
		session.close();
		
		return retorno;
	}

	public void save(PessoaPerfil3 pp3) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(pp3);
		session.getTransaction().commit();
		
		session.close();
	}
	
}
