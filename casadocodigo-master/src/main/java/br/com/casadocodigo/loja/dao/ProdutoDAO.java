package br.com.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Relatorio;
import br.com.casadocodigo.loja.models.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class)
				.getResultList();
	}

	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id",
				Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco) {
		TypedQuery<BigDecimal> query = manager.createQuery(
				"select sum(preco.valor) from Produto p join p.precos preco " + "where preco.tipo = :tipoPreco",
				BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco);
		return query.getSingleResult();
	}

	public void gravarRelatorio(Relatorio relatorio) {
		manager.persist(relatorio);
	}

	public Long relatorioQuantidade() {
		TypedQuery<Long> query = manager.createQuery("select count(p) from Produto p", Long.class);
		return query.getSingleResult();
	}

	public List<Produto> relatorioItens() {
		return manager.createQuery("select distinct(p) from Produto p group by dataLancamento ", Produto.class)
				.getResultList();
	}

	public List<Produto> relatorioItensPorData(Date data) {
		return manager
				.createQuery("select distinct(p) from Produto p where dataLancamento = :dataLancamento", Produto.class)
				.setParameter("Date", data).getResultList();
	}

}