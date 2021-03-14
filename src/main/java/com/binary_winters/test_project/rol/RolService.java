package com.binary_winters.test_project.rol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
	
	private RolRepository rolRepository;

	@Autowired
	public RolService(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}

	public Optional<Rol> getRolById(Long id) {
		return rolRepository.findById(id);
	}
}
