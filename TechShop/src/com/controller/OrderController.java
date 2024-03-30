package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Orders;
import com.service.OrderService;


public class OrderController {

	public static void main(String[] args) {
		
		OrderService  orderService=new OrderService();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("**********ORDER OPS************");
			System.out.println("PRESS 1 TO Calculate total amount of order");
			System.out.println("PRESS 2 TO Get order details");
			System.out.println("PRESS 3 TO Update order status");
			System.out.println("PRESS 4 TO Cancel order");
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
					System.out.println("***Calculate total amount of order***");
					
					try
					{
						orderService.calculateTotalAmount();
						
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					catch(NullPointerException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					
				case 2:
					System.out.println("***Get order details***");
					List<Orders>list=orderService.getOrderDetails();
					for(Orders m:list)
					{
						System.out.println(m);
					}
					break;
				
				
				case 3:
					System.out.println("***Update order status***");
					System.out.println("Enter order ID to be updated: ");
					int id=sc.nextInt();
					
					System.out.println("Enter the status to be update 1.Processing  2.Shipped");
					int choice=sc.nextInt();
					
					String ostatus = null;
					if(choice == 1)
			        	ostatus= "processing";
					else if (choice == 2)
						ostatus = "shipped";
					else
						System.out.println("Invalid choice");
					
					orderService.updateOrderStatus(id, ostatus);
					System.out.println("Customer Info Updated!!!");
					break;
					
					
				case 4:
					System.out.println("***Cancel order***");
					System.out.println("Enter the order ID to be canceled: ");
					int oid1=sc.nextInt();
					orderService.cancelOrder(oid1);
					System.out.println("###Deleted###");
					break;
					
					
				default:
					System.out.println("Invalid Input!!!");
					break;
			}
		} 
		sc.close();
	}

}
