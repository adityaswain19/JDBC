package tech.csm.entity;

import java.util.Date;

public class Orders {

	private Integer orderId;
	private Inventory inventory;
	private Integer orderQuantity;
	private Date orderDate;
	private Double totalBillAmount;
	
	public Integer getOrderId() {
		return orderId;
	}
	
	
	
	public Inventory getInventory() {
		return inventory;
	}



	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}



	public Integer getOrderQuantity() {
		return orderQuantity;
	}



	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public Double getTotalBillAmount() {
		return totalBillAmount;
	}



	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", productId=" + inventory + ", orderQuantity=" + orderQuantity
				+ ", orderDate=" + orderDate + ", totalBillAmount=" + totalBillAmount + "]";
	}
	
	
	
}
