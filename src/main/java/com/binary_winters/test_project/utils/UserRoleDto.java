package com.binary_winters.test_project.utils;

import java.util.List;

public class UserRoleDto {

	private Long id;
	private String matrix;
	private String code;
	private String name;
	private List<String> alias;

	public UserRoleDto(Long id, String matrix, String code, String name, List<String> alias) {
		this.id = id;
		this.matrix = matrix;
		this.code = code;
		this.name = name;
		this.alias = alias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAlias() {
		return alias;
	}

	public void setAlias(List<String> alias) {
		this.alias = alias;
	}

}
