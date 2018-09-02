package com.pojo;

public class Advertisement{
	private Integer id;
	private String AdvetismentTitle;
	private String AdvertismentDescription;
	private Integer categoryId;

	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getAdvetismentTitle() {
		return AdvetismentTitle;
	}

	public void setAdvetismentTitle(String advetismentTitle) {
		AdvetismentTitle = advetismentTitle;
	}

	public String getAdvertismentDescription() {
		return AdvertismentDescription;
	}

	public void setAdvertismentDescription(String advertismentDescription) {
		AdvertismentDescription = advertismentDescription;
	}

	public Integer getCategoryId(){
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}
}
