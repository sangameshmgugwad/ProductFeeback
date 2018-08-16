package com.target.product.feedback.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.product.feedback.entity.ObjectionalWords;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectionalWordsRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ObjectionWordsRepo ojectionWordsRepo;

    @Test
    public void testFindByName() {
        entityManager.persist(new ObjectionalWords("bad"));

        List<ObjectionalWords> objectionWords = ojectionWordsRepo.findAll();
        assertEquals(1, objectionWords.size());
    }
}