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
import vn.com.unit.service.ShopService;
import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.entity.AccountRole;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;





@Controller
@PreAuthorize("hasRole('ROLE_VENDOR')")

public class VendorController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	ShopService shopService;

	
	// home view
	@RequestMapping("/vendor/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("vendor/vendor");
	}
	
	
	//editAccount view
	@RequestMapping("/vendor/myaccount") public ModelAndView myAccount(Model model,@RequestParam(name = "mode") String mode) {
		String type = "";
		if(mode.equals("editPass")) {
			 type = "vendor/myAccount/editPass";
		}else {
			type = "vendor/myAccount/account-table";
		}		
		Account account = accountService.findCurrentAccount();	
		model.addAttribute("current_account", account);
		return new ModelAndView(type); }
	
	 //editShop view
	
	@RequestMapping("/vendor/myshop") public ModelAndView myShop(Model model) {
		Account account = accountService.findCurrentAccount();	
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);
		model.addAttribute("current_account", account);
		return new ModelAndView("vendor/myShop/editShop"); }

}
