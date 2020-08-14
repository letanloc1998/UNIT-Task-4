package vn.com.unit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@GetMapping("/cart")
	public ModelAndView cart(Model model) {
		
		model.addAttribute("title", "Cart");
		return new ModelAndView("/cart");
	}
	
}
