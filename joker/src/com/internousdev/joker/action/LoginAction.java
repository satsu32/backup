package com.internousdev.joker.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.BuyItemDAO;
import com.internousdev.joker.dao.LoginDAO;
import com.internousdev.joker.dto.BuyItemDTO;
import com.internousdev.joker.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインID
	 */
	private String loginUserId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * 商品リスト
	 */
	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	/**
	 * 実行メソッド
	 */
	public String execute() {
		 // 処理結果を格納
		String result = ERROR;
		 // ログイン情報取得DAO
		LoginDAO loginDAO = new LoginDAO();
		 // ログイン情報格納IDTO
		LoginDTO loginDTO = new LoginDTO();
		//ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);
		session.put("userName", loginDTO.getUserName());
		session.put("loginFlg", loginDTO.getLoginFlg());

		 // アイテム情報を取得
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		//ログイン情報を取得
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			buyItemList = buyItemDAO.getBuyItemList();
			result = SUCCESS;

			//アイテム情報を取得
//			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			session.put("login_user_id",  loginDTO.getLoginId());
//			session.put("id",buyItemDTO.getId());
//			session.put("buyItem_name",buyItemDTO.getItemName());
//			session.put("buyItem_price",buyItemDTO.getItemPrice());
		}
//		System.out.println("LOGINACTION:"+result);
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



	public List<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
