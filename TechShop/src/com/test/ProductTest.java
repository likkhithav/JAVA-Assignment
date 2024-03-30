package com.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dto.ProductInventoryDto;
import com.model.Product;
import com.service.ProductService;

public class ProductTest {
	
	ProductService  productService=new ProductService();
	
	@Test
	public void getProductDetails() throws SQLException
	{
		try 
		{
			List<Product>list=productService.getProductDetails();
			Assert.assertNotNull(list);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void updateProductInfo() throws SQLException
	{
		//use case 1
		int pid=1;
		double pprice=25000.0;
		try 
		{
			productService.updateProductInfo(pid, pprice);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		pid=19;
		pprice= 43000.0;
		try 
		{
			productService.updateProductInfo(pid, pprice);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void isProductInStock() throws SQLException
	{
		int id1=1;
		try 
		{
			List<ProductInventoryDto> p= productService.isProductInStock(id1);
			Assert.assertNotNull(p);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		id1=17;
		try 
		{
			List<ProductInventoryDto> p= productService.isProductInStock(id1);
			Assert.assertNotNull(p);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
}
