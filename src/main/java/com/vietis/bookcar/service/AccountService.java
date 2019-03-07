package com.vietis.bookcar.service;

import com.vietis.bookcar.domain.Account;

public interface AccountService {

//	Account loadUserByUsername(String username);
//	
//	Account findOne(String username, String password);

    void save(Account account);
    
    public boolean isAccountRegisted(Account account);
}
