package com.target.product.feedback.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ObjectionalWords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String word;
	
	
	

	public ObjectionalWords() {
	
	}

	public ObjectionalWords(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String words) {
		this.word = words;
	}

	public long getId() {
		return id;
	}
	
	
	
	

}
