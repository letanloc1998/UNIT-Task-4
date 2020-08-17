package vn.com.unit.controller.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillItemService;
import vn.com.unit.service.BillService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.RoleService;
import vn.com.unit.service.ShopService;
import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.entity.AccountRole;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.BillItem;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;





@Controller


public class ProfileController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	BillItemService billItemService;

	
	// home view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@GetMapping("/profile/home")
	public ModelAndView home(Model model) {
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/profile");
	}
	
	// create shop view
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/profile/createshop")
	public ModelAndView createShop(Model model) {
		Account account = accountService.findCurrentAccount();
		Shop shop = shopService.findShopByAccountId(account.getId());
		if(shop == null) {
			model.addAttribute("title", "Account Management");
			return new ModelAndView("profile/shop/create-shop");
		}
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/shop/wait-confirm-shop");
	}
	
	
	//editAccount view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@GetMapping("/profile/myaccount") public ModelAndView myAccount(Model model,@RequestParam(name = "mode") String mode) {
		String type = "";
		if(mode.equals("editPass")) {
			 type = "profile/myAccount/editPass";
		}else {
			type = "profile/myAccount/account-table";
		}		
		Account account = accountService.findCurrentAccount();	
		model.addAttribute("current_account", account);
		model.addAttribute("title", "Account Management");
		return new ModelAndView(type); }
	
	
	
	//bills view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@RequestMapping("/profile/mybill") public ModelAndView bill(Model model) {
		Account account = accountService.findCurrentAccount();	
		List<Bill> bills = billService.findAllBillByAccountId(account.getId());
		model.addAttribute("current_account", account);
		model.addAttribute("bills", bills);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/myBill/allBill"); }
	
	
	//bills item view
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VENDOR', 'ROLE_ADMIN')")
	@RequestMapping("/profile/mybill/{bill_id}") public ModelAndView billitem(Model model, @PathVariable("bill_id") Long bill_id) {
		Account account = accountService.findCurrentAccount();	
		List<BillItem> billitems = billItemService.findAllBillItemByBillId(bill_id);
		model.addAttribute("current_account", account);
		model.addAttribute("billitems", billitems);
		model.addAttribute("bill_id",bill_id);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("profile/myBill/billItem"); }

}
