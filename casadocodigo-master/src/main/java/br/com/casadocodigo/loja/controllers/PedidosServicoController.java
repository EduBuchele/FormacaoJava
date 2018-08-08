package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {

	@Autowired
	private RestTemplate restTemplate;

	String uri = "https://book-payment.herokuapp.com/orders";

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView pedidos() {
		List<Pedido> lista = BuscaPedidos();
		System.out.println("Lista: " + lista);
		ModelAndView modelAndView = new ModelAndView("pedidos");
		modelAndView.addObject("pedidos", lista);

		return modelAndView;
	}

	public List<Pedido> BuscaPedidos() {

		ResponseEntity<List<Pedido>> listaPedidosJson = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Pedido>>() {
				});
		List<Pedido> listaPedidos = listaPedidosJson.getBody();

		return listaPedidos;
	}
}
