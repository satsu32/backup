package com.internousdev.joker.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.MyPageDAO;
import com.internousdev.joker.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * マイページ情報取得DAO
	 */
	private MyPageDAO myPageDAO = new MyPageDAO();

	/**
	 * マイページ情報格納DTO
	 */
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;
	private String message;
	private String id;
	private String loginUserId;
	private String loginPassword;

	public String execute() throws SQLException {
		String result=ERROR;
		String user_master_id = null;
		System.out.println("MyPageAction-------");

		if(loginUserId !=null){

			String[] userId = loginUserId.split(",",0);

			loginUserId=String.valueOf(userId[0]);

//		String []loginUserIdList  = loginUserId.split(", ",0);
//		System.out.println("USERID   : " + loginUserIdList[0].toString());
		System.out.println("USERID   : " + loginUserId);

		}


		if(loginPassword != null){

			String[] password = loginPassword.split(", ",0);

			loginPassword=String.valueOf(password[0]);

		System.out.println("PASSWORD : " + loginPassword);
		System.out.println("---------------------------");

		}else{
			System.out.println("未ログインの状態");
		}




		// if(!session.containsKey("id")){
		// return ERROR;
		// }

		// System.out.println(id);
		System.out.println("LOGINUSERID : " + loginUserId);
		System.out.println("DELETEFLG : " + deleteFlg);
		// 商品履歴を削除しない場合
		if (deleteFlg == null) {
			// String item_transaction_id = id;
			user_master_id = loginUserId;
			System.out.println("USERMASTERID --->>> 登録完了");
			// myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,
			// user_master_id);
			myPageList = myPageDAO.selectUserBuyItemTransaction(user_master_id);
			Iterator<MyPageDTO> iterator = myPageList.iterator();
			if (!(iterator.hasNext())) {
				myPageList = null;
			}

			result = SUCCESS;

			// 商品履歴を削除する場合
		} else if (deleteFlg.equals("1")) {
			System.out.println(user_master_id + "の商品履歴を削除します。");
			boolean b = this.delete();
			if(b){
				deleteFlg=null;
				result=SUCCESS;
			}else{
				result=ERROR;
			}
		}

		return result;
	}

	public boolean delete() throws SQLException {
		boolean result=false;
		// String item_transaction_id = id;
		String user_master_id = loginUserId;

		// int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,
		// user_master_id);
		int res = myPageDAO.deleteBuyItemHistory(user_master_id);

		if (res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
			result=true;
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました。");
			result=false;
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}



	public ArrayList<MyPageDTO> getMyPageList() {
		return myPageList;
	}

	public void setMyPageList(ArrayList<MyPageDTO> myPageList) {
		this.myPageList = myPageList;
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

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}