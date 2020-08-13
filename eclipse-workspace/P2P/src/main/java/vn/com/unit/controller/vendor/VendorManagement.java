package vn.com.unit.controller.vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Role;
import vn.com.unit.entity.Shop;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.RoleService;
import vn.com.unit.service.ShopService;




@Controller
@PreAuthorize("hasRole('ROLE_VENDOR')")

public class VendorManagement {
	
	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	ShopService shopService;

	//edit account
	@PutMapping("/account")
	@ResponseBody
	public ResponseEntity<Account> editAccount(@RequestBody Account account, Model model) {
		Long account_id = account.getId();
		String new_phone = account.getPhone();		
		String new_email = account.getEmail();
		String new_name = account.getName();
		accountService.saveAccount(account_id, new_name, new_email, new_phone);
		return ResponseEntity.ok(account);

	}
	
	
	//edit SHOP
	@RequestMapping("/editshop")
	public ModelAndView editShop(Model model,
									@RequestParam(name = "name") String name, 
									@RequestParam(name = "address") String address, 
									@RequestParam(name = "email") String email,
									@RequestParam(name = "phone") String phone,
									@RequestParam(name = "detail") String detail												
			) {	
		
		Account account = accountService.getCurrentAccount();
		Long shop_id = account.getId();
		shopService.saveShop(shop_id, name, email, phone, address, detail);
		model.addAttribute("result", "Update Shop Success!");
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);
		model.addAttribute("current_account", account); 	
		model.addAttribute("title","Shop Management");
		return new ModelAndView("vendor/myShop/editShop"); }
	

	
	
	//edit password
	@RequestMapping("/editPass")
	public ModelAndView listaccounts1(Model model,@RequestParam(name = "old-password") String old_password, @RequestParam(name = "new-pass") String new_password) {	
		
		Account account = accountService.getCurrentAccount();
		if(accountService.checkPass(account, old_password)){
			accountService.setAccountPassword(account.getId(), new_password);
			model.addAttribute("result", "Change Password Success!");
		}else {
			model.addAttribute("result", "Fail! Incorrect Password");
		}
		model.addAttribute("current_account", account); 	
		model.addAttribute("title","Account Management");
		return new ModelAndView("vendor/myAccount/editPass"); }
	
	
}

	 


