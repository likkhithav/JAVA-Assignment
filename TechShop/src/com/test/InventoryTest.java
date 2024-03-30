package com.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dto.InventoryProductDto;
import com.dto.ProductInventoryDto;
import com.model.Inventory;
import com.service.InventoryService;

public class InventoryTest {

	InventoryService  inventoryService=new InventoryService();
	
	@Test
	public void getProduct() throws SQLException
	{
		try 
		{
			List<InventoryProductDto>list=inventoryService.getProduct();
			Assert.assertNotNull(list);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void getQuantityInStock() throws SQLException
	{
		try 
		{
			List<ProductInventoryDto> p= inventoryService.getQuantityInStock();
			Assert.assertNotNull(p);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void addToInventory() throws SQLException
	{
		//use case 1
		int id1=2;
		int quantity1= 7;
		try 
		{
			inventoryService.addToInventory(id1, quantity1);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id1=18;
		quantity1= 4;
		try 
		{
			inventoryService.addToInventory(id1, quantity1);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void removeFromInventory() throws SQLException
	{
		//use case 1
		int id2 = 1;
		int quantity2 = 3;
		try 
		{
			inventoryService.removeFromInventory(id2, quantity2);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id2 = 18;
		quantity2 = 5;
		try 
		{
			inventoryService.removeFromInventory(id2, quantity2);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void updateStockQuantity() throws SQLException
	{
		//use case 1
		int id3 = 1;
		int quantity3 = 4;
		try 
		{
			inventoryService.updateStockQuantity(id3, quantity3);
		} 
		catch (SQLException e)
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
		
		//use case 2
		id3 = 16;
		quantity3 = 6;
		try 
		{
			inventoryService.updateStockQuantity(id3, quantity3);
		} 
		catch (SQLException e) 
		{
			Assert.assertEquals("Invalid id".toLowerCase(), e.getMessage());
		}
	}
	
	
	@Test
	public void isProductAvailable() throws SQLException
	{
		//use case 1
		int quantity4 = 5;
		try 
		{
			List<Inventory>list1=inventoryService.isProductAvailable( quantity4);
			Assert.assertNotNull(list1);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
		
		//use case 2
		quantity4 = 15;
		try 
		{
			List<Inventory>list1=inventoryService.isProductAvailable( quantity4);
			Assert.assertNotNull(list1);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void getInventoryValue() throws SQLException
	{
		try 
		{
			List<InventoryProductDto>list2=inventoryService.getInventoryValue();
			Assert.assertNotNull(list2);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void listLowStock() throws SQLException
	{
		//use case 1
		int quantity5 =10;
		try 
		{
			List<InventoryProductDto>list3=inventoryService.listLowStock(quantity5);
			Assert.assertNotNull(list3);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
		
		//use case 2
		quantity5 =18;
		try 
		{
			List<InventoryProductDto>list3=inventoryService.listLowStock(quantity5);
			Assert.assertNotNull(list3);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void listOutOfStock() throws SQLException
	{
		try 
		{
			List<InventoryProductDto>list4=inventoryService.listOutOfStock();
			Assert.assertNotNull(list4);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
	
	@Test
	public void listAll() throws SQLException
	{
		try 
		{
			List<Inventory>list5=inventoryService.listAll();
			Assert.assertNotNull(list5);
		}
		catch(SQLException e)
		{
			Assert.assertEquals("Not valid".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
}
