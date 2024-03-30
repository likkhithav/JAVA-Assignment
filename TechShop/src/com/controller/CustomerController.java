package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.CustomerOrderDto;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		
		CustomerService  customerService=new CustomerService();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("**********CUSTOMER OPS************");
			System.out.println("PRESS 1 TO Calculate total orders by customer ID");
			System.out.println("PRESS 2 TO Get customer details");
			System.out.println("PRESS 3 TO Update Customer Email");
			System.out.println("PRESS 0 TO Exit");
			System.out.println("**********************");
			int input=sc.nextInt();
			
			if(input==0)
			{
				System.out.println("Exiting....Thank you!!!");
				break;
			}
			switch(input)
			{		
		
				case 1:
					System.out.println("***Calculate total orders***");
					System.out.println("Enter the Customer ID: ");
					sc.nextLine();
					int cid=sc.nextInt();
			
					try 
					{
							List<CustomerOrderDto> list = customerService.calculateTotalOrder(cid);
							for(CustomerOrderDto c:list)
							{
								System.out.println(c);
							}
							break;
					} 
					catch (SQLException e) 
					{
							e.printStackTrace();
					}
					break;
					
					
				case 2:
					System.out.println("***Get customer details***");
					List<Customer>list1=customerService.getCustomerDetails();
					
					for(Customer m:list1)
					{
						System.out.println("[id=" + m.getId() + ", firstName=" + m.getFirstName() + ", lastName=" + m.getLastName()+ 
								", email=" + m.getEmail()+ ", phone=" + m.getPhone() + ", address=" + m.getAddress()+ "]");
					}
					break;
				
				
				case 3:
					System.out.println("***Update Customer email***");
					System.out.println("Enter Id: ");
					int id = sc.nextInt();
	
					System.out.println("Enter Email to be updated: ");
					sc.nextLine();
					String cemail = sc.nextLine();
					
					customerService.updateCustomerInfo(id, cemail);
					System.out.println("Customer Info Updated!!!");
					break;
					
					
				default:
					System.out.println("Invalid Input!!!");
					break;
			}
		} 
		sc.close();
	}

}
