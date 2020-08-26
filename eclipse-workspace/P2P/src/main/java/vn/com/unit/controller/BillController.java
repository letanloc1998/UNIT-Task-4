package vn.com.unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.Bill;
import vn.com.unit.service.BillService;

@Controller
public class BillController {

	@Autowired
	BillService billService;
	
	@GetMapping("/bill/{id}")
	public ModelAndView bill(@PathVariable ("id") Long id, Model model) {
		
		Bill bill = billService.findBillOfCurrentAccountByBillId(id);
		
		model.addAttribute("bill", bill);
		
		return new ModelAndView("/bill");
	}
	
}
