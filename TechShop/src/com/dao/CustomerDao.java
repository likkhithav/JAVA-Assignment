package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerOrderDto;
import com.model.Customer;

public interface CustomerDao {
	
	public List<CustomerOrderDto> calculateTotalOrder(int cid) throws SQLException;
	
	public List<Customer> getCustomerDetails() throws SQLException;
	
	public void updateCustomerInfo(int id, String cemail) throws SQLException;
	
}
