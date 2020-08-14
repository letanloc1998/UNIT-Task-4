package vn.com.unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;

@Controller

public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account")
	@ResponseBody
	public ModelAndView createAccount(@RequestBody Account account, Model model){
		accountService.createNewAccount(account, "ROLE_USER");
		return new ModelAndView("redirect:/");
	}
}
