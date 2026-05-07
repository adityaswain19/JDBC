package tech.csm.over;

public class Employee {

	private String name;
	private int age;
	private String address;
	
	public Employee(){
		name="Unknown";
		age=18;
		address="Not availabe";
		
	}
	public void setEmpInfo(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	
	public void setEmpInfo(String name,int age,String address) {
		this.name=name;
		this.age=age;
		this.address=address;
		
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
