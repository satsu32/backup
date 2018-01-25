package com.internousdev.joker.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	public String execute() {
		System.out.println("HomeAction---");
		return SUCCESS;
	}

}
