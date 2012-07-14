package com.indhio.testng.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.jboss.seam.annotations.Name;

@Entity
@Table(name = "perfil")
@SequenceGenerator(name = "sq_perfil", sequenceName = "sq_perfil")
@Name("perfil")
public class Perfil {

	private Long id;
	private String cnpj;
	private String razaoSocial;
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	@Id
	@GeneratedValue(generator = "sq_perfil", strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "cnpj")
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "razao_social")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@OneToMany(mappedBy = "empresa")
	@Cascade(CascadeType.ALL)
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
