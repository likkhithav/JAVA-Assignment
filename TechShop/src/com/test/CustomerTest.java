package com.test;


import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Customer;
import com.service.CustomerService;

public class CustomerTest {

	CustomerService  customerService=new CustomerService();

	@Test
	public void calculateTotalOrder() throws SQLException
	{
		int cid=1;
		try 
		{
			customerService.calculateTotalOrder(cid);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		cid=17;
		try 
		{
			customerService.calculateTotalOrder(cid);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void getCustomerDetails() throws SQLException
	{
		try 
		{
			List<Customer>list=customerService.getCustomerDetails();
			Assert.assertNotNull(list);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void updateCustomerInfoTest() throws SQLException
	{
		//use case 1
		int id=1;
		String cemail="diya@gmail.com";
		try 
		{
			customerService.updateCustomerInfo(id, cemail);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id=15;
		cemail="thyme@gmailcom";
		try 
		{
			customerService.updateCustomerInfo(id, cemail);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
}
