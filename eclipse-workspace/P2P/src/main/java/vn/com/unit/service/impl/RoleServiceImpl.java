package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<GrantedAuthority> findAuthorities(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findRolesByAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findRoleByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
