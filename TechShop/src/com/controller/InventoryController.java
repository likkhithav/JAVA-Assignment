package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Inventory;
import com.dto.InventoryProductDto;
import com.dto.ProductInventoryDto;
import com.service.InventoryService;

public class InventoryController {

	public static void main(String[] args) throws SQLException {
		
		InventoryService  inventoryService=new InventoryService();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("**********INVENTORY OPS************");
			System.out.println("PRESS 1 TO Get Products associated with Inventory");
			System.out.println("PRESS 2 TO Get current quantity in Stock");
			System.out.println("PRESS 3 TO Add specific quantity to Inventory");
			System.out.println("PRESS 4 TO Remove specific quantity from Inventory");
			System.out.println("PRESS 5 TO Update Stock Quantity");
			System.out.println("PRESS 6 TO Check if specific quantity is Available");
			System.out.println("PRESS 7 TO Get Total value in Inventory");
			System.out.println("PRESS 8 TO List Low Stock Products");
			System.out.println("PRESS 9 TO List Out of Stock Products");
			System.out.println("PRESS 10 TO List All details");
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
					System.out.println("***Get Products associated with Inventory***");
					List<InventoryProductDto>list=inventoryService.getProduct();
					for(InventoryProductDto m:list)
					{
						System.out.println(m);
					}
					break;
				
					
				case 2:
					System.out.println("***Get current quantity in Stock***");
					
					try
					{
						List<ProductInventoryDto> p= inventoryService.getQuantityInStock();
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
	
				
				case 3:
					System.out.println("***Add specific quantity to Inventory***");
					System.out.println("Enter Product ID: ");
					int id1=sc.nextInt();
					
					System.out.println("Enter Quantity to be added: ");
					sc.nextLine();
					int quantity1=sc.nextInt();
					
					try
					{
						inventoryService.addToInventory(id1, quantity1);
						System.out.println("Product quantity added!!!");
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					
				case 4:
					System.out.println("***Remove specific quantity from Inventory***");
					System.out.println("Enter Product ID: ");
					int id2=sc.nextInt();
					
					System.out.println("Enter Quantity to be removed: ");
					sc.nextLine();
					int quantity2=sc.nextInt();
					
					try
					{
						inventoryService.removeFromInventory(id2, quantity2);
						System.out.println("Product quantity removed!!!");
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;	
				
					
				case 5:
					System.out.println("***Update Stock Quantity***");
					System.out.println("Enter Product ID: ");
					int id3=sc.nextInt();
					
					System.out.println("Enter the Quantity to be updated: ");
					sc.nextLine();
					int quantity3=sc.nextInt();
					
					try
					{
						inventoryService.updateStockQuantity(id3, quantity3);
						System.out.println("Product Quantity Updated!!!");
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				
					
				case 6:
					System.out.println("***Check if specific quantity is Available***");
					System.out.println("Enter the Quantity to be checked: ");
					sc.nextLine();
					int quantity4=sc.nextInt();
					
					try
					{
						List<Inventory>list1=inventoryService.isProductAvailable( quantity4);
						System.out.println("Product Quantity Available!!!");
						for(Inventory m:list1)
						{
							System.out.println(m);
						}
					}
					catch(SQLException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				
					
				case 7:	
					System.out.println("***Get Total value in Inventory***");
					try
					{
						List<InventoryProductDto>list2=inventoryService.getInventoryValue();
						for(InventoryProductDto i:list2)
						{
							System.out.println(i);
						}
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
			
					
				case 8:	
					System.out.println("***List Low Stock Products***");
					try
					{
						System.out.println("Enter the Quantity to be checked: ");
						sc.nextLine();
						int quantity5=sc.nextInt();
						List<InventoryProductDto>list3=inventoryService.listLowStock(quantity5);
						for(InventoryProductDto i:list3)
						{
							System.out.println(i);
						}
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
					
					
				case 9:	
					System.out.println("***List Out of Stock Products***");
					try
					{
						List<InventoryProductDto>list4=inventoryService.listOutOfStock();
						for(InventoryProductDto i:list4)
						{
							System.out.println(i);
						}
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
					
				
				case 10:
					System.out.println("***List All details***");
					
					try
					{
						List<Inventory>list5=inventoryService.listAll();
						for(Inventory m:list5)
						{
							System.out.println("[id=" + m.getId() + ", quantityInStock=" + m.getQuantityInStock() + 
									", lastStockUpdate=" + m.getLastStockUpdate() + ", productId=" + m.getProductId()+ "]");
						}
					}
					catch(SQLException e)
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
