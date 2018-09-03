package com.pojo;

import java.util.List;

public class CategoryAndAdvertisment{
	private Integer categoryId;
	private String categoryName;
	private List<Advetisment> advertisments;

	public Integer getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public List<Advetisment> getAdvList(){
		return advertisments;
	}

	public void setAdvList(List<Advetisment> advertisments){
		this.advertisments = advertisments;
	}
}
