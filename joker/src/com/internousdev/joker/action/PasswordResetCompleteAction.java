
package com.internousdev.joker.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.UserInfoDAO;
import com.internousdev.joker.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordResetCompleteAction extends ActionSupport implements SessionAware {

    private String	loginUserId;

    private String  loginPassword;


	private String passwordConfirm;


	private Map<String,Object> session;
	private List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();




	public String execute() {

		String result = ERROR;
		if(loginPassword.equals(passwordConfirm)) {
			UserInfoDAO dao = new UserInfoDAO();
			int count = dao.update(loginPassword, loginUserId);

			if(count > 0) {
				result = SUCCESS;
			}
			userInfoDTOList = dao.select(loginPassword, loginUserId);
			session.put("userInfoList", userInfoDTOList);
		}

		result=SUCCESS;


		return result;

	}


	public List<UserInfoDTO> getUserInfoDTOList() {
		return userInfoDTOList;
	}



	public void setUserInfoDTOList(List<UserInfoDTO> userInfoDTOList) {
		this.userInfoDTOList = userInfoDTOList;
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



