package vn.com.unit.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

	@RequestMapping("/admin/home")
	public ModelAndView home(Model model) {

		return new ModelAndView("admin/home");
	}

}
