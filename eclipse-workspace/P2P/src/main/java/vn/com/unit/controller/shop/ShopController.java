package vn.com.unit.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
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
		return new ModelAndView("shop/shop");
	}

	// edit shop view
	@GetMapping("/shop/myshop")
	public ModelAndView myShop(Model model) {

		Account account = accountService.findCurrentAccount();
		Shop shop = shopService.findShopByAccountId(account.getId());

		model.addAttribute("shop", shop);
		model.addAttribute("current_account", account);

		return new ModelAndView("shop/myShop/editShop");
	}

}
