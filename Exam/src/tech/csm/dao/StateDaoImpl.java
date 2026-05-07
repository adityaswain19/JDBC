package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.State;
import tech.csm.util.DbUtil;

public class StateDaoImpl implements StateDao {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;



	@Override
	public List<State> getAllState() {
		List<State> l=null;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from state_master");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				l=new ArrayList<>();
				
				do {
					State state=new State();
					state.setStateId(rs.getInt(1));
					state.setStateName(rs.getString(2));
					l.add(state);
					
				}
				while(rs.next());
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return l;
	}



	@Override
	public State getStateByName(String name) {
		State state=null;
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select * from state_master where state_name=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
					state=new State();
					state.setStateId(rs.getInt(1));
					state.setStateName(rs.getString(2));
					
				}
			}
		
		catch (SQLException e) {

			e.printStackTrace();
		}

		
		return state;
	}
	
	

}
