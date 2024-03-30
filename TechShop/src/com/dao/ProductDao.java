package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ProductInventoryDto;
import com.model.Product;

public interface ProductDao {
	
	public List<Product> getProductDetails() throws SQLException;

	public void updateProductInfo(int pid, Double pprice) throws SQLException;

	public List<ProductInventoryDto> isProductInStock(int id1) throws SQLException;
	
}
