package com.internousdev.joker.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction  extends ActionSupport {


	private String loginUserId;
	private String loginPassword;
	/**
	 * ユーザー情報登録画面遷移処理
	 */
	public String execute() {
//		System.out.println(loginUserId);
//		System.out.println(loginPassword);


		return SUCCESS;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}



}
