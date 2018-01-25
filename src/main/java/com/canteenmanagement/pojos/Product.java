package com.canteenmanagement.pojos;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	private Integer productId;
	private String name;
	private Category category;
	private double price;
	private double oldPrice;
	private double quantity;
	private List<String> tags;
	private String description;
	
	public Product() {

	}
	
	public Product(Integer productId, String name, Category category, double price, double oldPrice, double quantity,
			List<String> tags, String description) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.oldPrice = oldPrice;
		this.quantity = quantity;
		this.tags = tags;
		this.description = description;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Column(name="old_price")
	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="product_tags",joinColumns=@JoinColumn(name="product_id"))
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", oldPrice=" + oldPrice + ", quantity=" + quantity + ", tags=" + tags + ", description="
				+ description + "]";
	}
	
	
	
}
