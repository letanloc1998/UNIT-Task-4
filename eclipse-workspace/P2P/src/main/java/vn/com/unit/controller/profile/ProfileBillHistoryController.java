package vn.com.unit.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Bill;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillService;

@Controller
public class ProfileBillHistoryController {
	@Autowired
	private AccountService accountService; 
	
	@Autowired
	private BillService billService;
	
	//bills view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@RequestMapping("/profile/mybill") 
	public ModelAndView bill(Model model) {
		Account account = accountService.findCurrentAccount();	
		List<Bill> bills = billService.findAllBillByAccountId(account.getId());
		model.addAttribute("current_account", account);
		model.addAttribute("bills", bills);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/myBill/allBill"); 
		}
	
}
