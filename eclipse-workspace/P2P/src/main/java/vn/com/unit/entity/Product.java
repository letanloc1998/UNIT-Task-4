package vn.com.unit.entity;

import java.util.Date;
import java.util.List;

public class Product {

	private Long id;

	private Long shop;
	
	private String name;
	
	private int price;
	
	private String detail;
	
	private String img;
	
	private int category;
	
	private boolean disable;
	
	private Date createAt;
	
	private int brand;
	
	private int quantity;
	
	private Brand brand_name;
	
	private Category category_name;
	
	public Product() {
		
	}
	
	public Brand getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(Brand brand_name) {
		this.brand_name = brand_name;
	}

	public Category getCategory_name() {
		return category_name;
	}

	public void setCategory_name(Category category_name) {
		this.category_name = category_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShop() {
		return shop;
	}

	public void setShop(Long shop) {
		this.shop = shop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	


	
}