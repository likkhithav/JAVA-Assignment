package com.model;

import java.time.LocalDate;

public class Orders {
	
	private int id;
	private LocalDate orderDate;
	private double totalAmount;
	private int quantity;
	private int customerId;
	private int productId;
	private String status;
	
	
	public Orders() {}
	
	
	public Orders(int id, LocalDate orderDate, double totalAmount, int quantity, int customerId, int productId,
			String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.customerId = customerId;
		this.productId = productId;
		this.status = status;
	}
	
	
	public Orders(LocalDate orderDate, double totalAmount, int quantity, int customerId, int productId, String status) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.customerId = customerId;
		this.productId = productId;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", quantity="
				+ quantity + ", customerId=" + customerId + ", productId=" + productId + ", status=" + status + "]";
	}
	
}
