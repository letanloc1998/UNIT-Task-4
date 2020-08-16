package vn.com.unit.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillItemService;
import vn.com.unit.service.BillService;
import vn.com.unit.service.BrandService;
import vn.com.unit.service.CategoryService;
import vn.com.unit.service.ProductService;
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

	@Autowired
	ProductService productService;

	@Autowired
	BillService billService;

	@Autowired
	BillItemService billItemService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;
	
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
		Long status = (long) 2;
		if (shopService.setDisableShop(account.getId(),status)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	
	//add product
	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute("new_product") Product new_product, Model model) {
		Account account = accountService.findCurrentAccount();		
		productService.createNewProduct(new_product.getName(), new_product.getPrice(), new_product.getQuantity(), new_product.getCategory(), new_product.getBrand(), new_product.getDetail(), new_product.getImg(), account.getId());
		return "redirect:/shop/myproduct?mode=view"; 
	}
	
	// edit Product
	@PutMapping("/product/{product_id}")
	@ResponseBody
	public ResponseEntity<Product> editShop(@RequestBody Product product,@PathVariable("product_id") Long product_id ,Model model) {
		String name = product.getName();
		int category = product.getCategory();
		int brand = product.getBrand();
		int price = product.getPrice();
		int quantity = product.getQuantity();
		String detail = product.getDetail();
		productService.saveProduct(product_id, name, price, detail, category, brand, quantity);
		return ResponseEntity.ok(product);

	}
	
	//deleteProduct
	@DeleteMapping("/product/{product_id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("product_id") Long product_id) {
		String status = "1";
		if (productService.setDisableProductByProductId(product_id,status)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
