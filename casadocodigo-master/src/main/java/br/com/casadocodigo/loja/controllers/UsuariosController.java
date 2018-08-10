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

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioDAO dao;

	@Autowired
	private RoleDAO daoRole;

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

//	@RequestMapping(value = "/roles", method = RequestMethod.GET)
//	public ModelAndView editaRoles(String nome) {
//		ModelAndView modelAndView = new ModelAndView("usuarios/roles");
//		Usuario usuario = dao.find(nome);
//		modelAndView.addObject("usuario", usuario);
//		modelAndView.addObject("nome", usuario.getNome());
//		List<Role> listaRoles = dao.listarRoles();
//		modelAndView.addObject("listaRoles1", listaRoles);
//		System.out.println(listaRoles);
//		return modelAndView;
//	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ModelAndView editaRoles(String nome) {
		ModelAndView modelAndView = new ModelAndView("usuarios/roles");
		Usuario usuario = dao.find(nome);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("nome", usuario.getNome());
		List<Role> listaRoles = daoRole.listarRoles();
		modelAndView.addObject("listaRoles1", listaRoles);
		modelAndView.addObject("roleAdmin", listaRoles.get(0).getNome());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvaRoles(String nome, Usuario usuarioNovo, BindingResult result,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		System.out.println("Nome: " + nome);
		System.out.println("Usuario Novo Roles: " + usuarioNovo.getRoles());

		redirectAttributes.addFlashAttribute("message", "Roles Atualizadas com sucesso!");
		// atualizar roles
		dao.atualiza(usuarioNovo, nome);

		System.out.println("Enviando dados!!!");
		return modelAndView;
	}

//	@ExceptionHandler(Exception.class)
//	public ModelAndView usuarioDuplicado(RedirectAttributes redirectAttributes) {
//		System.out.println("Usuario duplicado1");
//		redirectAttributes.addFlashAttribute("message", "Este e-mail já esta cadastrado, favor utilizar outro!");
//		return new ModelAndView("redirect:/usuarios/form");
//	}

}
