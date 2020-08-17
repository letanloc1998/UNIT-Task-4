package vn.com.unit.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import vn.com.unit.entity.Category;
import vn.com.unit.service.CategoryService;

public class CommonUtils {
	
	public static int ROW_OF_PAGE = 3;
	
	public static String DEFAULT_PASSWORD = "123";

	public static String encodePassword(String rawPassword) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(rawPassword);
	}
	
	// Convert from ISO-8859-1 to UTF-8
	public static String convertEncode(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("ISO-8859-1"), "UTF-8");
	}
	
	public static Map<String, Object> getMapHeaderAtribute(Model model, CategoryService categoryService) {
		List<Category> categories = categoryService.findAllCategory();
//		model.addAttribute("categories", categories);
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("categories", categories);
		return map;
	}

}
