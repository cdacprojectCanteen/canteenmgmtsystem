package com.canteenmanagement.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.canteenmanagement.utils.OrderStatus;

@Entity
@Table(name="orders")
public class Order {
	private Integer orderId;
	private Customer customer;
	private List<OrderedProduct> products;
//	private List<Product> products;
	private Date orderTime;
	private long transactionNo;
	private String couponCode;
	private OrderStatus orderStatus;
	
	public Order() {
		
	}

	public Order(Integer orderId, Customer customer, List<OrderedProduct> products, Date orderTime, long transactionNo,
			String couponCode, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.products = products;
		this.orderTime = orderTime;
		this.transactionNo = transactionNo;
		this.couponCode = couponCode;
		this.orderStatus = orderStatus;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="product_id")
	@ElementCollection(fetch=FetchType.EAGER)
//	@CollectionTable(name="ordered_products",joinColumns=@JoinColumn(name="product_id"))
	@CollectionTable(name="ordered_products",joinColumns=@JoinColumn(name="order_id"))
	public List<OrderedProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderedProduct> products) {
		this.products = products;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public long getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(long transactionNo) {
		this.transactionNo = transactionNo;
	}

	@Column(name="coupon_code", unique=true)
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Column(name="order_status")
	@Enumerated(EnumType.STRING)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}
