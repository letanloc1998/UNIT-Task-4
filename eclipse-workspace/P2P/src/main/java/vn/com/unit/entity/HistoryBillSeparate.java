package vn.com.unit.entity;

import java.util.Date;

public class HistoryBillSeparate {

	private Long id;

	private Long billId;
	private Long shopId;
	private String shop;
	private String shopName;
	private String Email;
	private String Phone;
	private String ShippingAddres;
	
	private Long status;
	
	private Long refund;
	
	private Long TotalPrice;
	private Long payment;
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBill() {
		return billId;
	}

	public void setBill(Long bill) {
		this.billId = bill;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getRefund() {
		return refund;
	}

	public void setRefund(Long refund) {
		this.refund = refund;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		TotalPrice = totalPrice;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getShippingAddres() {
		return ShippingAddres;
	}

	public void setShippingAddres(String shippingAddres) {
		ShippingAddres = shippingAddres;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}
	
}
