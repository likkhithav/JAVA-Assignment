package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDaoImpl;
import com.dto.CustomerOrderDto;
import com.model.Customer;


public class CustomerService {

	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	
	public List<CustomerOrderDto> calculateTotalOrder(int cid) throws SQLException {
		List<CustomerOrderDto>list=customerDaoImpl.calculateTotalOrder(cid);
		return list;
	}

	
	public List<Customer> getCustomerDetails() throws SQLException {
		List<Customer>list1=customerDaoImpl.getCustomerDetails();
		return list1;
	}

	
	public void updateCustomerInfo(int id, String cemail) throws SQLException {
		customerDaoImpl.updateCustomerInfo(id, cemail);
	}
	
}
