package com.binary_winters.test_project.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	private RolService rolService;

	@GetMapping("/roles/{id}")
	public Rol getRolById(@PathVariable Long id) {
		return rolService.getRolById(id).get();
	}
}
