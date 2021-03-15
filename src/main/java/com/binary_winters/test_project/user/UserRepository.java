package com.binary_winters.test_project.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.binary_winters.test_project.utils.IUserRoleResponse;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="select distinct u.*, r.ROL_ID from user u inner join rol r on u.ADM_MATRIZ = r.ADM_MATRIZ "
			+ "where u.ADM_MATRIZ = :matrix and r.ROL_ID IN :roles", nativeQuery = true)
	List<IUserRoleResponse> findUserAndRolesbyMatrix(@Param("matrix") String matrix, @Param("roles") List<String> roles);

	@Query(value="select u.*, r.ROL_ID from user u inner join rol r on u.ADM_MATRIZ = r.ADM_MATRIZ "
			+ "where u.ADM_MATRIZ = :matrix and u.code = :code and r.ROL_ID IN :roles", nativeQuery = true)
	List<IUserRoleResponse> findUserAndRolesbyMatrixAndCode(
			@Param("matrix") String matrix, 
			@Param("code") String code, 
			@Param("roles") List<String> roles);
}
