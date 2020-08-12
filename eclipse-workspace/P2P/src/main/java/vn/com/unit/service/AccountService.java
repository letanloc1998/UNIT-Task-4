package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
	
	public boolean checkLogin(Account account, String rawPassword);
	
	public List<Account> findAllAccount();
	
	public Account createNewAccount(Account account);
	
	public Account getAccountRole(Account account);
	
	public Account getCurrentAccount();

	public void setPassword(Long account_id, String password);
	
	public void setPhone(Long account_id, String phone);
	
	public void setEmail(Long account_id, String name);
	
	public void setName(Long account_id, String name);
	
	public Account findById(Long id);
}
