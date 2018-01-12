package com.internousdev.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.web.dao.LoginDAO;
import com.internousdev.web.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object>session;

	public String execute() {
		String ret = ERROR;
		LoginDAO dao =new LoginDAO();

		loginDTOList=dao.select(username,password);
		if(this.username.equals(loginDTOList.get(0).getUsername())
		&& this.password.equals(loginDTOList.get(0).getPassword())){
			session.put("loginDTOList", loginDTOList);

			ret = SUCCESS;

		}else{
			ret = ERROR;
		}
		return ret;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword(){
	return password;

}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<LoginDTO> getLoginDTOList(){
		return loginDTOList;
	}
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		this.loginDTOList = loginDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session =session;
	}}