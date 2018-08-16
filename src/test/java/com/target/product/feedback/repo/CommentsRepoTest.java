package com.target.product.feedback.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.product.feedback.entity.CommentStatus;
import com.target.product.feedback.entity.Comments;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentsRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentsRepo commentsRepo;

    @Test
    public void testFindByName() {
    	
    	Comments testComment = new Comments();
    	testComment.setCustomer(34543);
    	testComment.setProduct(32423);
    	testComment.setText("Good product");
    	testComment.setCommentStatus(CommentStatus.APPROVED);
        entityManager.persist(testComment);

        List<Comments> comments = commentsRepo.findAll();
        assertEquals(1, comments.size());
    }
}