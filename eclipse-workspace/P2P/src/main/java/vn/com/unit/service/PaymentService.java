package vn.com.unit.service;

public interface PaymentService {

	// Create bill with address
	// Move all product in cart to bill_item
	// Return id bill
	public Long createBill(String address);
	
}