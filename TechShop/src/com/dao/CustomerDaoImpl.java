package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CustomerOrderDto;
import com.model.Customer;
import com.util.DBUtil;

public class CustomerDaoImpl {

	public List<CustomerOrderDto> calculateTotalOrder(int cid) throws SQLException 
	{
		
		Connection conn = DBUtil.getDBConn();
		List <CustomerOrderDto> list=new ArrayList<>();
		
		String sql="select c.id, c.first_name, count(o.id) as totalOrder "
				+ "from customer c JOIN orders o "
				+ "ON c.id=o.customer_id "
				+ "where c.id=? "
				+ "group by c.id; ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int customerId=rst.getInt("id");
			String firstName=rst.getString("first_name");
			int total=rst.getInt("totalOrder");
			CustomerOrderDto c = new CustomerOrderDto(customerId,firstName,total);
			list.add(c);
		}
		DBUtil.dbClose();
		return list;
		
	}

	
	public List<Customer> getCustomerDetails() throws SQLException 
	{
		
		Connection conn = DBUtil.getDBConn();
		List<Customer>list=new ArrayList<>();
		
		String sql="select * from customer";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String firstName=rst.getString("first_name");
			String lastName=rst.getString("last_name");
			String email=rst.getString("email");
			String address=rst.getString("address");
			
			Customer c=new Customer();
			c.setId(id);
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setEmail(email);
			c.setAddress(address);
			list.add(c);
		}
			DBUtil.dbClose();
			return list;	
	}

	
	public void updateCustomerInfo(int id, String cemail) throws SQLException 
	{
		Connection conn = DBUtil.getDBConn();
		String sql="update customer SET email=? where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, cemail);
		pstmt.setInt(2, id);	
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

}
