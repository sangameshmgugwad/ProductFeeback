package com.target.product.feedback.service;

import static org.junit.Assert.assertEquals;

import java.util.StringJoiner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.product.feedback.entity.ObjectionalWords;
import com.target.product.feedback.repo.ObjectionWordsRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentServiceTest {
	
	
	private CommentsService commentsService;
	
	@Autowired
    private ObjectionWordsRepo ojectionWordsRepo;
	
	@Before
    public void setUp() {
		ojectionWordsRepo.save(new ObjectionalWords("bad"));
		ojectionWordsRepo.save(new ObjectionalWords("worst"));
		commentsService = new CommentsService(ojectionWordsRepo);
    }
	
	 @Test
	    public void whenGoodFeedback_returnNoObjectionWords() {
	    	
		 String feedback = "this product is very good";
		 
		 StringJoiner objectionalWords = commentsService.checkProductFeedback(feedback);
		 
		 assertEquals(0, objectionalWords.length());

	    }
	 
	 @Test
	    public void whenBadFeedback_returnObjectionWords() {
	    	
		 String feedback = "this product is very bad and worst";
		 
		 StringJoiner objectionalWords = commentsService.checkProductFeedback(feedback);
		 
		 assertEquals(true,  (objectionalWords.length() > 0) );

	    }

}
