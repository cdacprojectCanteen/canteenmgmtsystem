package com.canteenmanagement.pojos;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="orderedproducts")
@Embeddable
public class OrderedProduct {
	private Integer productId;
	private String name;
	private Category category;
	private double price;
	private double quantity;
	
	public OrderedProduct() {

	}
	
	
public OrderedProduct(Integer productId, String name, Category category, double price, double quantity) {
	super();
	this.productId = productId;
	this.name = name;
	this.category = category;
	this.price = price;
	this.quantity = quantity;
}




//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


}
