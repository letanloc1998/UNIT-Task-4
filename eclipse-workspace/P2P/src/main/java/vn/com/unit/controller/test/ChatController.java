package vn.com.unit.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

	@GetMapping("/test/chat")
	public ModelAndView testChat(Model model) {

		return new ModelAndView("chat");
	}
	
}
