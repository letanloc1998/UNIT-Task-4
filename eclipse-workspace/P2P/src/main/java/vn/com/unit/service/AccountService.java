package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
	
	public boolean checkLogin(Account account, String rawPassword);
	
	public boolean checkPass(Account account, String oldPassword);
	
	public List<Account> findAllAccount(int limit,int offset);
	
	public Account createNewAccount(Account account);
	
	public Account setRoleByAccountId(Account account);
	
	public Account getCurrentAccount();

	public void setAccountPassword(Long account_id, String password);
	
	public void saveAccount(Long account_id, String name, String email, String phone);
	
	public Account findAccountById(Long id);
	
	public int countAccountActive();
}
