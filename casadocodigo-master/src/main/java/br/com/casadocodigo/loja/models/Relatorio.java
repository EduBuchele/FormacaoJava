package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@DateTimeFormat
	private Calendar dataAtual;

	private long quantidade;

	@ElementCollection
	List<Produto> produtos;

	public Calendar getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Calendar dataAtual) {
		this.dataAtual = dataAtual;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public long getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return "[Data Solicitação: " + this.dataAtual + ", Quantidade" + this.getQuantidade() + ", Produtos: "
				+ this.getProdutos() + "]";
	}
}
