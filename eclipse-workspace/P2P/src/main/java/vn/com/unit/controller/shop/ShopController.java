package vn.com.unit.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.BillItem;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillItemService;
import vn.com.unit.service.BillService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.RoleService;
import vn.com.unit.service.ShopService;

@Controller
@PreAuthorize("hasRole('ROLE_VENDOR')")
public class ShopController {

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
	@GetMapping("/shop/home")
	public ModelAndView shopHome(Model model) {
		model.addAttribute("title", "Shop Management");
		return new ModelAndView("shop/shop");
	}

	// edit shop view
	@GetMapping("/shop/myshop")
	public ModelAndView editShop(Model model) {

		Account account = accountService.findCurrentAccount();
		Shop shop = shopService.findShopByAccountId(account.getId());

		model.addAttribute("shop", shop);
		model.addAttribute("title", "Shop Management");

		return new ModelAndView("shop/myShop/editShop");
	}
	
	//product view
	@GetMapping("/shop/myproduct")
	public ModelAndView product(Model model) {

		Account account = accountService.findCurrentAccount();	
		List<Product> products = productService.findAllProductByShopId(account.getId());

		model.addAttribute("products", products);
		model.addAttribute("title", "Shop Management");

		return new ModelAndView("shop/myProduct/shop-product");
	}

	//all bills view

	/*
	 * // edit shop view
	 * 
	 * @GetMapping("/shop/mybill") public ModelAndView Bill(Model model) {
	 * 
	 * Account account = accountService.findCurrentAccount(); List<BillItem>
	 * billitems = billItemService.findAllBillItem();
	 * 
	 * model.addAttribute("title", "Shop Management");
	 * 
	 * return new ModelAndView("shop/myShop/myBill"); }
	 */
	
}
