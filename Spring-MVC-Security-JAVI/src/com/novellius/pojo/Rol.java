package com.novellius.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rol")
public class Rol {

	@Id
	@GeneratedValue
	private int idRol;
	
	private String tipoRol;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_usr",  referencedColumnName = "idUsr")
    private Usuario rolUsuario;

	@OneToMany(mappedBy = "rol",fetch = FetchType.EAGER)
	private Set<Permiso> permisos;
	
	public String getTipoRol() {
		return tipoRol;
	}
	
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	
	public Rol() {
	}
	

	public Usuario getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(Usuario rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", tipoRol=" + tipoRol + ", rolUsuario=" + rolUsuario + ", permiso= " + permisos + "]";
	}
	
	
}
