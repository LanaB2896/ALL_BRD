package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calculator {
	private int id;
private float outstandingPrinciple;
private float interest;
private float loanAmount;
private float EMI;

@Id @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getOutstandingPrinciple() {
	return outstandingPrinciple;
}
public void setOutstandingPrinciple(float outstandingPrinciple) {
	this.outstandingPrinciple = outstandingPrinciple;
}
public float getInterest() {
	return interest;
}
public void setInterest(float interest) {
	this.interest = interest;
}
public float getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(float loanAmount) {
	this.loanAmount = loanAmount;
}
public float getEMI() {
	return EMI;
}
public void setEMI(float eMI) {
	EMI = eMI;
}



}
