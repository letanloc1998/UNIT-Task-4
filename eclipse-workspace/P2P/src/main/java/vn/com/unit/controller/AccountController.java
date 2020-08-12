package vn.com.unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/admin/account/list")
	public ModelAndView accountList(Model model) {
		List<Account> accounts = accountService.findAllAccount();
		model.addAttribute("accounts",accounts);
		return new ModelAndView("admin/account/account-table");
	}

}
