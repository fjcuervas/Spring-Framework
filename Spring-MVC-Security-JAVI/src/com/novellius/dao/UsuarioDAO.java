package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Usuario;

public interface UsuarioDAO {
	
	public Usuario findByUsername(String usuario);
	public void save(Usuario usuario);
	public List<Usuario> findAll();

}
