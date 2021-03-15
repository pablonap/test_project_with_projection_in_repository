package com.binary_winters.test_project.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary_winters.test_project.utils.IUserRoleResponse;
import com.binary_winters.test_project.utils.UserRoleDto;
import com.binary_winters.test_project.utils.UserRoleResponse;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserRoleDto> getUserAndRolbyMatrix(String matrix, List<String> roles, String code) {
		List<IUserRoleResponse> iuserRoleHelperResponse = null;
		if (code != null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrixAndCode(matrix, code, roles);
		} else if (code == null && roles != null) {
			iuserRoleHelperResponse = userRepository.findUserAndRolesbyMatrix(matrix, roles);
		}

		List<UserRoleResponse> userRoleResponseList = iuserRoleHelperResponse.stream()
				.map((IUserRoleResponse i) -> new UserRoleResponse(i.getId(), i.getMatrix(), i.getCode(), i.getName(),
						i.getAlias()))
				.distinct().collect(Collectors.toList());

		List<UserRoleDto> userRoleDtoList = new ArrayList<>();

		for (int i = 0; i < userRoleResponseList.size(); i++) {
			for (int j = i + 1; j < userRoleResponseList.size(); j++) {
				if (userRoleResponseList.get(i).getMatrix().equals(userRoleResponseList.get(j).getMatrix())
						&& userRoleResponseList.get(i).getCode().equals(userRoleResponseList.get(j).getCode())) {

					Long currentId = userRoleResponseList.get(i).getId();
					String currentMatrix = userRoleResponseList.get(i).getMatrix();
					String currentCode = userRoleResponseList.get(i).getCode();
					String currentName = userRoleResponseList.get(i).getName();
					String currentRol = userRoleResponseList.get(i).getAlias();

					if (userRoleDtoList.isEmpty()) {
						List<String> listOfRoles = new ArrayList<String>();
						listOfRoles.add(currentRol);
						UserRoleDto user = new UserRoleDto(currentId, currentMatrix, currentCode, currentName,
								listOfRoles);
						userRoleDtoList.add(user);
					} else {
						for (UserRoleDto u : userRoleDtoList) {
							if ((u.getMatrix().equals(currentMatrix) && u.getCode().equals(currentCode))) {
								if (u.getAlias().contains(currentRol) == false) {
									u.getAlias().add(currentRol);
								}
							} else {
								List<String> listOfRoles = new ArrayList<String>();
								listOfRoles.add(currentRol);
								UserRoleDto user = new UserRoleDto(currentId, currentMatrix, currentCode, currentName,
										listOfRoles);
								userRoleDtoList.add(user);
							}
						}
					}

				}
			}
		}

		return userRoleDtoList;
	}

}
