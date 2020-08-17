package vn.com.unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;
import vn.com.unit.service.BrandService;
import vn.com.unit.service.CategoryService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.ShopService;

@Controller
public class ShopProductController {

	@Autowired
	ProductService productService;
	@Autowired
	ShopService shopService;
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/shop/{shop_id}")
    public ModelAndView home(Model model, @PathVariable ("shop_id") Long shop_id) {
		Shop shop = shopService.findShopByAccountId(shop_id);
		List<Product> products = productService.findAllProductByShopId(shop_id);
		model.addAttribute("products", products);
		model.addAttribute("shop", shop);
		
		List<Brand> brands = brandService.findAllBrand();
		List<Category> categories = categoryService.findAllCategory();
		model.addAttribute("brands", brands);
		model.addAttribute("categories", categories);

		model.addAttribute("title", shop.getName());
        return new ModelAndView("shop");
    }
	
}
