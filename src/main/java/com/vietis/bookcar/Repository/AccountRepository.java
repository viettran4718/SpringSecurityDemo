package com.vietis.bookcar.Repository;

import org.springframework.data.repository.CrudRepository;

import com.vietis.bookcar.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Account findByUsername(String username);
	
	//Account findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
}
