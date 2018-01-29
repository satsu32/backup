package com.internousdev.joker.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.BuyItemDAO;
import com.internousdev.joker.dao.ItemInfoTransactionDAO;
import com.internousdev.joker.dto.BuyItemDTO;
import com.internousdev.joker.dto.ItemInfoTransactionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport implements SessionAware{

	private String id;
	private String itemName;
	private String itemImage;
	private String itemPrice;

	/**
	 * アイテム購入個数
	 */
	private String stock;

	/**
	 * 支払い方法
	 */
	private String pay;

	/**
	 * 支払い方法（文字列）
	 */
	private String payment;



	private List<ItemInfoTransactionDTO> itemInfoTransactionList=new ArrayList<ItemInfoTransactionDTO>();


	/**
	 * 商品リスト
	 */
	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	private Map<String,Object> session;

	public String execute(){
		System.out.println("ItemAction-----");
		String result=ERROR;

		ItemInfoTransactionDAO dao=new ItemInfoTransactionDAO();
		itemInfoTransactionList=dao.selectItemInfoTransactionList();


		 // アイテム情報を取得
		BuyItemDAO buyItemDAO = new BuyItemDAO();
		//ログイン情報を取得
//		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			buyItemList = buyItemDAO.getBuyItemList();


		result=SUCCESS;
		return result;
	}

	public List<ItemInfoTransactionDTO> getItemInfoTransactionList() {
		return itemInfoTransactionList;
	}

	public void setItemInfoTransactionList(List<ItemInfoTransactionDTO> itemInfoTransactionList) {
		this.itemInfoTransactionList = itemInfoTransactionList;
	}



	public List<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}






}
