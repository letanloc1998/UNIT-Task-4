package vn.com.unit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;

@Controller
public class HomeController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping("*")
    public ModelAndView home(Model model) {
		
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
	
	@PostMapping("/account")
	@ResponseBody
	
	public ResponseEntity<Account> createAccount(@RequestBody Account account, Model model){
		Account accountCreate = accountService.createNewAccount(account);
		Account accountRole = accountService.getAccountRole(account);
		return ResponseEntity.ok(account);
	}
}
