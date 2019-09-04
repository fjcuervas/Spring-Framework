package com.novellius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.RolDAO;
import com.novellius.pojo.Rol;

@Service
public class RolService {

	@Autowired
	private RolDAO rolDAO;
	
	public void save(Rol rolForm) {
		rolDAO.save(rolForm);
	}

	public List<Rol> findAll() {
		return rolDAO.findAll();
	}
}
