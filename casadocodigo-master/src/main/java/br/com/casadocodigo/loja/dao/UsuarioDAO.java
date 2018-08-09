package br.com.casadocodigo.loja.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado");
		}

		return usuarios.get(0);
	}

	public List<Usuario> listar() {
		return manager.createQuery("select distinct(p) from Usuario p", Usuario.class).getResultList();
	}

	public void gravar(Usuario usuario) {
		Role roleAdmin = new Role("ROLE_ADMIN");
		usuario.setRoles(Arrays.asList(roleAdmin));
		manager.persist(usuario);
	}

}