package com.novellius.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
public class Permiso {

	@Id
	@GeneratedValue
	private int idPermiso;
	
	@Column(name = "tipo_permiso")
	private String tipoPermiso;
	
	@ManyToOne
	@JoinColumn(name = "permiso_id_rol", referencedColumnName = "idRol")
	private Rol rol;

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(String tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Permiso() {
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", tipoPermiso=" + tipoPermiso + ", rol=" + rol.getTipoRol() + "]";
	}
	
	
	
}
