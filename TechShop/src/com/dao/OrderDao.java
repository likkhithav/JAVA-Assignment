package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Orders;

public interface OrderDao {
	
	public void calculateTotalAmount() throws SQLException;

	public List<Orders> getOrderDetails() throws SQLException;

	public void updateOrderStatus(int id, String ostatus) throws SQLException;

	public void cancelOrder(int oid1) throws SQLException;
	
}
