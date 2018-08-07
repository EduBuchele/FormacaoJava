package br.com.casadocodigo.loja.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Relatorio;

@Controller
public class RelatorioProdutosController {

	@Autowired
	private ProdutoDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Relatorio gerarRelatorio(String data) throws Exception {
		// Data inserida na URL
		// System.out.println("_________________________" + data);

		// Formatando String para Calendar
		Calendar dataFormatada = GregorianCalendar.getInstance();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		dataFormatada.setTime(formatador.parse(data));

		// Imprimindo data formatada
		// System.out.println("_________________________" + dataFormatada);

		Relatorio relatorio = new Relatorio();
		relatorio.setDataAtual(Calendar.getInstance());
		relatorio.setQuantidade(dao.relatorioQuantidade());
		System.out.println("TSte");
		relatorio.setProdutos(dao.relatorioItensPorData(dataFormatada));
		// dao.gravarRelatorio(relatorio);
		return relatorio;
	}

	@RequestMapping("/relatorio-produtos")
	@ResponseBody
	public Relatorio relatorioJson(@RequestParam(value = "data", required = false) String data) throws Exception {
		System.out.println("Pedindo relatorio");
		Relatorio relatorio = gerarRelatorio(data);
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
