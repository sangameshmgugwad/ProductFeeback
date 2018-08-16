package com.target.product.feedback.service;

import java.util.List;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.product.feedback.dto.ProductFeedbackRequest;
import com.target.product.feedback.entity.CommentStatus;
import com.target.product.feedback.entity.Comments;
import com.target.product.feedback.entity.ObjectionalWords;
import com.target.product.feedback.repo.CommentsRepo;
import com.target.product.feedback.repo.ObjectionWordsRepo;

@Service
public class CommentsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommentsService.class);

	@Autowired
	private ObjectionWordsRepo objectionWordsRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	
	
	
	
	public CommentsService(ObjectionWordsRepo objectionWordsRepo) {
		this.objectionWordsRepo = objectionWordsRepo;
	}


	/**
	 * Check and Save the Comments for future reference/analytics 
	 * @param productFeedback
	 * @return String with objectionalwords or blank String
	 */
	
	public String checkProductFeedbackAndSave(ProductFeedbackRequest productFeedback){
		
		Comments comments = new Comments();
		comments.setCustomer(productFeedback.getCustomerID());
		comments.setProduct(productFeedback.getProductID());
		comments.setText(productFeedback.getText());
		
		StringJoiner objectionalWords = checkProductFeedback(productFeedback.getText());
		
		if(objectionalWords.length() > 1 ){
			comments.setCommentStatus(CommentStatus.REJECTED);
		}else{
			comments.setCommentStatus(CommentStatus.APPROVED);
		}
		commentsRepo.save(comments);
		
		return objectionalWords.toString();
		
	}

	
	/**
	 * Check product feedback and send objectional words if any for review
	 * @param feedback
	 * @return
	 */
	public StringJoiner checkProductFeedback(String feedback) {
		
		StringJoiner objectionalWords = new StringJoiner(",");
		
		if(feedback != null && feedback.isEmpty()){
			return objectionalWords;
		}

		

		List<ObjectionalWords> objectionWordsList = objectionWordsRepo.findAll();

		LOG.info("Object List Size : "+objectionWordsList.size());
		
		for (int i = 0; i < objectionWordsList.size(); i++) {
			if (feedback.toLowerCase().contains(objectionWordsList.get(i).getWord().toLowerCase())) {
				objectionalWords.add(objectionWordsList.get(i).getWord());

			}
		}

		return objectionalWords;

	}

}
