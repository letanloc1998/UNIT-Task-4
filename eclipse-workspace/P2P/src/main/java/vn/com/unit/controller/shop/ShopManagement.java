package vn.com.unit.controller.shop;

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

public class ShopManagement {

	@Autowired
	AccountService accountService;

	@Autowired
	RoleService roleService;

	@Autowired
	ShopService shopService;
	
	// edit SHOP
	@PutMapping("/shop/edit")
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
	@DeleteMapping("/shop/delete")
	public ResponseEntity<Void> deleteShop() {
		Account account = accountService.findCurrentAccount();
		String status = "2";
		if (shopService.setDisableShop(account.getId(),status)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
