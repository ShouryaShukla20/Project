package com.cg.inh.entities;

import javax.persistence.Entity;

@Entity
public class Manager extends EmployeeNew
{
	private double dailyAllow;
	private double rating;
	
	public double getDailyAllow() {
		return dailyAllow;
	}
	public void setDailyAllow(double dailyAllow) {
		this.dailyAllow = dailyAllow;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
