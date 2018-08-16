package com.target.product.feedback.dto;

//@Getter
//@Setter
public class ProductFeedbackRequest {
	
	private long customerID;
	
	private long productID;
	
	private String text;
	
	
	

	public ProductFeedbackRequest() {
	
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	

}
