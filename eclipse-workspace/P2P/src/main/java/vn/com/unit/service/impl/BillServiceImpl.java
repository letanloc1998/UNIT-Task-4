package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Product;
import vn.com.unit.repository.BillRepository;
import vn.com.unit.repository.ProductRepository;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.BillService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.ShopService;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BillRepository billRepository;
	
	
	
	@Override
	public List<Bill> findAllBillByAccountId(Long account_id) {
		
		return billRepository.findAllBillByAccountId(account_id);
	}

	@Override
	public Long createBill(Long account_id, String address) {
		
		return billRepository.createBill(account_id, address);
	}

	@Override
	public void addBillItemFromCart(Long billId, Long currentAccountId) {
		
		billRepository.addBillItemFromCart(billId, currentAccountId);
	}
	

}
