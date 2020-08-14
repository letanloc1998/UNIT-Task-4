package vn.com.unit.entity;

import java.util.Date;
import java.util.List;

public class Bill {

	private Long id;
	
//	private Long momo_order_id;
	
	private String account;
	
	private String address;
		
	private boolean payment;
	
	private boolean status;
	
	private boolean refund;
	
	private Date createAt;
	
	public Bill() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getMomo_order_id() {
//		return momo_order_id;
//	}
//
//	public void setMomo_order_id(Long momo_order_id) {
//		this.momo_order_id = momo_order_id;
//	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isRefund() {
		return refund;
	}

	public void setRefund(boolean refund) {
		this.refund = refund;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
		
}