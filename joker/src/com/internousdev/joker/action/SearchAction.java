package com.internousdev.joker.action;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	public String execute(){
		System.out.println("SearchAction----");
		return SUCCESS;
	}

}
