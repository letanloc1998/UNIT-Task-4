package vn.com.unit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.pageable.PageRequest;
import vn.com.unit.pageable.pageItem;
import vn.com.unit.pageable.pageable;
import vn.com.unit.service.AccountService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class ShopController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/admin/shop/list")
	public ModelAndView accountList(
			Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/shop/shop-table");
		return mav;
	}

}
