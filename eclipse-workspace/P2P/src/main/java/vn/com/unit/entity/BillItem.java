package vn.com.unit.entity;

public class BillItem {

	private Long id;
	
	private int product;
	
	private Product product_name;
	
	private int quantity;
	
	public BillItem() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}
	public Product getProduct_name() {
		return product_name;
	}

	public void setProduct_name(Product product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	


	
		
}