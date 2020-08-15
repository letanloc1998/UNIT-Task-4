package vn.com.unit.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.BillItem;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
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
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;

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
	public ModelAndView product(Model model, @RequestParam(name = "mode") String mode) {
		String type = "";
		if(mode.equals("create")) {
			 type = "shop/myProduct/shop-add-product";
		}
		if(mode.equals("edit")) {
			 type = "shop/myProduct/shop-add-product";
		}
		if(mode.equals("view")) {
			 type = "shop/myProduct/shop-product";
		}
		Account account = accountService.findCurrentAccount();	
		List<Product> products = productService.findAllProductByShopId(account.getId());
		List<Brand> brands = brandService.findAllBrand();
		List<Category> categories = categoryService.findAllCategory();
		model.addAttribute("products", products);
		model.addAttribute("title", "Shop Management");
		

		model.addAttribute("brands", brands);
		model.addAttribute("categories", categories);
		model.addAttribute("new_product", new Product());
		return new ModelAndView(type);
	}

	//add product
	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute("new_product") Product new_product, Model model) {
		Account account = accountService.findCurrentAccount();		
		productService.createNewProduct(new_product.getName(), new_product.getPrice(), new_product.getQuantity(), new_product.getCategory(), new_product.getBrand(), new_product.getDetail(), new_product.getImg(), account.getId());
		return "redirect:/shop/myproduct?mode=view"; 
	}
	
}
