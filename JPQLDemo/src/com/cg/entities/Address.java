package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address
{
	@Id
	private int addressId;
	private String streetName;
	private String city;
	private String zipcode;
	
	@OneToOne(mappedBy="address")
	private Student student;
	
	public Student getStudent()
	{
		return student;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return  addressId + ", " + streetName + ", " + city + ", " + zipcode;
	}
	
	
}
