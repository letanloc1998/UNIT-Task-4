package vn.com.unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;
import vn.com.unit.service.ProductService;

public class ProductDetailController {

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/product/{product_id}")
    public ModelAndView home(Model model, @PathVariable ("product_id") Long product_id) {
		Product product = productService.findProductByProductId(product_id);
		model.addAttribute("product", product);
		

		model.addAttribute("title", product.getName());
        return new ModelAndView("product_detail");
    }
	
}
