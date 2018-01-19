package com.internousdev.joker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public  Map<String,Object> session;
	private String errorMessage;

	/**
	 * 入力情報格納処理
	 */
	public String execute(){
		String result=ERROR;
//		System.out.println("UserCreateConfirmAction-----------");
//		System.out.println(loginUserId);
//		System.out.println(loginPassword);
//		System.out.println(userName);
//		System.out.println("----------------------------------");



		if(!(loginUserId.equals("")) &&!(loginPassword.equals("")) &&!(userName.equals(""))){
			UserCreateConfirmDAO dao=new UserCreateConfirmDAO();
			boolean isExistsLoginUserId = dao.isExistsLoginUserId(loginUserId);
			if(isExistsLoginUserId){
				setErrorMessage("既に登録されたユーザーです");
				result=ERROR;
			}else{
				session.put("loginUserId", loginUserId);
				session.put("loginPassword",loginPassword);
				session.put("userName",userName);
				result = SUCCESS;
			}
		} else {

			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
