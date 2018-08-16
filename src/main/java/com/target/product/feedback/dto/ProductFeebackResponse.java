package com.target.product.feedback.dto;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductFeebackResponse implements IFeedbackReponse {
	

	private String feedbackReponse;
	
	

	

	public ProductFeebackResponse() {
		
	}

	public String getFeedbackReponse() {
		return feedbackReponse;
	}

	public void setFeedbackReponse(String feedbackReponse) {
		this.feedbackReponse = feedbackReponse;
	}

	
	
	

}
