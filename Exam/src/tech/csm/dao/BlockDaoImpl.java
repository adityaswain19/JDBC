package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.*;
import tech.csm.util.DbUtil;


public class BlockDaoImpl implements BlockDao {


	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;


	@Override
	public String addBlock(Block block) {
		
	

			int rc=0;
			try {
				con = DbUtil.getMyConnection();

				ps = con.prepareStatement("insert into block_master (block_id,block_name,bdo_name,state_id) values(?,?,?,?)");
				
				ps.setString(1, block.getBlockId());
				ps.setString(2, block.getBlockName());
				ps.setString(3, block.getBDOName());
				ps.setInt(4, block.getState().getStateId());
				
				

				rc = ps.executeUpdate();
				
				ps.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			if(rc==1)
				return  "1 block added";
			else
				return "block not added!!";
			
		
		}


	@Override
	public List<Block> getAllBlock() {

		List<Block> l=null;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select b.block_id,b.block_name,b.bdo_name, s.state_id,s.state_name from block_master b join state_master s using (state_id)");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				l=new ArrayList<>();
				
				do {
					Block b=new Block();
					b.setBlockId(rs.getString(1));
					b.setBlockName(rs.getString(2));
					b.setBDOName(rs.getString(3));
				    
					State s=new State();
					
					s.setStateId(rs.getInt(4));
					s.setStateName(rs.getString(5));
					
					b.setState(s);
					l.add(b);
					
				}while(rs.next());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return l;
	}


	@Override
	public Block getBlockById(String id) {

		Block block=null;
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("select b.block_id,b.block_name,b.bdo_name, s.state_id,s.state_name from block_master b join state_master s using (state_id) where block_id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
					block=new Block();
					block.setBlockId(rs.getString(1));
					block.setBlockName(rs.getString(2));
					block.setBDOName(rs.getString(3));
					
                    State s=new State();
					
					s.setStateId(rs.getInt(4));
					s.setStateName(rs.getString(5));
					
					block.setState(s);
					
					
					
					
				}
			}
		
		catch (SQLException e) {

			e.printStackTrace();
		}

		
		return block;
	
	}


	@Override
	public String updateBlock(String b,String id) {
		int rc=0;
		
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("update block_master set bdo_name=? where block_id=?");
			ps.setString(1, b);
			ps.setString(2, id);
			
			rc=ps.executeUpdate();
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		if(rc==1) {
			return "Updated successfully";
			
		}
		else {
			return "Unsuccesfull";
		}
	}


	@Override
	public List<Block> displayBlock() {
		
				List<Block> l=null;
		
		try {
			
		
		con=DbUtil.getMyConnection();
		ps=con.prepareStatement("select b.block_id,b.block_name,b.bdo_name,s.state_name from block_master b join state_master s using (state_id) ");
		rs=ps.executeQuery();
		
		if(rs.next()) {
			l=new ArrayList<>();
			do {
				
			
            Block b=new Block();
            b.setBlockId(rs.getString(1));
			b.setBlockName(rs.getString(2));
			b.setBDOName(rs.getNString(3));
			
			State s=new State();
			s.setStateName(rs.getString(4));	

			b.setState(s);
			l.add(b);
			
		}while(rs.next());
		}
		ps.close();
		rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}


	@Override
	public String deleteBlock(String id) {


		int rc=0;
		try {
			con=DbUtil.getMyConnection();
			ps=con.prepareStatement("Delete from block_master where block_id=?");
			ps.setString(1, id);
			rc=ps.executeUpdate();
			
			
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		if(rc==1) {
			return "Block got deleted";
			
		}
		else {
			return "Block not deleted";
		}
	
		
	}

		

}
