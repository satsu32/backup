package com.internousdev.joker.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.ItemInfoTransactionDAO;
import com.internousdev.joker.dto.ItemInfoTransactionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;

	private List<ItemInfoTransactionDTO> itemInfoTransactionList=new ArrayList<ItemInfoTransactionDTO>();

	private Map<String,Object> session;

	public String execute(){
		System.out.println("IndexAction-----");
		String result=ERROR;


//		if(((LoginDTO) session.get("loginUser"))!=null && ((LoginDTO) session.get("loginUser")).getLoginFlg()) {
//			session.put(userName, ((LoginDTO) session.get("loginUser")).getUserName());
//		}

		ItemInfoTransactionDAO dao=new ItemInfoTransactionDAO();
		itemInfoTransactionList=dao.selectItemInfoTransactionList();

		result=SUCCESS;
		return result;
	}

	public List<ItemInfoTransactionDTO> getItemInfoTransactionList() {
		return itemInfoTransactionList;
	}

	public void setItemInfoTransactionList(List<ItemInfoTransactionDTO> itemInfoTransactionList) {
		this.itemInfoTransactionList = itemInfoTransactionList;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




}
