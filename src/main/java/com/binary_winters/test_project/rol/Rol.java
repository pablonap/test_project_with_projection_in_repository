package com.binary_winters.test_project.rol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;

	private String matrix;
	
	private String alias;

	private String code;

	public Rol(Long roleid, String matrix, String alias, String code) {
		this.roleid = roleid;
		this.matrix = matrix;
		this.alias = alias;
		this.code = code;
	}
	
	public Rol() {
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	public Long getId() {
		return roleid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}