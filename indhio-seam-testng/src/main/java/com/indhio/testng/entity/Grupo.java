package com.indhio.testng.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name = "grupo")
@SequenceGenerator(name = "sq_grupo", sequenceName = "sq_grupo")
@Name("grupo")
public class Grupo {

	private Long id;
	private String nome;
	private Set<Usuario> itens = new HashSet<Usuario>();

	@Id
	@GeneratedValue(generator = "sq_grupo", strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "id_grupo"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	public Set<Usuario> getItens() {
		return itens;
	}

	public void setItens(Set<Usuario> itens) {
		this.itens = itens;
	}

}
