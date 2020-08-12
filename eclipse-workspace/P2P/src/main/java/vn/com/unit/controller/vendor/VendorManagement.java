package vn.com.unit.controller.vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.RoleService;




@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class VendorManagement {
	
	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;

	//edit account
	@PutMapping("/account")
	@ResponseBody
	public ResponseEntity<Account> editAccount(@RequestBody Account account, Model model) {
		Long account_id = account.getId();
		/*
		 * String new_password = account.getPassword();
		 * accountService.setPassword(account_id, new_password);
		 */
		
		String new_phone = account.getPhone();
		accountService.setPhone(account_id, new_phone);
		
		String new_email = account.getEmail();
		accountService.setEmail(account_id, new_email);
		
		String new_name = account.getName();
		accountService.setName(account_id, new_name);
		return ResponseEntity.ok(account);

	}	
	 

}
