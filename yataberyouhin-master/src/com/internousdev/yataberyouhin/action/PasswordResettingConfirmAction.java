package com.internousdev.yataberyouhin.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yataberyouhin.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordResettingConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants {
	private String userId;
	private String password;
	private String passwordConfirm;
	private Map<String,Object> session;
	private ArrayList<String> erroMessageList = new ArrayList<>();


	public String execute() {
		String result = ERROR;
		boolean inputChk = true;
		if(userId.equals("")) {
			erroMessageList.add("ユーザーIDを入力してください。");
			inputChk = false;
		}

		if(password.equals("")) {
			erroMessageList.add("パスワードを入力してください。");
			inputChk = false;
		} else if (password.length() < 1 || password.length() > 16) {
			erroMessageList.add("パスワードは1文字以上16文字以下で入力してください");
			inputChk = false;
		}

		if(passwordConfirm.equals("")) {
			erroMessageList.add("再確認パスワードを入力してください。");
			inputChk = false;
		} else if (passwordConfirm.length() < 1 || passwordConfirm.length() > 16) {
			erroMessageList.add("再確認パスワードは1文字以上16文字以下で入力してください");
			inputChk = false;
		}

		if(!password.equals(passwordConfirm)) {
			erroMessageList.add("パスワードと再確認パスワードが一致しません。");
		}


		if(inputChk && password.equals(passwordConfirm)) {
		session.put("userId", userId);
		session.put("password", password);
		session.put("passwordConfirm", passwordConfirm);
		result = SUCCESS;
		}

		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public ArrayList<String> getErrorMessageList() {
		return erroMessageList;
	}

	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.erroMessageList = errorMessageList;
	}

}
