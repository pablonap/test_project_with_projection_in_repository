package com.binary_winters.test_project.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary_winters.test_project.utils.IUserRoleResponse;
import com.binary_winters.test_project.utils.UserRoleResponse;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserRoleResponse> getUserAndRolbyMatrix(String matrix, List<String> roles, String code) {
		List<IUserRoleResponse> iuserRoleHelperResponse = null;
		if (code != null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrixAndCode(matrix, code, roles);
		} else if (code == null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrix(matrix, roles);
		}

		List<UserRoleResponse> userRoleHelperResponse = 
				iuserRoleHelperResponse.stream()
				.map((IUserRoleResponse i) -> new UserRoleResponse(i.getId(), i.getMatrix(), i.getCode(), i.getName(), i.getAlias()))
				.distinct()
				.collect(Collectors.toList());
		
		return userRoleHelperResponse;
	}

}
