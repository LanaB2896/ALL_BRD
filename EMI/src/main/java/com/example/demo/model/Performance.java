package com.example.demo.model;

//
import javax.persistence.Id;

public class Performance {
	private float principle;
	private float rateofinterest;
	private float tenure;
	private float noOfInstallenment;

	public float getPrinciple() {
		return principle;
	}

	public void setPrinciple(float principle) {
		this.principle = principle;
	}

	public float getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(float rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public float getTenure() {
		return tenure;
	}

	public void setTenure(float tenure) {
		this.tenure = tenure;
	}
	@Id
	public float getNoOfInstallenment() {
		return noOfInstallenment;
	}

	public void setNoOfInstallenment(float noOfInstallenment) {
		this.noOfInstallenment = noOfInstallenment;
	}

}



