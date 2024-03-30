package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ProductInventoryDto;
import com.model.Product;
import com.util.DBUtil;

public class ProductDaoImpl {

	public List<Product> getProductDetails() throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		List<Product>list=new ArrayList<>();
		String sql="select * from product ";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			int id=rst.getInt("id");
			String name=rst.getString("name");
			Double price=rst.getDouble("price");
			
			Product p=new Product();
			p.setId(id);
			p.setName(name);
			p.setPrice(price);
			list.add(p);
		}
		DBUtil.dbClose();
		return list;
	}

	
	public void updateProductInfo(int pid, Double pprice) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		String sql="update product SET price=? where id=? ";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setDouble(1, pprice);
		pstmt.setInt(2, pid);	
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	
	public List <ProductInventoryDto> isProductInStock(int id1) throws SQLException {
		
		Connection conn = DBUtil.getDBConn();
		List <ProductInventoryDto> list=new ArrayList<>();
		
		String sql="select p.id, p.name, i.quantity_in_stock "
				+ "from product p JOIN inventory i "
				+ "ON p.id=i.product_id "
				+ "where i.quantity_in_stock>0 "
				+ "and p.id=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id1);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next())
		{
			String name=rst.getString("name");
			int stock=rst.getInt("quantity_in_stock");
			ProductInventoryDto i = new ProductInventoryDto(id1,name,stock);
			list.add(i);
		}
		
		DBUtil.dbClose();
		return list;
	}

}
