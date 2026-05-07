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


public class OrderDaoImpl implements OrderDao {

	private Connection con=null;
	private PreparedStatement ps1=null,ps2=null,ps=null;
	private ResultSet rs=null;
	
	
	@Override
	public String addOrder(Orders myOrder) {

		int rc=0;
		
		try {
			con = DbUtil.getMyConnection();
			ps1=con.prepareStatement("insert into orders (product_id,order_quantity,order_date,total_bill_amount) values(?,?,?,?)");
			ps2=con.prepareStatement("Update inventory set stock_quantity=stock_quantity-? where product_id=?");
			ps1.setInt(1,myOrder.getInventory().getProductId());
            ps1.setInt(2,myOrder.getOrderQuantity());
            ps1.setDate(3, new java.sql.Date(myOrder.getOrderDate().getTime()));
            ps1.setDouble(4,myOrder.getTotalBillAmount());
            rc=ps1.executeUpdate();
            
            ps2.setInt(1, myOrder.getOrderQuantity());
            ps2.setInt(2,myOrder.getInventory().getProductId());
            ps2.executeUpdate();
            ps1.close();
            ps2.close();            
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rc==1)
			return  " Item orderd successfully";
		else
			return "Order cannt place!!";
	}

	@Override
	public List<Orders> getAllOrders() {
		
		List<Orders> orderList=null;
		try {
		con = DbUtil.getMyConnection();

		ps = con.prepareStatement("select * from  orders");
		rs = ps.executeQuery();
		
		if(rs.next()) {
			
			orderList=new ArrayList<>();
			
			do {
				Orders od=new Orders();
				od.setOrderId(rs.getInt("order_id"));
				
				od.setOrderQuantity(rs.getInt("order_quantity"));
				od.setOrderDate(rs.getDate("order_date"));
				od.setTotalBillAmount(rs.getDouble("total_bill_amount"));
				int id=rs.getInt("product_id");
				Inventory inv=new InventoryDaoImpl().getOrderById(id);

				od.setInventory(inv);
		        orderList.add(od);
			}
			while(rs.next());
		}
		rs.close();
		ps.close();
		
	
		}catch (SQLException e) {
System.out.println(e);
		}
		return orderList;

	}

	@Override
	public Orders getOrderById(int id) {
		
		Orders od=null;
		try {
			con = DbUtil.getMyConnection();

			ps = con.prepareStatement("select * from orders where product_id= ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			ps2=con.prepareStatement("update inventory set stock_quantity=stock_quantity+? where product_id=?");
          
			
            if(rs.next()) {
				
				od=new Orders();
		
					od.setOrderQuantity(rs.getInt(3));
					
				}
            rs.close();
			ps.close();

			}
			
			catch (SQLException e) {

				e.printStackTrace();
			}
		
		
		return null;
	}


}
