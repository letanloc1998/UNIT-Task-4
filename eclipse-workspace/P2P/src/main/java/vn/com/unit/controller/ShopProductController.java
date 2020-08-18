package vn.com.unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;
import vn.com.unit.pageable.PageRequest;
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
    public ModelAndView home(Model model, 
    		@PathVariable ("shop_id") Long shop_id, 
    		@RequestParam(value = "category",required=false) Long category_id, 
    		@RequestParam(value = "brand",required=false) Long brand_id,
    		@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit
    		) {
			//get all infor of shop
			Shop shop = shopService.findShopByAccountId(shop_id);
			model.addAttribute("shop", shop);
			//get brand and category
			List<Brand> brands = brandService.findAllBrand();
			List<Category> categories = categoryService.findAllCategory();
			model.addAttribute("brands", brands);
			model.addAttribute("categories", categories);
			//get product by category
//			if(category_id != null && brand_id == null) {
//				//get all products  by scategory
//				List<Product> products = productService.findAllProductByCategoryId(category_id);
//				model.addAttribute("products", products);
//				model.addAttribute("title", shop.getName());
//		        return new ModelAndView("shop");
//			}
//			if(brand_id != null && category_id == null) {
//				//get all products  by brand
//				List<Product> products = productService.findAllProductByBrandId(brand_id);
//				model.addAttribute("products", products);
//				model.addAttribute("title", shop.getName());
//		        return new ModelAndView("shop");
//			}
//			if(category_id != null || brand_id != null) {
				//get all products  by category and brand
				int totalitems = productService.countAllProductByCategoryIdAndBrandId(category_id, brand_id,shop_id);
				PageRequest pageable = new PageRequest(page, limit, totalitems);
				
				List<Product> products = productService.findAllProductByCategoryIdAndBrandId(category_id, brand_id, shop_id, pageable.getLimit(),pageable.getOffset());
			
				model.addAttribute("products", products);
				model.addAttribute("pageable", pageable);
				model.addAttribute("title", shop.getName());
		        return new ModelAndView("shop");
//			}
			
			//get all products  by shop
			
//			int totalitems = productService.CountAllProductByShopId(shop_id);
//
//			PageRequest pageable = new PageRequest(page, limit, totalitems);
//			
//			List<Product> products = productService.findAllProductByShopId(shop_id,pageable.getLimit(), pageable.getOffset());
//			model.addAttribute("pageable", pageable);
//
//			model.addAttribute("products", products);
//			model.addAttribute("title", shop.getName());
//	        return new ModelAndView("shop");
    }
	
}
