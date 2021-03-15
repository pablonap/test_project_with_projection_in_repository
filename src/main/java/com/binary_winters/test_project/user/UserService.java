package com.binary_winters.test_project.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary_winters.test_project.utils.IUserRoleResponse;
import com.binary_winters.test_project.utils.UserRoleDto;
import com.binary_winters.test_project.utils.UserRoleResponse;
import com.binary_winters.test_project.utils.UserWithoutRol;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private List<IUserRoleResponse> findUserAndRolbyMatrix(String matrix, List<String> roles, String code) {
		List<IUserRoleResponse> iuserRoleHelperResponse = null;
		if (code != null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrixAndCode(matrix, code, roles);
		} else if (code == null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrix(matrix, roles);
		}
		
		return iuserRoleHelperResponse;
	}
	
	private Map<UserWithoutRol, List<UserRoleResponse>> buildMapOfUsersWithTheirRoles(List<IUserRoleResponse> iuserRoleHelperResponse) {
		List<UserRoleResponse> userRoleResponseList = iuserRoleHelperResponse.stream().map((IUserRoleResponse i) -> new UserRoleResponse(
						new UserWithoutRol(i.getId(), i.getMatrix(), i.getCode(), i.getName()), i.getAlias()))
				.distinct().collect(Collectors.toList());

		Map<UserWithoutRol, List<UserRoleResponse>> mapOfUsers = userRoleResponseList.stream()
				.collect(Collectors.groupingBy(UserRoleResponse::getUserWithoutRol));
		
		return mapOfUsers;
	}
		
	public List<UserRoleDto> getUsersWithTheirRoles(String matrix, List<String> roles, String code){
		
		List<IUserRoleResponse> iuserRoleHelperResponse = this.findUserAndRolbyMatrix(matrix, roles, code);
		
		Map<UserWithoutRol, List<UserRoleResponse>> mapOfUsersWithTheirRoles = this.buildMapOfUsersWithTheirRoles(iuserRoleHelperResponse);

		List<UserRoleDto> userRoleDtoResponse = new ArrayList<>();

		for (Map.Entry<UserWithoutRol, List<UserRoleResponse>> entry : mapOfUsersWithTheirRoles.entrySet()) {

			UserWithoutRol userWithoutRol = entry.getKey();
			List<UserRoleResponse> userRoleResponseValue = entry.getValue();

			List<String> rolesFromMap = new ArrayList<>();

			for (UserRoleResponse user : userRoleResponseValue) {
				rolesFromMap.add(user.getAlias());
			}

			UserRoleDto userRoleDto = new UserRoleDto(userWithoutRol.getId(), userWithoutRol.getMatrix(),
					userWithoutRol.getCode(), userWithoutRol.getName(), rolesFromMap);

			userRoleDtoResponse.add(userRoleDto);
		}

		return userRoleDtoResponse;
	}
}
