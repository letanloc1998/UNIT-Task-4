package vn.com.unit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Account;
import vn.com.unit.repository.AccountRepository;
import vn.com.unit.repository.RoleRepository;
import vn.com.unit.service.AccountService;
import vn.com.unit.utils.CommonUtils;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public boolean checkLogin(Account account, String rawPassword) {
		try {

			String encodedPassword = account.getPassword();
			if (encodedPassword.equals("")) {
				String defaultRawPassword = "d3f@ultP@ssUn1t";
				accountRepository.updateAccountPassword(account.getId(),
						CommonUtils.encodePassword(defaultRawPassword));
				return rawPassword.equals(defaultRawPassword);
			}

			return passwordEncoder.matches(rawPassword, encodedPassword);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public List<Account> findAllAccount() {
		List<Account> accounts = new ArrayList<Account>();
		try {
			accounts = accountRepository.findAllAccount();
//			for (UserModel account : accounts) {
//				List<RoleModel> roles = roleService.findRolesByAccountId(account.getId());
//				account.setRoles(roles);
//			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return accounts;
	}
	
	@Override
	public Account createNewAccount(Account account) {
		try {
			String username = account.getUsername();
			String password = CommonUtils.encodePassword(account.getPassword());
		}catch(Exception e) {
			
		}
		return null;
	}
	

}
