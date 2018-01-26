
package com.internousdev.joker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetConfirmAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String passwordConfirm;
	private Map<String,Object> session;


	public String execute() {
		String result = ERROR;
		System.out.println("PasswordResetConfirmAction----------");
		System.out.println("loginUserId");
		System.out.println("loginPassword");
		System.out.println("passwordConfirm");
		System.out.println("-------------------------------------");

		boolean inputChk = true;
		if(loginUserId.equals("")) {
			inputChk = false;

		}

		if(loginPassword.equals("")) {
			inputChk = false;
		} else if (loginPassword.length() < 1 || loginPassword.length() > 16) {
			inputChk = false;
		}

		if(passwordConfirm.equals("")) {
			inputChk = false;
		} else if (passwordConfirm.length() < 1 || passwordConfirm.length() > 16) {
			inputChk = false;
		}

		if(!loginPassword.equals(passwordConfirm)) {
		}


		if(inputChk && loginPassword.equals(passwordConfirm)) {
		result = SUCCESS;
		}
       System.out.println(result);
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


