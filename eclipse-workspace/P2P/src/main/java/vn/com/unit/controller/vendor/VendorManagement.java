package vn.com.unit.controller.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.unit.entity.Account;
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
	
	// edit password
	
	@PutMapping("/password")
	@ResponseBody
	public ResponseEntity<Account> editPass(@RequestBody Account new_account, Model model) {
		Account account = accountService.findCurrentAccount();
			accountService.checkPass(account, new_account.getPassword());
			accountService.setAccountPassword(account.getId(), new_account.getPassword());
			model.addAttribute("result", "Change Password Success!");
	
		return ResponseEntity.ok(account);

	}

	// edit SHOP
	@PutMapping("/shop")
	@ResponseBody
	public ResponseEntity<Shop> editShop(@RequestBody Shop shop, Model model) {
		Long shop_id = shop.getId();
		String phone = shop.getPhone();
		String email = shop.getEmail();
		String name = shop.getName();
		String address = shop.getAddress();
		String detail = shop.getDetail();
		shopService.saveShop(shop_id, name, email, phone, address, detail);;
		return ResponseEntity.ok(shop);

	}

	
	//deleteShop
	@DeleteMapping("/shop")
	public ResponseEntity<Void> deleteShop() {
		Account account = accountService.findCurrentAccount();
		if (shopService.setDisableShop(account.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}



	
	
	
	


	

}
