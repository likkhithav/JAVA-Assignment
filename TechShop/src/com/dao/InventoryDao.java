package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.InventoryProductDto;
import com.dto.ProductInventoryDto;
import com.model.Inventory;

public interface InventoryDao {

	public List<InventoryProductDto> getProduct() throws SQLException ;	

	public List<ProductInventoryDto> getQuantityInStock() throws SQLException;

	public void addToInventory(int id1, int quantity1) throws SQLException;

	public void removeFromInventory(int id2, int quantity2) throws SQLException;
	
	public void updateStockQuantity(int id3, int quantity3) throws SQLException;
	
	public List<Inventory> isProductAvailable(int quantity4) throws SQLException ;
	
	public List<InventoryProductDto> getInventoryValue() throws SQLException ;
	
	public List<InventoryProductDto> listLowStock(int quantity5) throws SQLException ;

	public List<InventoryProductDto> listOutOfStock() throws SQLException ;

	public List<Inventory> listAll() throws SQLException;
	
}
