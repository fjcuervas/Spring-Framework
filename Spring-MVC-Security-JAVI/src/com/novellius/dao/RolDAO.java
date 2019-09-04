package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Rol;

public interface RolDAO {
	
	public Rol findByRol(String permiso);
	public void save(Rol rol);
	public List<Rol> findAll();

}
