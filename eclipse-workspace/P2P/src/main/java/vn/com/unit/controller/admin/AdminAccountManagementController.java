package vn.com.unit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.pageable.PageRequest;
import vn.com.unit.service.AccountService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminAccountManagementController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/admin/account/list")
	public ModelAndView accountList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {

		int totalitems = accountService.countAccountActive();
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);

		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);

		List<Account> accounts = accountService.findAllAccount(pageable.getLimit(), pageable.getOffset());
		model.addAttribute("accounts", accounts);
		model.addAttribute("pageable", pageable);

		return new ModelAndView("admin/account/account-table");
	}
	@GetMapping("/admin/account/add")
	public ModelAndView accountAdd(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {

		return new ModelAndView("admin/account/add-account");
	}
	

}
