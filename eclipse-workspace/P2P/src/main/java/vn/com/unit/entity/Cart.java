package vn.com.unit.entity;

import java.util.Date;

//import org.springframework.data.annotation.Id;

import jp.sf.amateras.mirage.annotation.Column;
//import jp.sf.amateras.mirage.annotation.PrimaryKey;
//import jp.sf.amateras.mirage.annotation.PrimaryKey.GenerationType;
import jp.sf.amateras.mirage.annotation.Table;

@Table(name = "p2p_cart")
public class Cart {

//	@Id
//	@PrimaryKey(generationType = GenerationType.IDENTITY) // Primary key // Auto increment
//	@Column(name = "id")
//	private Long id;
	
	@Column(name = "account")
	private Long account;
	
	@Column(name = "product")
	private Long product;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "create_at")
	private Date createAt;

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
