package com.internousdev.joker.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;

	/**
	 * ユーザー情報登録処理
	 */
	public String execute() throws SQLException {
		String result=ERROR;

		UserCreateCompleteDAO dao = new UserCreateCompleteDAO();
		int count = dao.cerateUser(loginUserId,loginPassword,userName);

		if(count>0){
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
