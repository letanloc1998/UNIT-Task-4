package vn.com.unit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.CartItem;
import vn.com.unit.service.CartService;
import vn.com.unit.service.CategoryService;
import vn.com.unit.utils.CommonUtils;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	CategoryService categoryService;

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

		model.addAllAttributes(CommonUtils.getMapHeaderAtribute(model, categoryService));

		List<CartItem> list_cart_item = cartService.findAllCartItemByCurrentAccount();

		model.addAttribute("list_cart_item", list_cart_item);

		Long total = cartService.calculateCartTotalByCurrentAccount();

		model.addAttribute("total", total);

		model.addAttribute("title", "Cart");
		return new ModelAndView("/cart");
	}

//	18:22:16,779 WARN  [org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver] (default task-10) Resolved exception caused by handler execution: org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot construct instance of `java.util.LinkedHashMap` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('{"product_id" : 2}'); nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of `java.util.LinkedHashMap` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('{"product_id" : 2}')
//	 at [Source: (PushbackInputStream); line: 1, column: 1]


//	public ResponseEntity<String> add(Model model, @RequestBody Map<String, String> json) {
	@PutMapping("/cart/add")
	@ResponseBody
	public ResponseEntity<String> add(Model model, @RequestBody String json) {
		
//		insert into p2p_cart (account, product, quantity) values (3, 1, 1);
//		cartService.addCartItemCurentAccount(Long.valueOf(json.get("product_id")), 1);
		
		return ResponseEntity.ok(null);
	}

}
