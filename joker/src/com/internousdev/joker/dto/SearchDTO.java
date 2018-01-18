package com.internousdev.joker.dto;

public class SearchDTO {

	private String itemName;

	private String searchTerm;

	public SearchDTO(){

	}

	public String itemName(){
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSearchTerm(){
		return searchTerm;
    }
	public void setSearchTerm(String searchTerm){
		this.searchTerm = searchTerm;
	}



}
