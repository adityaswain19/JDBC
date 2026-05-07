package tech.csm.entity;

import java.io.Serializable;

public class College implements Serializable {
	
	private Integer collegeId;
	private String collegeName;
	private String address;
	private Integer noOfSeats;
	private String isDeleted;
	
	
	public Integer getCollegeId() {
		return collegeId;
	}
	
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", address=" + address
				+ ", noOfSeats=" + noOfSeats + "]";
	}

	
	

}
