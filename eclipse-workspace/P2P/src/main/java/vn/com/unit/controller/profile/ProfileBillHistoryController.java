package vn.com.unit.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.HistoryBillSeparate;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillSeparateService;
import vn.com.unit.service.BillService;

@Controller
public class ProfileBillHistoryController {
	@Autowired
	private AccountService accountService; 
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private BillSeparateService billSeparateService;
	//bills view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@GetMapping("/profile/mybill/access-bills") 
	public ModelAndView wattingBillList(Model model) {
		Account account = accountService.findCurrentAccount();	
		Long status = (long) 0;
		Long Payment = (long)0;
		List<HistoryBillSeparate> bills = billSeparateService.findAllBillSeparateByAccountId(account.getId(),status ,Payment);
		model.addAttribute("current_account", account);
		model.addAttribute("bills", bills);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/myBill/access-bills"); 
		}
	
}
