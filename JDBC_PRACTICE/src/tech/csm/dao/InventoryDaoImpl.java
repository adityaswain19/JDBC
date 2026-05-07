package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.Inventory;
import tech.csm.entity.Orders;
import tech.csm.util.DbUtil;

public class InventoryDaoImpl implements InventoryDao {

	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	
	@Override
	public List<Inventory> getAllProduct() {
		
       List<Inventory> inventoryList=null;
		
		try {
			con = DbUtil.getMyConnection();

			ps = con.prepareStatement("select * from inventory");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				inventoryList=new ArrayList<>();
				
				do {
					Inventory in=new Inventory();
					in.setProductId(rs.getInt(1));
					in.setProductName(rs.getString(2));
					in.setStockQuantity(rs.getInt(3));
					in.setUnitPrice(rs.getDouble(4));
					in.setGstPrice(rs.getDouble(5));
					inventoryList.add(in);
				}
				while(rs.next());
			}
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	
	return inventoryList;
	}

	@Override
	public Inventory getOrderById(int id) {

		Inventory in=null;
		try {
			con = DbUtil.getMyConnection();

			ps = con.prepareStatement("select * from inventory where product_id= ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
            if(rs.next()) {
				
				in=new Inventory();
		
					in.setProductId(rs.getInt(1));
					in.setProductName(rs.getString(2));
					in.setStockQuantity(rs.getInt(3));
					in.setUnitPrice(rs.getDouble(4));
					in.setGstPrice(rs.getDouble(5));
		
					
				}
            rs.close();
			ps.close();

			}
			
			catch (SQLException e) {

				e.printStackTrace();
			}
		
		return in;
	}

}
