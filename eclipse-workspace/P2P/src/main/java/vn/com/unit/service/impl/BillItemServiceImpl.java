package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.BillItem;
import vn.com.unit.repository.BillItemRepository;
import vn.com.unit.repository.BillRepository;
import vn.com.unit.repository.ProductRepository;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.BillItemService;

@Service
@Transactional
public class BillItemServiceImpl implements BillItemService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	BillItemRepository billItemRepository;
	
	
	
	@Override
	public List<BillItem> findAllBillItemByBillId(Long bill_id) {

		return billItemRepository.findAllBillItemByBillId(bill_id);
	}
	
	@Override
	public List<BillItem> findAllBillItem() {
		
		return billItemRepository.findAllBillItem();
	}
	

}
