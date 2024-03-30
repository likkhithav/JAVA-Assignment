package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.InventoryProductDto;
import com.dto.ProductInventoryDto;
import com.model.Inventory;
import com.util.DBUtil;

public class InventoryDaoImpl {

	public List<InventoryProductDto> getProduct() throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		List<InventoryProductDto>list=new ArrayList<>();
		
		String sql="select p.id, p.name, p.price, i.product_id, i.quantity_in_stock, i.last_stock_update "
				+ "from product p JOIN inventory i "
				+ "ON p.id=i.product_id";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			Double price=rst.getDouble("price");
			int productId=rst.getInt("product_id");
			int quantity= rst.getInt("quantity_in_stock");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			InventoryProductDto iv=new InventoryProductDto();
			iv.setId(id);
			iv.setName(name);
			iv.setPrice(price);
			iv.setProductId(productId);
			iv.setQuantityInStock(quantity);
			iv.setLastStockUpdate(stockDate);
			list.add(iv);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public List<ProductInventoryDto> getQuantityInStock() throws SQLException{

		Connection conn = DBUtil.getDBConn();
		List <ProductInventoryDto> list=new ArrayList<>();
		
		String sql="select p.id, p.name, i.quantity_in_stock "
				+ "from product p JOIN inventory i "
				+ "ON p.id=i.product_id "
				+ "where i.quantity_in_stock>0 ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			int stock=rst.getInt("quantity_in_stock");
			ProductInventoryDto i = new ProductInventoryDto(id,name,stock);
			list.add(i);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public void addToInventory(int id1, int quantity1) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		String sql="update inventory SET quantity_in_stock=quantity_in_stock+? where id=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, quantity1);
		pstmt.setInt(2, id1);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	
	public void removeFromInventory(int id2, int quantity2) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		String sql="update inventory SET quantity_in_stock=quantity_in_stock-? where id=?";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, quantity2);
		pstmt.setInt(2, id2);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}
	

	public void updateStockQuantity(int id3, int quantity3) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		String sql="update inventory SET quantity_in_stock=? where id=?";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, quantity3);
		pstmt.setInt(2, id3);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	
	public List<Inventory> isProductAvailable(int quantity4) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		List<Inventory>list=new ArrayList<>();
		
		String sql="select * from inventory i "
				+ "where i.quantity_in_stock >= ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, quantity4);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			int productId=rst.getInt("product_id");
			int quantity= rst.getInt("quantity_in_stock");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			Inventory iv=new Inventory();
			iv.setId(id);
			iv.setProductId(productId);
			iv.setQuantityInStock(quantity);
			iv.setLastStockUpdate(stockDate);
			list.add(iv);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public List<InventoryProductDto> getInventoryValue() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<InventoryProductDto>list=new ArrayList<>();
		
		String sql="select i.id, i.product_id, p.name, p.price , i.quantity_in_stock, i.last_stock_update, (p.price * i.quantity_in_stock) as total_value "
				+ "from inventory i, product p "
				+ "where p.id=i.product_id";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			int pid=rst.getInt("product_id");
			int quantity= rst.getInt("quantity_in_stock");
			double price=rst.getDouble("price");
			double tot=rst.getDouble("total_value");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			System.out.println("InventoryProductDto [id=" + id + ", quantityInStock=" + quantity + ", lastStockUpdate="
				+ stockDate + ", productId=" + pid + ", name=" + name + ", price=" + price + ", totalInventoryValue= " + tot+ "]\n");
		}
		DBUtil.dbClose();
		return list;
	}

	
	public List<InventoryProductDto> listLowStock(int quantity5) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		List<InventoryProductDto>list=new ArrayList<>();
		
		String sql="select * from inventory i, product p "
				+ "where p.id=i.product_id "
				+ "AND i.quantity_in_stock <= ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,quantity5);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			Double price=rst.getDouble("price");
			int productId=rst.getInt("id");
			int quantity= rst.getInt("quantity_in_stock");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			InventoryProductDto iv=new InventoryProductDto();
			iv.setId(id);
			iv.setName(name);
			iv.setPrice(price);
			iv.setProductId(productId);
			iv.setQuantityInStock(quantity);
			iv.setLastStockUpdate(stockDate);
			list.add(iv);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public List<InventoryProductDto> listOutOfStock() throws SQLException {

		Connection conn = DBUtil.getDBConn();
		List<InventoryProductDto>list=new ArrayList<>();
		
		String sql="select * from inventory i, product p "
				+ "where p.id=i.product_id "
				+" and i.quantity_in_stock = 0 ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			Double price=rst.getDouble("price");
			int productId=rst.getInt("product_id");
			int quantity= rst.getInt("quantity_in_stock");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			InventoryProductDto iv=new InventoryProductDto();
			iv.setId(id);
			iv.setName(name);
			iv.setPrice(price);
			iv.setProductId(productId);
			iv.setQuantityInStock(quantity);
			iv.setLastStockUpdate(stockDate);
			list.add(iv);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public List<Inventory> listAll() throws SQLException {

		Connection conn = DBUtil.getDBConn();
		List<Inventory>list=new ArrayList<>();
		
		String sql="select * from inventory";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			int productId=rst.getInt("product_id");
			int quantity= rst.getInt("quantity_in_stock");
			LocalDate stockDate=rst.getDate("last_stock_update").toLocalDate();
			
			Inventory i=new Inventory();
			i.setId(id);
			i.setProductId(productId);
			i.setQuantityInStock(quantity);
			i.setLastStockUpdate(stockDate);
			list.add(i);
		}
		DBUtil.dbClose();
		return list;
	}

}
