package vn.com.unit.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("*")
    public ModelAndView home(Model model) {
		
		TestMomo test = new TestMomo();
		try {
			test.test();
		} catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return new ModelAndView("index");
    }

	@RequestMapping("/register")
    public ModelAndView register(Model model) {

        return new ModelAndView("register");
    }
	
	@RequestMapping("/login")
	public ModelAndView login(Model model) {

		model.addAttribute("title", "Login");
		return new ModelAndView("login");
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession httpSession = request.getSession(false);
		if (httpSession != null) {
			httpSession.invalidate();
		}

		return "redirect:/";
	}
	
}
