package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.ProductInventoryDto;
import com.model.Product;
import com.service.ProductService;


public class ProductController {

	public static void main(String[] args) throws SQLException {
		
		ProductService  productService=new ProductService();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("**********PRODUCT OPS************");
			System.out.println("PRESS 1 TO Get Product details");
			System.out.println("PRESS 2 TO Update Product Price by ID");
			System.out.println("PRESS 3 TO Check if product is in stock");
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
					System.out.println("***Get Product details***");
					
					
					try
					{
						List<Product>list=productService.getProductDetails();
						for(Product m:list)
						{
							System.out.println("[id=" + m.getId() + ", name=" + m.getName() + ", price=" + m.getPrice()+ "]");
						}
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				
				
				case 2:
					System.out.println("***Update Product Price by ID***");
					System.out.println("Enter Product ID: ");
					int pid=sc.nextInt();
					
					System.out.println("Enter the price to be updated: ");
					sc.nextLine();
					Double pprice=sc.nextDouble();
					try
					{
						productService.updateProductInfo(pid, pprice);
						System.out.println("Product Info Updated!!!");
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
				
				case 3:
					System.out.println("***Check if product is in stock***");
					System.out.println("Enter the Product ID: ");
					int id1=sc.nextInt();
					
					try
					{
						List<ProductInventoryDto> p= productService.isProductInStock(id1);
						System.out.println(p);
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
					
					
				default:
					System.out.println("Invalid Input!!!");
					break;
			}
		} 
		sc.close();
	}
}
