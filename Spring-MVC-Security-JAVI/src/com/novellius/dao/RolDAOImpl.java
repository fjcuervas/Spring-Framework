package com.novellius.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Rol;
import com.novellius.pojo.Usuario;

@Repository
@Transactional
public class RolDAOImpl implements RolDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> findAll() {
		return getSession().createQuery("from Rol").list();
	}

	@Override
	public Rol findByRol(String permiso) {
		Criteria crit = getSession().createCriteria(Rol.class)
				.add(Restrictions.eq("permiso", permiso));
		
		return (Rol) crit.uniqueResult();
	}

	@Override
	public void save(Rol rol) {
		getSession().save(rol);		
	}

}
