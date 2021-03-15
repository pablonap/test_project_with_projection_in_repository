package com.binary_winters.test_project.utils;

public class UserRoleResponse {

	private UserWithoutRol userWithoutRol;
	private String alias;

	public UserRoleResponse(UserWithoutRol userWithoutRol, String alias) {
		this.userWithoutRol = userWithoutRol;
		this.alias = alias;
	}

	public UserWithoutRol getUserWithoutRol() {
		return userWithoutRol;
	}

	public void setUserWithoutRol(UserWithoutRol userWithoutRol) {
		this.userWithoutRol = userWithoutRol;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
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
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (userWithoutRol == null) {
			if (other.userWithoutRol != null)
				return false;
		} else if (!userWithoutRol.equals(other.userWithoutRol))
			return false;
		return true;
	}

}
