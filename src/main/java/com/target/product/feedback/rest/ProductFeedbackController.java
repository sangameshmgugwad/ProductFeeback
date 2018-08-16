package com.target.product.feedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.product.feedback.dto.IFeedbackReponse;
import com.target.product.feedback.dto.ProductFeebackResponse;
import com.target.product.feedback.dto.ProductFeedbackRequest;
import com.target.product.feedback.service.CommentsService;

@RestController
@RequestMapping("/")
public class ProductFeedbackController {

	@Autowired
	private CommentsService commentService;

	@RequestMapping(value = "/submitProductFeedback", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<IFeedbackReponse> submitProductFeedback(
			@RequestBody ProductFeedbackRequest productFeedbackRequest) {

		ProductFeebackResponse response = new ProductFeebackResponse();

		if (productFeedbackRequest.getText() != null || productFeedbackRequest.getText().isEmpty()) {
			response.setFeedbackReponse("Sorry, you have entered  your feedback, please re-enter");
			return new ResponseEntity<IFeedbackReponse>(response, HttpStatus.BAD_REQUEST);
		}

		String objectionalWords = commentService.checkProductFeedbackAndSave(productFeedbackRequest);

		if (objectionalWords.isEmpty()) {
			response.setFeedbackReponse("Thanks for the feedback, You feeback will be posted soon !!!");
		} else {
			response.setFeedbackReponse(
					"Feedback has Objectional Comments like '" + objectionalWords + "' please review again");
		}

		return new ResponseEntity<IFeedbackReponse>(response, HttpStatus.OK);

	}

}
