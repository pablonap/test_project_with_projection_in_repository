package com.binary_winters.test_project.utils;

public class UserRoleResponse {

	private UserWithoutRol userWithoutRol;
	private String roleId;

	public UserRoleResponse(UserWithoutRol userWithoutRol, String roleId) {
		this.userWithoutRol = userWithoutRol;
		this.roleId = roleId;
	}

	public UserWithoutRol getUserWithoutRol() {
		return userWithoutRol;
	}

	public void setUserWithoutRol(UserWithoutRol userWithoutRol) {
		this.userWithoutRol = userWithoutRol;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((userWithoutRol == null) ? 0 : userWithoutRol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleResponse other = (UserRoleResponse) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userWithoutRol == null) {
			if (other.userWithoutRol != null)
				return false;
		} else if (!userWithoutRol.equals(other.userWithoutRol))
			return false;
		return true;
	}
}
