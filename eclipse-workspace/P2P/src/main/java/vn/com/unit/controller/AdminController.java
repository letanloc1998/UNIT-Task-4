package vn.com.unit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/admin/home")
    public ModelAndView adminhome(Model model) {
        return new ModelAndView("admin/home");
    }
	
}
