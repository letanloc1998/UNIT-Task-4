package vn.com.unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;

public class UserController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account")
	@ResponseBody
	
	public ResponseEntity<Account> createAccount(@RequestBody Account account, Model model){
		Account accountCreate = accountService.createNewAccount(account);
		Account accountRole = accountService.setRoleByAccountId(account);
		return ResponseEntity.ok(account);
	}
}
