package vn.com.unit.controller.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestUploadImg {

	@GetMapping("/test/upload")
	public ModelAndView uploadFile(Model model) {
		
		
		return new ModelAndView("upload");
	}
	
//	@PostMapping("/test/upload")
//	public ModelAndView saveFile(Model model, @RequestBody Map<String, String> json, @RequestParam("file") MultipartFile file) {
//		
//		
//		return null;
//	}
	
//	, @RequestBody String json
	@PostMapping("/test/upload")
	public ModelAndView saveFile(Model model, @RequestParam("file") MultipartFile file) {
		
		
		return null;
	}
	
}
