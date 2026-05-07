package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import tech.csm.entity.Admission;
import tech.csm.util.DbUtil;

public class AdmissionDaoImpl implements AdmissionDao {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs=null;

	@Override
	public String newAdmission(List<Admission> admissionList) {
		
		int rc = 0;
		int[] batchRes=null;
		int[] batchRes1=null;
		try {
			con = DbUtil.getMyConnection();
			con.setAutoCommit(false);
			PreparedStatement ps1 = con.prepareStatement(
					"insert into admission(candidate_name, date_of_admission, college_id) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			PreparedStatement ps2 = con.prepareStatement("update college set no_of_seats = no_of_seats - 1 where college_id=?");
			for (Admission admission : admissionList) {				
				
				ps1.setString(1, admission.getCandidateName());

				ps1.setDate(2, new java.sql.Date(admission.getAdmissionDate().getTime()));
				ps1.setInt(3, admission.getCollege().getCollegeId());
				ps1.addBatch();
				
				
				
				ps2.setInt(1, admission.getCollege().getCollegeId());				
				ps2.addBatch();
				
				
			}
			batchRes=ps1.executeBatch();
			batchRes1 = ps2.executeBatch();
			
			
			rs=ps1.getGeneratedKeys();
			while(rs.next())
				System.out.println(rs.getInt(1));
			
			ps1.close();
			ps2.close();
			con.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("/////////**   "+Arrays.toString(batchRes)+"&&&&"+Arrays.toString(batchRes1));
//		if (rc == 1)
//			return "1 admission saved";
//		else
//			return "Admission not successful!!";
		
		return "All admission done!!";

	}

}
