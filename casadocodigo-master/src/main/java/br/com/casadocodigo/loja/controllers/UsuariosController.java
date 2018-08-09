package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioDAO dao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView1 = new ModelAndView("usuarios/form");
		// modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView1;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	@CacheEvict(value = "produtosHome", allEntries = true)
	public ModelAndView gravarUsuario(@Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes) {

		System.out.println("Testando usuario");
		if (result.hasErrors()) {
			return form(usuario);
		}

		dao.gravar(usuario);

		redirectAttributes.addFlashAttribute("message", "Usuario cadastrado com sucesso!");

		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = dao.listar();

		ModelAndView modelAndView2 = new ModelAndView("usuarios/lista");
		modelAndView2.addObject("usuarios", usuarios);
		return modelAndView2;

	}

	@RequestMapping("/roles")
	public ModelAndView roles(Usuario usuario) {
		List<Role> listaRoles = dao.listarRoles();
		System.out.println(listaRoles);

		ModelAndView modelAndView3 = new ModelAndView("usuarios/roles");

		modelAndView3.addObject("listaRoles", listaRoles);

		return modelAndView3;

	}

//	@ExceptionHandler(Exception.class)
//	public ModelAndView usuarioDuplicado(RedirectAttributes redirectAttributes) {
//		System.out.println("Usuario duplicado1");
//		redirectAttributes.addFlashAttribute("message", "Este e-mail já esta cadastrado, favor utilizar outro!");
//		return new ModelAndView("redirect:/usuarios/form");
//	}

}
