package vn.com.unit.controller.vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// edit account
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

	// edit SHOP

	/*
	 * @RequestMapping(value = { "/editshop" }, method = RequestMethod.GET) public
	 * ModelAndView editShop(Model model,
	 * 
	 * @RequestParam(name = "name") String name,
	 * 
	 * @RequestParam(name = "address") String address,
	 * 
	 * @RequestParam(name = "email") String email,
	 * 
	 * @RequestParam(name = "phone") String phone,
	 * 
	 * @RequestParam(name = "detail") String detail) {
	 * 
	 * Account account = accountService.getCurrentAccount(); Long shop_id =
	 * account.getId(); shopService.saveShop(shop_id, name, email, phone, address,
	 * detail); model.addAttribute("result", "Update Shop Success!"); Shop shop =
	 * shopService.findShopByAccountId(account.getId()); model.addAttribute("shop",
	 * shop); model.addAttribute("current_account", account);
	 * model.addAttribute("title", "Shop Management"); return new
	 * ModelAndView("vendor/myShop/editShop"); }
	 */

	
	//view infor shop



	//edit SHOP
	@RequestMapping("/editshop")
	public ModelAndView editShop(Model model,
									@RequestParam(name = "name") String name, 
									@RequestParam(name = "address") String address, 
									@RequestParam(name = "email") String email,
									@RequestParam(name = "phone") String phone,
									@RequestParam(name = "detail") String detail												
			) {	
		
		Account account = accountService.findCurrentAccount();
		Long shop_id = account.getId();
		shopService.setDisableShop(shop_id);
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);
		model.addAttribute("current_account", account);
		model.addAttribute("title", "Shop Management");
		return new ModelAndView("vendor/myShop/editShop");
	}

	
	
	// edit password
	
	@PutMapping("/vendor")
	@ResponseBody
	public ResponseEntity<Account> editPass(@RequestBody Account new_account, Model model) {
		Account account = accountService.findCurrentAccount();
			accountService.checkPass(account, new_account.getPassword());
			accountService.setAccountPassword(account.getId(), new_account.getPassword());
			model.addAttribute("result", "Change Password Success!");
	
		return ResponseEntity.ok(account);

	}	
	


}
