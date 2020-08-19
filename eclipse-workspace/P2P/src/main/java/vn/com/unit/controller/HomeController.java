package vn.com.unit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Product;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BrandService;
import vn.com.unit.service.CategoryService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.RoleService;
import vn.com.unit.utils.CommonUtils;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BrandService brandService;

	@GetMapping("*")
	public ModelAndView home(Model model, @Param("name") String name) {

		model.addAllAttributes(CommonUtils.getMapHeaderAtribute(model, categoryService));

		// Add Role if reload

		try {
			Account account = accountService.findCurrentAccount();

			if (account != null) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();

				List<GrantedAuthority> authorities = new ArrayList<>();

				authorities = roleService.findAuthorities(account);

				Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),
						auth.getCredentials(), authorities);

				SecurityContextHolder.getContext().setAuthentication(newAuth);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("title", "Home");

//		List<Category> categories = categoryService.findAllCategory();
//		model.addAttribute("categories", categories);

		List<Product> product = productService.findAllProduct();
		model.addAttribute("product", product);

		return new ModelAndView("index");
	}

	@GetMapping("/product-by-search")
	public ModelAndView test(Model model, @RequestParam("name") String name) {
		
		model.addAllAttributes(CommonUtils.getMapHeaderAtribute(model, categoryService));
		
		List<Product> products = productService.findProductByName(name);
		model.addAttribute("products", products);
		model.addAttribute("name", name);
		
		List<Brand> brands = brandService.findAllBrand();
		model.addAttribute("brands", brands);

		return new ModelAndView("product-by-search");
	}

	@GetMapping("/register")
	public ModelAndView register(Model model) {

		return new ModelAndView("register");
	}

	@GetMapping("/login")
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
