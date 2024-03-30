package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDaoImpl;
import com.dto.ProductInventoryDto;
import com.model.Product;

public class ProductService {

	ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	
	public List<Product> getProductDetails() throws SQLException {
		List<Product>list=productDaoImpl.getProductDetails();
		return list;
	}

	
	public void updateProductInfo(int pid, Double pprice) throws SQLException {
		productDaoImpl.updateProductInfo(pid, pprice);
	}

	
	public List<ProductInventoryDto> isProductInStock(int id1) throws SQLException {
		return productDaoImpl.isProductInStock(id1);
	}

}
