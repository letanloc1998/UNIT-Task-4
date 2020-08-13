package vn.com.unit.controller.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.service.AccountService;
import vn.com.unit.service.RoleService;
import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.entity.AccountRole;




@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class VendorController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;

	@RequestMapping("/vendor/home")

	public ModelAndView home(Model model) {

		return new ModelAndView("vendor/vendor");
	}
	
	@RequestMapping("/vendor/myaccount") public ModelAndView myAccount(Model model,@RequestParam(name = "mode") String mode) {
		String type = "";
		if(mode.equals("editPass")) {
			 type = "vendor/myAccount/editPass";
		}else {
			type = "vendor/myAccount/account-table";
		}		
		Account account = accountService.getCurrentAccount();	
		model.addAttribute("current_account", account);
		return new ModelAndView(type); }
	
	 
	 

}
