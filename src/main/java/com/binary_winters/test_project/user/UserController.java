package com.binary_winters.test_project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binary_winters.test_project.utils.UserRoleResponse;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	// Postman example: http://localhost:8080/api/users/matrix/VN5557/roles/IDV_ROLE_ADMIN,IDV_VAL_3
	// Postman example: http://localhost:8080/api/users/matrix/VN5557/roles/IDV_ROLE_ADMIN,IDV_VAL_3?code=MONICA1
	@GetMapping("/users/matrix/{matrix}/roles/{roles}")
	public List<UserRoleResponse> getUserAndRolbyMatrix(
			@PathVariable String matrix, 
			@PathVariable List<String> roles,
			@RequestParam(required=false) String code) {
		return userService.getUserAndRolbyMatrix(matrix, roles, code);
	}
}