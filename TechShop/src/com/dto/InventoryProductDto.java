package com.dto;

import java.time.LocalDate;

public class InventoryProductDto {
	
	private int id;
	private int quantityInStock;
	private LocalDate lastStockUpdate;
	private int productId;
	private String name;
	private double price;
	
	
	public InventoryProductDto() {}

	
	public InventoryProductDto(int id, int quantityInStock, LocalDate lastStockUpdate, int productId, String name,
			double price) {
		super();
		this.id = id;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	
	public LocalDate getLastStockUpdate() {
		return lastStockUpdate;
	}
	public void setLastStockUpdate(LocalDate lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}

	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "InventoryProductDto [id=" + id + ", quantityInStock=" + quantityInStock + ", lastStockUpdate="
				+ lastStockUpdate + ", productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
}
