package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String valor;

	private Date data;

	@ElementCollection
	List<Produto> produtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return ("R$" + valor);
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		final DateFormat df = new SimpleDateFormat("dd/MM/yy");
		return df.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valor=" + valor + ", data=" + data + ", produtos=" + produtos + "]";
	}

}
