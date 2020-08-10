package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;

public interface RoleService {
	
	public List<Role> findRolesByAccount(Account account);
}
