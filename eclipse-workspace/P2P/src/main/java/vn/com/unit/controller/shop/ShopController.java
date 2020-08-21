package vn.com.unit.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.BillSeparate;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;
import vn.com.unit.pageable.PageRequest;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillItemService;
import vn.com.unit.service.BillSeparateService;
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
	
	@Autowired
	BillSeparateService billSeparateService;

	// home view
	@GetMapping("/shop/home")
	public ModelAndView shopHome(Model model) {
		Account account = accountService.findCurrentAccount();
		Shop shop = shopService.findShopByAccountId(account.getId());
		
		if(shop == null) {
			return new ModelAndView("shop/myShop/create-shop");
		}
		
		model.addAttribute("shop", shop);
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
	public ModelAndView product(
			Model model,
			@RequestParam(name = "mode") String mode,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request
			) {
		String type = "";
		if(mode.equals("create")) {
			 type = "shop/myProduct/shop-add-product";
		}
		if(mode.equals("edit")) {
			 type = "shop/myProduct/shop-edit-product";
		}
		if(mode.equals("view")) {
			 type = "shop/myProduct/shop-product";
		}
		
		
		
		Account account = accountService.findCurrentAccount();	
		int totalitems = productService.CountAllProductByShopId((long) account.getId());
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);
		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);
		
		List<Product> products = productService.findAllProductByShopId(account.getId(),pageable.getLimit(), pageable.getOffset());
		
		
		List<Brand> brands = brandService.findAllBrand();
		List<Category> categories = categoryService.findAllCategory();
		model.addAttribute("products", products);
		model.addAttribute("title", "Shop Management");
		
		model.addAttribute("pageable", pageable);

		model.addAttribute("brands", brands);
		model.addAttribute("categories", categories);
		model.addAttribute("new_product", new Product());
		return new ModelAndView(type);
	}
	
	//edit product view
	@PostMapping("/shop/myproduct")
	public ModelAndView editProduct(Model model, @RequestParam(name = "product_id") Long product_id) {
		Product product = productService.findProductByProductId(product_id);
		//Account account = accountService.findCurrentAccount();	
		//List<Product> products = productService.findAllProductByShopId(account.getId());
		List<Brand> brands = brandService.findAllBrand();
		List<Category> categories = categoryService.findAllCategory();
		model.addAttribute("product", product);
		model.addAttribute("title", "Shop Management");
		Account account = accountService.findCurrentAccount();	
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);

		model.addAttribute("brands", brands);
		model.addAttribute("categories", categories);
		return new ModelAndView("shop/myProduct/shop-edit-product");
	}

	@GetMapping("/shop/mybill")
	public ModelAndView bill(
			Model model,
			/*
			 * @RequestParam(value = "page", required = false, defaultValue = "1") int page,
			 * 
			 * @RequestParam(value = "limit", required = false, defaultValue = "10") int
			 * limit,
			 */
			HttpServletRequest request
			) {
		
		
		Account account = accountService.findCurrentAccount();	
		Shop shop = shopService.findShopByAccountId(account.getId());
		model.addAttribute("shop", shop);	
		/*
		 * int totalitems = productService.CountAllProductByShopId((long)
		 * account.getId()); int totalpages = (int) Math.ceil((double) totalitems /
		 * (double) limit);
		 */
		
		List<BillSeparate> bills = billSeparateService.findBillSeparatePaymentSuccessAndStatusWaitingByShopId(account.getId());

		model.addAttribute("bills", bills);
		
		return new ModelAndView("shop/myBill/myBill");
	}
	
}
