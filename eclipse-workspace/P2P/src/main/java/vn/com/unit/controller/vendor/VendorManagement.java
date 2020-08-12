package vn.com.unit.controller.vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	//list account activate pages
	@RequestMapping("/editPass")
	public ModelAndView listaccounts1(Model model,@RequestParam(name = "old-password") String old_password, @RequestParam(name = "new-pass") String new_password) {	
		
		Account account = accountService.getCurrentAccount();
		if(accountService.checkPass(account, old_password)){
			accountService.setPassword(account.getId(), new_password);
			model.addAttribute("result", "Change Password Success!");
		}else {
			model.addAttribute("result", "Fail! Incorrect Password");
		}
		model.addAttribute("current_account", account); 	
		model.addAttribute("title","Account Management");
		return new
				  ModelAndView("vendor/myAccount/editPass"); }
}

	 


