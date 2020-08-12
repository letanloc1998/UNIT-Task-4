package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
	
	public boolean checkLogin(Account account, String rawPassword);
	
	public List<Account> findAllAccount();
	
	public Account createNewAccount(Account account);
	public Account getCurrentAccount();
}
