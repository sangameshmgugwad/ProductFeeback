package com.target.product.feedback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.target.product.feedback.entity.ObjectionalWords;
import com.target.product.feedback.repo.ObjectionWordsRepo;

@Component
public class ObjectionWordsDataLoader implements ApplicationRunner {

    private ObjectionWordsRepo objectionWordsRepo;

    @Autowired
    public ObjectionWordsDataLoader(ObjectionWordsRepo objectionWordsRepo) {
        this.objectionWordsRepo = objectionWordsRepo;
    }

    public void run(ApplicationArguments args) {
    	
    	objectionWordsRepo.save(new ObjectionalWords("bad"));
    	objectionWordsRepo.save(new ObjectionalWords("worst"));
    }
}
