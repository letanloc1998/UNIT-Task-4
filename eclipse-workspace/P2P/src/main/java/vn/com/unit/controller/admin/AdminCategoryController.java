package vn.com.unit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Category;
import vn.com.unit.pageable.PageRequest;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.CategoryService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/admin/category/list")
	public ModelAndView accountList(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
			HttpServletRequest request) {

		int totalitems =  categoryService.countAllCategory();
		int totalpages = (int) Math.ceil((double) totalitems / (double) limit);
		PageRequest pageable = new PageRequest(page, limit, totalitems, totalpages);
		List<Category> categories = categoryService.findCategoryPageable(pageable.getLimit(), pageable.getOffset());
		model.addAttribute("categories", categories);
		model.addAttribute("pageable", pageable);
		return new ModelAndView("admin/category/category-table");
	}
	@GetMapping("/admin/category/add")
	public ModelAndView accountAdd(Model model,
			HttpServletRequest request) {

		return new ModelAndView("admin/category/category-add");
	}
	
	@PostMapping("/admin/category/add")
	@ResponseBody
	public ResponseEntity<String> createAccount(@RequestBody Category category, Model model) {
		if (categoryService.findCategoryByName(category.getName()) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"msg\" : \"Category already exists\" }");}
		Long category_id = categoryService.createCategory(category);
		if (category_id != null) {
			return ResponseEntity.ok("{ \"id\" : " + category_id + ", \"msg\" : \"Create category successfully\" }");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("{ \"msg\" : \"You can't create an category right now. Try again later\" }");
		
	}
}
