package tech.csm.bankapp.domain;

public class Address {
	
	private int houseNo;
	private String lane;
	private String city;
	public Address(int houseNo, String lane, String city) {
		super();
		this.houseNo = houseNo;
		this.lane = lane;
		this.city = city;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", lane=" + lane + ", city=" + city + "]";
	}
	
	

}
