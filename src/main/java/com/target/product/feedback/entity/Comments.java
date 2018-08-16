/**
 * 
 */
package com.target.product.feedback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sangamesh
 *
 */

@Entity
//@Getter
//@Setter
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private long product;
	
	@Column
	private long customer;
	
	@Column
	private String text;
	
	@Column
	private CommentStatus status;

	public long getId() {
		return id;
	}

	
	public long getProduct() {
		return product;
	}

	public void setProduct(long product) {
		this.product = product;
	}

	public long getCustomer() {
		return customer;
	}

	public void setCustomer(long customer) {
		this.customer = customer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public CommentStatus getStatus() {
		return status;
	}


	public void setCommentStatus(CommentStatus status) {
		this.status = status;
	}	
	
	
	

}
