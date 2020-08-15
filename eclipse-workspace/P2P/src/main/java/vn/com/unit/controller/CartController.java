package vn.com.unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.CartItem;
import vn.com.unit.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/cart")
	public ModelAndView cart(Model model) {
		
		List<CartItem> list_cart_item = cartService.findAllCartItemByCurrentAccount();
		
		model.addAttribute("list_cart_item", list_cart_item);
		
		model.addAttribute("title", "Cart");
		return new ModelAndView("/cart");
	}
	
}
