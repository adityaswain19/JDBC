package tech.csm.entity;

public class Inventory {

	private Integer productId;
	private String productName;
	private Integer stockQuantity;
	private Double unitPrice;
	private Double gstPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getGstPrice() {
		return gstPrice;
	}
	public void setGstPrice(Double gstPrice) {
		this.gstPrice = gstPrice;
	}
	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", productName=" + productName + ", stockQuantity=" + stockQuantity
				+ ", unitPrice=" + unitPrice + ", gstPrice=" + gstPrice + "]";
	}
	
	
	
	
}
