package vn.com.unit.dto;

import java.util.List;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;

public class AccountRoleDto extends Account {

	List<Role> role;

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
	
	public Account getAccount() {
		return (Account) this;
	}
	
}
