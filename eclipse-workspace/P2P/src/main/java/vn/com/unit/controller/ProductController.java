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
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	BrandService brandService;
	@Autowired
	ShopService shopService;
	
	
	@GetMapping("/product/{product_id}")
    public ModelAndView home(Model model, @PathVariable ("product_id") Long product_id) {
		Product product = productService.findProductByProductId(product_id);
		Shop shop = shopService.findShopByAccountId(product.getShop());
		model.addAttribute("product", product);
		Long id = (long) product.getCategory();
		List<Product> products = productService.findAllProductByCategoryId(id);
		model.addAttribute("products", products);
		List<Brand> brands = brandService.findAllBrand();
		List<Category> categories = categoryService.findAllCategory();
		model.addAttribute("brands", brands);
		model.addAttribute("categories", categories);
		model.addAttribute("shop", shop);
		model.addAttribute("title", product.getName());
        return new ModelAndView("product-detail");
    }
	
}
