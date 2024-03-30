package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Orders;
import com.util.DBUtil;

public class OrderDaoImpl {

	public void calculateTotalAmount() throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		String sql="select sum(total_amount) as CalculatedTotalAmount from orders";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		double totalAmount = 0;
		try {
			if(rst.next())
			{
				totalAmount = rst.getDouble("CalculatedTotalAmount");
			}
			System.out.println("Total amount of all order placed: " +totalAmount);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
	}

	
	public List<Orders> getOrderDetails() {

		Connection conn = DBUtil.getDBConn();
		List<Orders>list=new ArrayList<>();
		String sql="select * from orders";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				int id=rst.getInt("id");
				LocalDate orderDate=rst.getDate("order_date").toLocalDate();
				double totalAmount=rst.getDouble("total_amount");
				int quantity=rst.getInt("quantity");
				int customerId=rst.getInt("customer_id");
				int productId=rst.getInt("product_id");
				String status=rst.getString("status");
				
				Orders m=new Orders();
				m.setId(id);
				m.setOrderDate(orderDate);
				m.setTotalAmount(totalAmount);
				m.setQuantity(quantity);
				m.setCustomerId(customerId);
				m.setProductId(productId);
				m.setStatus(status);
				list.add(m);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
		return list;
	}

	
	public void updateOrderStatus(int id, String ostatus) {
		
		Connection conn = DBUtil.getDBConn();
		String sql="update orders SET status=? where id=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ostatus);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
	}

	
	public void cancelOrder(int oid1) {
		
		Connection conn = DBUtil.getDBConn();
		String sql="delete from orders where id=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, oid1);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		DBUtil.dbClose();
	}

}
