package com.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Orders;
import com.service.OrderService;

public class OrderTest {
	
	OrderService  orderService=new OrderService();
	
	@Test
	public void calculateTotalAmount() throws SQLException
	{
		try 
		{
			orderService.calculateTotalAmount();
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void getCustomerDetails()
	{
		try 
		{
			List<Orders>list=orderService.getOrderDetails();
			Assert.assertNotNull(list);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void updateOrderStatus() throws SQLException
	{
		//use case 1
		int id=1;
		String status="shipped";
		try 
		{
			orderService.updateOrderStatus(id, status);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id=15;
		status="notshipped";
		try 
		{
			orderService.updateOrderStatus(id, status);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void cancelOrder() throws SQLException
	{
		//use case 1
		int id=1;
		try 
		{
			orderService.cancelOrder(id);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id=15;
		try 
		{
			orderService.cancelOrder(id);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
}
