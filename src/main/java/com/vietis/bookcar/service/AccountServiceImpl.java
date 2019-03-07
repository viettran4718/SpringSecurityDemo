package com.vietis.bookcar.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vietis.bookcar.Repository.AccountRepository;
import com.vietis.bookcar.Repository.RoleRepository;
import com.vietis.bookcar.domain.Account;
import com.vietis.bookcar.domain.Role;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		account.setPassword(encoder.encode(account.getPassword()));
		Role accountRole = roleRepository.findByRole("ROLE_ADMIN");
		account.setRoles(new HashSet<Role>(Arrays.asList(accountRole)));

		accountRepository.save(account);

	}

	@Override
	public boolean isAccountRegisted(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
