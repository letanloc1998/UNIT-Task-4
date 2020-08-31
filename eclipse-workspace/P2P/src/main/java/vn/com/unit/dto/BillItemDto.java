package vn.com.unit.dto;

import vn.com.unit.entity.BillItem;

public class BillItemDto extends BillItem {

	private String name;
	
	private String img;
	
	private Long price;
	
	public BillItemDto(BillItem billItem) {
		super(billItem);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Long getTotal() {
		return this.getPrice()*this.getQuantity();
	}
}
