package tech.csm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tech.csm.entity.College;
import tech.csm.util.DbUtil;

public class CollegeDaoImpl implements CollegeDao {

	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;

	@Override
	public List<College> getAllCollege() {

		List<College> collegeList = null;

		try {
			con = DbUtil.getMyConnection();
			ps = con.prepareStatement("select * from college where is_deleted='NO'");
			rs = ps.executeQuery();

			if (rs.next()) {
				collegeList = new ArrayList<>();
				do {
					College c = new College();
					c.setCollegeId(rs.getInt(1));
					c.setCollegeName(rs.getString(2));
					c.setAddress(rs.getString(3));
					c.setNoOfSeats(rs.getInt(4));
					collegeList.add(c);

				} while (rs.next());

			}

			rs.close();
			ps.close();

		} catch (SQLException sq) {
			sq.printStackTrace();
		}

		return collegeList;

	}

	@Override
	public College getCollegeById(Integer collegeId) {
		College c = null;
		try {
			con = DbUtil.getMyConnection();
			ps = con.prepareStatement("select * from college where college_id = ?");
			ps.setInt(1, collegeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				c = new College();
				c.setCollegeId(rs.getInt(1));
				c.setCollegeName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setNoOfSeats(rs.getInt(4));
			}
			rs.close();
			ps.close();
		} catch (SQLException sq) {
			sq.printStackTrace();
		}

		return c;
	}

	@Override
	public String addCollege(College college) {
		int rc = 0;
		int gc = 0;
		try {
			con = DbUtil.getMyConnection();

			ps = con.prepareStatement(
					"insert into college(college_name,address,no_of_seats,is_deleted) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, college.getCollegeName());
			ps.setString(2, college.getAddress());
			ps.setInt(3, college.getNoOfSeats());
			ps.setString(4, college.getIsDeleted());
			rc = ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next())
				gc = rs.getInt(1);

			rs.close();
			ps.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		if (rc == 1)
			return "1 record saved with id : " + gc;
		else
			return "record not saved!!!";

	}

	@Override
	public String removeCollege(Integer collegeId) {
		int rc = 0;
		try {
			con = DbUtil.getMyConnection();
			ps = con.prepareStatement("update college set is_deleted='YES' where college_id=?");
			ps.setInt(1, collegeId);
			rc = ps.executeUpdate();

			ps.close();

		} catch (SQLException sq) {
			sq.printStackTrace();
		}
		if (rc == 1)
			return "College deleted with id " + collegeId;
		else
			return "College not deleted successfully";
	}

}
