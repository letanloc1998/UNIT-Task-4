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

//		select cart.*, product.*
//		from
//			(
//			select *
//			from p2p_cart
//			where account = 3
//			) cart
//		left join p2p_product product
//		on product.id = cart.product

		List<CartItem> list_cart_item = cartService.findAllCartItemByCurrentAccount();

		model.addAttribute("list_cart_item", list_cart_item);
		
		Long total = cartService.calculateCartTotalByCurrentAccount();
		
		model.addAttribute("total", total);

		model.addAttribute("title", "Cart");
		return new ModelAndView("/cart");
	}

}
