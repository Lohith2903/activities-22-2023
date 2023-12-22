package com.npci.LoanApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credit_score")
public class Credit_Score {
	
	@Id
	private String pan;
	
	private double score;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Credit_Score(String pan, double score) {
		super();
		this.pan = pan;
		this.score = score;
	}

	public Credit_Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
