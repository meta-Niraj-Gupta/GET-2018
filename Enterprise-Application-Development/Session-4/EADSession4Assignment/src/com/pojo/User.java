package com.pojo;

import java.sql.Blob;
import java.sql.Date;

public class User{
	private Integer id;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private Date birthDate;
	private String organization;
	private String email;
	private String password;
	private Blob image;

	public User(Integer id, String firstName, String lastName, String mobileNumber, Date birthDate, 
			String organization, String email, String password, Blob image){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.birthDate = birthDate;
		this.organization = organization;
		this.email = email;
		this.password = password;
		this.image = image;
	}
	
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public Date getBirthDate(){
		return birthDate;
	}

	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
