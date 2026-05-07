package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tech.csm.util.DbUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void showEmp() {
		
		Connection con=null;		
		ResultSet rs=null;
		PreparedStatement ps=null;
		Double sal=10000.00;
		String jobId="SA_MAN";
		con=DbUtil.getMyConnection();
		try {
			
			
			ps=con.prepareStatement("select * from college");					
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"  "+rs.getInt(4));
			}
			rs.close();
			ps.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
