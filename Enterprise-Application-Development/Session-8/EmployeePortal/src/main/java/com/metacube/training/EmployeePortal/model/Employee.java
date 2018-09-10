package com.metacube.training.EmployeePortal.model;

import java.sql.Date;

public class Employee {
	private Integer empCode;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String primaryContact;
	private String secondaryContact;
	private String emailId;
	private String skypeId;
	private String profilePicture;
	private String password;
	private Integer isActive = 1;

	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer isActive() {
		return isActive;
	}

	public void setActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", gender="
				+ gender + ", primaryContact=" + primaryContact
				+ ", secondaryContact=" + secondaryContact + ", emailId="
				+ emailId + ", skypeId=" + skypeId + ", profilePicture="
				+ profilePicture + ", password=" + password + ", isActive="
				+ isActive + "]";
	}
}