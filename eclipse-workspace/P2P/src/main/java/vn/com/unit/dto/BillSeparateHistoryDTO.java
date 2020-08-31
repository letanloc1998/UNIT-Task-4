package vn.com.unit.dto;

import java.util.Date;

import vn.com.unit.entity.BillSeparate;

public class BillSeparateHistoryDTO extends BillSeparate {

	public BillSeparateHistoryDTO(BillSeparate billSeparate) {
		super(billSeparate);
	}

	private String shopName;
	private String shopEmail;
	private String shopPhone;
	private String shippingAdd;
	private Long totalPrice;
	private Long payment;
	private Date createAt;
	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		totalPrice = totalPrice;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getShippingAdd() {
		return shippingAdd;
	}

	public void setShippingAdd(String shippingAdd) {
		this.shippingAdd = shippingAdd;
	}
	
}
