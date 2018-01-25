package com.internousdev.joker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetAction extends ActionSupport implements SessionAware {

    private String	loginUserId;

    private String  loginPassword;
//	private String password;

	private String passwordConfirm;

//	private String

	private Map<String,Object> session;


	public String execute(){
		String result=ERROR;

		boolean inputChk = true;
		if(loginUserId.equals("")){
			inputChk = false;
		}

		if(loginPassword.equals("")){
			inputChk =  fale;
		} else if(loginPassword.length())


		return result;






		result=SUCCESS;
		return result;

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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
