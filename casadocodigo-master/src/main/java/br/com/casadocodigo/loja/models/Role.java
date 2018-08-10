package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private boolean ckbRole;

	public boolean isCkbRole() {
		return ckbRole;
	}

	public void setCkbRole(boolean ckbRole) {
		this.ckbRole = ckbRole;
	}

	public Role() {
	}

	public Role(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}

	@Override
	public String toString() {

		return this.nome;
	}

}