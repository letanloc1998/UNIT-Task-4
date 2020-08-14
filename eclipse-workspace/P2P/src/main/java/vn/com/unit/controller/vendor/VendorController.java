package vn.com.unit.controller.vendor;

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
@PreAuthorize("hasRole('ROLE_VENDOR')")

public class VendorController {
	
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
	@GetMapping("/vendor/home")
	public ModelAndView home(Model model) {
		model.addAttribute("title", "Account Management");
		return new ModelAndView("vendor/vendor");
	}
	
	
	//editAccount view
	@GetMapping("/vendor/myaccount") public ModelAndView myAccount(Model model,@RequestParam(name = "mode") String mode) {
		String type = "";
		if(mode.equals("editPass")) {
			 type = "vendor/myAccount/editPass";
		}else {
			type = "vendor/myAccount/account-table";
		}		
		Account account = accountService.findCurrentAccount();	
		model.addAttribute("current_account", account);
		model.addAttribute("title", "Account Management");
		return new ModelAndView(type); }
	
	
	
	//products view
	@GetMapping("/vendor/product") public ModelAndView product(Model model) {
		Account account = accountService.findCurrentAccount();	
		List<Product> products = productService.findAllProductByShopId(account.getId());
		model.addAttribute("current_account", account);
		model.addAttribute("products", products);
		return new ModelAndView("vendor/product/allProduct"); }
	
	
	//bills view
	@RequestMapping("/vendor/mybill") public ModelAndView bill(Model model) {
		Account account = accountService.findCurrentAccount();	
		List<Bill> bills = billService.findAllBillByAccountId(account.getId());
		model.addAttribute("current_account", account);
		model.addAttribute("bills", bills);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("vendor/myBill/allBill"); }
	
	
	//bills item view
	@RequestMapping("/vendor/mybill/{bill_id}") public ModelAndView billitem(Model model, @PathVariable("bill_id") Long bill_id) {
		Account account = accountService.findCurrentAccount();	
		List<BillItem> billitems = billItemService.findAllBillItemByBillId(bill_id);
		model.addAttribute("current_account", account);
		model.addAttribute("billitems", billitems);
		model.addAttribute("bill_id",bill_id);
		model.addAttribute("title", "Account Management");
		return new ModelAndView("vendor/myBill/billItem"); }

}
