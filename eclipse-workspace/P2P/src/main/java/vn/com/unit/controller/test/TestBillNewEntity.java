package vn.com.unit.controller.test;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.unit.entity.BillNewEntity;
import vn.com.unit.service.BillNewEntityService;

//import jp.sf.amateras.mirage.SqlExecutor;
import com.miragesql.miragesql.naming.DefaultNameConverter;

@Controller
public class TestBillNewEntity {

	@Autowired
	BillNewEntityService billNewEntityService;

	@GetMapping("/test/bill")
	public ModelAndView bill(Model model) {

		BillNewEntity billNewEntity = new BillNewEntity();
		billNewEntity.setAccount(1L);
		billNewEntity.setAddress("An Giang");
		billNewEntity.setPayment(2000L);
//		billNewEntity.setCreateAt((new Date()));

		BillNewEntity billNewEntityCreate = billNewEntityService.save(billNewEntity);

		List<BillNewEntity> billNewEntityList = billNewEntityService.findAll();
		
		int page = 1;
		int size = 10;
		Direction direction = Direction.DESC;
		
		Sort sort = new Sort(Sort.Direction.DESC, "id")
        .and(new Sort(Sort.Direction.ASC, "create_at"));
		
		Pageable pageable = new PageRequest(page, size, sort);
		List<BillNewEntity> billNewEntityListPageable = billNewEntityService.findAll(pageable);

		return new ModelAndView("home");
	}

}
