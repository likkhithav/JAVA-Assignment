package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDaoImpl;
import com.model.Orders;

public class OrderService {

	OrderDaoImpl orderDaoImpl=new OrderDaoImpl();
	
	public void calculateTotalAmount() throws SQLException{
		orderDaoImpl.calculateTotalAmount();
	}

	
	public List<Orders> getOrderDetails() {
		List<Orders>list=orderDaoImpl.getOrderDetails();
		return list;
	}

	
	public void updateOrderStatus(int id, String ostatus) {
		orderDaoImpl.updateOrderStatus(id, ostatus);
	}

	
	public void cancelOrder(int oid1) {
		orderDaoImpl.cancelOrder(oid1);
	}
}
