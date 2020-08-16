package vn.com.unit.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Shop;
import vn.com.unit.pageable.PageRequest;
import vn.com.unit.service.ShopService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminShopManagementController {

	@Autowired
	private ShopService shopService;

	@GetMapping("/admin/shop/list")
	public ModelAndView ShopList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {

		int totalitems = shopService.countAllShop();
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);

		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);
		
		List<Shop> shops = shopService.findShopByStatus(pageable.getLimit(), pageable.getOffset(),1);
		model.addAttribute("shops", shops);
		model.addAttribute("pageable", pageable);

		return new ModelAndView("admin/shop/shop-table");
	}
	
	@GetMapping("/admin/shop/accept-list")
	public ModelAndView ShopAcceptList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {
		int totalitems = shopService.countAllShop();
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);
		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);
		List<Shop> shops = shopService.findShopByStatus(pageable.getLimit(), pageable.getOffset(),0);
		model.addAttribute("shops", shops);
		model.addAttribute("pageable", pageable);

		return new ModelAndView("admin/shop/shop-accept-table");
	}
	
	@GetMapping("/admin/shop/deactive-list")
	public ModelAndView ShopDeactiveList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {
		int totalitems = shopService.countAllShop();
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);
		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);
		List<Shop> deactiveByAdmin = shopService.findShopByStatus(pageable.getLimit(), pageable.getOffset(),3);
		List<Shop> deactiveByVendor = shopService.findShopByStatus(pageable.getLimit(), pageable.getOffset(),2);
		deactiveByAdmin.addAll(deactiveByVendor);
		model.addAttribute("shops", deactiveByAdmin);
		model.addAttribute("pageable", pageable);
		return new ModelAndView("admin/shop/shop-deactive-table");
	}
	
	@PutMapping("/admin/shop/accept/{shop_id}")
	public ResponseEntity<Boolean> ShopAccept(Model model,
			@PathVariable("shop_id") Long shop_id,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {
			Boolean shop = shopService.setDisableShop(shop_id, (long) 1);
	
		return ResponseEntity.ok(shop);
	}
	
}
