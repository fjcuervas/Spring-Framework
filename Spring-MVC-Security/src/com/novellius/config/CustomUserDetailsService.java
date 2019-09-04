package com.novellius.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.novellius.dao.UsuarioDAO;
import com.novellius.pojo.Usuario;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//Necesitamos crear una colección de autoridades necesaria para crear un tipo de usuario de Spring
		//org.springframework.security.core.userdetails.User cuyo constructor nos pide:
		/*
		   public User(String username, String password, Collection<? extends GrantedAuthority> authorities) { }
		*/
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Usuario usuario = usuarioDAO.findByUsername(username);
		
		//Si el usuario existe en nuestra base de datos, añadimos el permiso a la lista de autoridades y creamos un User de Spring
		if (usuario != null) {
			authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
			User user = new User(usuario.getUsuario(), usuario.getClave(), authorities);
			return user;
		} 
		else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}
}
