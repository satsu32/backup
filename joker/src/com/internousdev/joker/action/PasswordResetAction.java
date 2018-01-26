package com.internousdev.joker.action;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetAction extends ActionSupport {

    private String	loginUserId;
    private String  loginPassword;
	private String passwordConfirm;

	public String execute(){

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



	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	}
