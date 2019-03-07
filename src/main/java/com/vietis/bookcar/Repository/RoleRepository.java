package com.vietis.bookcar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vietis.bookcar.domain.Account;
import com.vietis.bookcar.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role findByRole(String role);
}
