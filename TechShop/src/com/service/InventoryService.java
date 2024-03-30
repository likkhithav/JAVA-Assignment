package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDaoImpl;
import com.dto.InventoryProductDto;
import com.dto.ProductInventoryDto;
import com.model.Inventory;


public class InventoryService {

	InventoryDaoImpl inventoryDaoImpl=new InventoryDaoImpl();
	
	
	public List<InventoryProductDto> getProduct() throws SQLException {
		List<InventoryProductDto>list=inventoryDaoImpl.getProduct();
		return list;
	}
	

	public List<ProductInventoryDto> getQuantityInStock() throws SQLException{
		List<ProductInventoryDto>list1=inventoryDaoImpl.getQuantityInStock();
		return list1;
	}
	

	public void addToInventory(int id1, int quantity1) {
		inventoryDaoImpl.addToInventory(id1, quantity1);
	}

	
	public void removeFromInventory(int id2, int quantity2) {
		inventoryDaoImpl.removeFromInventory(id2, quantity2);
	}

	
	public void updateStockQuantity(int id3, int quantity3) {
		inventoryDaoImpl.updateStockQuantity(id3, quantity3);
	}

	
	public List<Inventory> isProductAvailable(int quantity4) throws SQLException {
		List<Inventory>list5=inventoryDaoImpl.isProductAvailable(quantity4);
		return list5;
	}

	
	public List<InventoryProductDto> getInventoryValue() throws SQLException {
		List<InventoryProductDto>list6=inventoryDaoImpl.getInventoryValue();
		return list6;
	}

	
	public List<InventoryProductDto> listLowStock(int quantity5) throws SQLException {
		List<InventoryProductDto>list7=inventoryDaoImpl.listLowStock(quantity5);
		return list7;
	}

	public List<InventoryProductDto> listOutOfStock() throws SQLException {
		List<InventoryProductDto>list8=inventoryDaoImpl.listOutOfStock();
		return list8;
	}

	
	public List<Inventory> listAll() throws SQLException {
		List<Inventory>list=inventoryDaoImpl.listAll();
		return list;
	}
	
}
