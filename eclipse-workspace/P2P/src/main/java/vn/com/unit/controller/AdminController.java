package vn.com.unit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/admin/home")
	public ModelAndView home(Model model) {

		return new ModelAndView("admin/home");
	}
	@RequestMapping("/admin/account/list")
	public ModelAndView accountList(Model model) {

		return new ModelAndView("admin/account/account-table");
	}

}
