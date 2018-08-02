package br.com.casadocodigo.loja.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Relatorio;

@Controller
public class RelatorioProdutosController {

	@Autowired
	private ProdutoDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Relatorio gerarRelatorio() {
		Relatorio relatorio = new Relatorio();
		relatorio.setDataAtual(Calendar.getInstance());
		relatorio.setQuantidade(dao.relatorioQuantidade());
		relatorio.setProdutos(dao.relatorioItens());
		// dao.gravarRelatorio(relatorio);
		return relatorio;
	}

	@RequestMapping("/relatorio-produtos")
	@ResponseBody
	public Relatorio relatorioJson() {
		Relatorio relatorio = gerarRelatorio();
		System.out.println(relatorio);
		return relatorio;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public Relatorio gerarRelatorioData(Date data) {
//		System.out.println("Buscando dados");
//		Relatorio relatorio = new Relatorio();
//		System.out.println(dao.relatorioItensPorData(data));
//		System.out.println(dao.relatorioQuantidade());
//		relatorio.setDataAtual(Calendar.getInstance());
//		System.out.println("Inserindo Dados");
//		relatorio.setQuantidade(dao.relatorioQuantidade());
//		relatorio.setProdutos(dao.relatorioItensPorData(data));
//		System.out.println("Conferindo Relatorio");
//		System.out.println(relatorio.getProdutos());
//		System.out.println("qtdd relt: " + relatorio.getQuantidade());
//		// dao.gravarRelatorio(relatorio);
//		return relatorio;
//	}
//	@RequestMapping("/relatorio-produtos{date}")
//	@ResponseBody
//	public Relatorio relatorioDataJson(Date data) {
//		Relatorio relatorio = gerarRelatorioData(data);
//		System.out.println("Fim");
//		System.out.println(relatorio);
//		return relatorio;
//	}

}

//	
//	public Produto detalheJson(@PathVariable("id") Date ){
//	    Produto produto = dao.find(id);
//	    return produto;
//	}
