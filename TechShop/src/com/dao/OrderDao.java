package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Orders;

public interface OrderDao {
	
	public void calculateTotalAmount() throws SQLException;

	public List<Orders> getOrderDetails();

	public void updateOrderStatus(int id, String ostatus);

	public void cancelOrder(int oid1);
	
}
