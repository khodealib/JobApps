package com.example.item;

public class Item_CategoryMain {

	
	private String CategoryName;
	private int CategoryId; 
	private String ImageUrl; 
	
	
	
	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryname) {
		this.CategoryName = categoryname;
	}
	
	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryid) {
		this.CategoryId = categoryid;
	}
	public String getImageurl()
	{
		return ImageUrl;
		
	}
	
	public void setImageurl(String imageurl)
	{
		this.ImageUrl=imageurl;
	}
	

}
