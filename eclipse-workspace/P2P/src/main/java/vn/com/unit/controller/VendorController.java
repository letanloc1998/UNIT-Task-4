package vn.com.unit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class VendorController {

	@RequestMapping("/vendor/home")

	public ModelAndView home(Model model) {

		return new ModelAndView("components/vendor/vendor");
	}
	/*
	 * @RequestMapping("/admin/account/list") public ModelAndView accountList(Model
	 * model) {
	 * 
	 * return new ModelAndView("admin/account/account-table"); }
	 */

}
