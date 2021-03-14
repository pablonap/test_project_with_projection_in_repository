package com.binary_winters.test_project.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary_winters.test_project.utils.IUserRoleHelper;
import com.binary_winters.test_project.utils.UserRoleHelper;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserRoleHelper> getUserAndRolbyMatrix(String matrix, List<String> roles, String code) {
		List<IUserRoleHelper> iuserRoleHelperResponse = null;
		if (code != null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrixAndCode(matrix, code, roles);
		} else if (code == null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrix(matrix, roles);
		}

		List<UserRoleHelper> userRoleHelperResponse = 
				iuserRoleHelperResponse.stream()
				.map((IUserRoleHelper i) -> new UserRoleHelper(i.getId(), i.getMatrix(), i.getCode(), i.getName(), i.getAlias()))
				.distinct()
				.collect(Collectors.toList());
		
		return userRoleHelperResponse;
	}

}
