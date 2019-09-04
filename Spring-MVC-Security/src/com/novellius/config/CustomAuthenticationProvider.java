package com.novellius.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//Este método devolverá un Token con las credenciales del usuario que inció sesión
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		// Datos del form de login introducidos
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		// Creamos un usuario de Spring mediante el usuario introducido en el formulario
		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null) {
			// Si el usuario existe se comprueba la contraseña introducida
			if (passwordEncoder.matches(credentials, user.getPassword())) {
				System.out.println("Login correcto");
				return new UsernamePasswordAuthenticationToken(principal, user.getPassword(), user.getAuthorities());
			}
			else{
				System.out.println("Error de login: " + principal);
				throw new BadCredentialsException("Error de login");
			}
		} 
		else {
			System.out.println("Error de login: " + principal);
			throw new BadCredentialsException("Error de login");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
