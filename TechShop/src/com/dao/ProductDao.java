package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.ProductInventoryDto;
import com.model.Product;

public interface ProductDao {
	
	public List<Product> getProductDetails();

	public void updateProductInfo(int pid, Double pprice);

	public List<ProductInventoryDto> isProductInStock(int id1) throws SQLException;
	
}
