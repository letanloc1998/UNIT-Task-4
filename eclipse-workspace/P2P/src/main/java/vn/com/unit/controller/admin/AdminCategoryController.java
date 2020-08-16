package vn.com.unit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

}
