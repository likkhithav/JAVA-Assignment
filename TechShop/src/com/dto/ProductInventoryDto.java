package com.dto;

public class ProductInventoryDto {
	
	private int productId;
	private String name;
	private int quantityInStock;
	
	
	public ProductInventoryDto() {}

	
	public ProductInventoryDto(int productId, String name, int quantityInStock) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantityInStock = quantityInStock;
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

	
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	
	@Override
	public String toString() {
		return "ProductInventoryDto [productId=" + productId + ", name=" + name + ", quantityInStock=" + quantityInStock
				+ "]\n";
	}
	
}
