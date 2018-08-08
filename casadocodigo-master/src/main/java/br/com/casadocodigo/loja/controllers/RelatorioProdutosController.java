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

	@RequestMapping(value = "/relatorio-produtos", method = RequestMethod.GET)
	@ResponseBody
	public Relatorio relatorioJson(@RequestParam(value = "data", required = false) String data) throws Exception {
		// Data inserida na URL
		// System.out.println("_________________________" + data);

		Calendar dataFormatada = GregorianCalendar.getInstance();
		dataFormatada.set(1500, 01, 01);
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

		// Filtrando Data Vazia
		if (data != null) {
			dataFormatada.setTime(formatador.parse(data));
		} else {

		}
		// Imprimindo data formatada
		// System.out.println("_________________________" + dataFormatada);

		Relatorio relatorio = new Relatorio();
		relatorio.setDataAtual(Calendar.getInstance());
		relatorio.setQuantidade(dao.relatorioQuantidade(dataFormatada));
		relatorio.setProdutos(dao.relatorioItensPorData(dataFormatada));
		// dao.gravarRelatorio(relatorio);

		return relatorio;
	}

}
