package com.internousdev.joker.action;

import java.util.ArrayList;

import com.internousdev.joker.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemDetailAction extends ActionSupport{

	private String loginUserName;
	private String loginPassword;

	private String id;
	private String itemName;
	private String itemImage;
	private String itemPrice;
	private String insertDate;
	private String updateDate;

	private String stock;

	private boolean buySingleFlg;

	/**
	 * 合計金額
	 */
	private int total;

	private String search;
	private String errorMessage;

	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	public String execute(){
		buySingleFlg=true;
		String result=ERROR;
		System.out.println("BuyItemDetailAction--------");
		System.out.println("ID:"+id);
		System.out.println("ITEMNAME:"+itemName);
		System.out.println("ITEMIMAGE:"+itemImage);
		System.out.println("ITEMPRICE"+itemPrice);
		System.out.println("INSERTDATE:"+insertDate);
//		System.out.println("checkList:"+checkList);
		System.out.println("stock :"+stock);
//		System.out.println("pay :"+pay);
		System.out.println("search :"+search);
		System.out.println("errorMessage :"+errorMessage);
		System.out.println("USERNAME : " + loginUserName);
		System.out.println("PASSWORD : " + loginPassword);
		System.out.println("---------------------------");


		CartDTO dto = new CartDTO();
		dto.setId(id);
		dto.setItemName(itemName);
		dto.setItemImage(itemImage);
		dto.setItemPrice(itemPrice);
		dto.setStock(stock);
		dto.setCheck(true);
		cartList.add(dto);


		total = 0;
//		for (int i = 0; i < cartList.size(); i++) {
//			int count = Integer.parseInt(stock);
//			System.out.println("-----------------");
//			System.out.println(itemPrice);
//			System.out.println(count);
//			System.out.println("-----------------");
//		}
		System.out.println("カートリストのサイズ:"+cartList.size());
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println("---チェック [" + i + "]");
			System.out.println(cartList.get(i).id);
			System.out.println(cartList.get(i).itemName);
			System.out.println(cartList.get(i).itemImage);
			System.out.println(cartList.get(i).itemPrice);
			System.out.println(cartList.get(i).check);
			System.out.println(cartList.get(i).stock);
			System.out.println(cartList.get(i).subTotal);
			System.out.println("----------------------");
		}

		System.out.println(total);

//		switch (pay) {
//		case "1":
//			payment = "現金払い";
//			break;
//		case "2":
//			payment = "クレジットカード";
//			break;
//		case "3":
//			payment = "代引き払い";
//			break;
//		default:
//			payment = "";
//		}


		result=SUCCESS;
		return result;

	}



	public String getLoginUserName() {
		return loginUserName;
	}



	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}



	public String getLoginPassword() {
		return loginPassword;
	}



	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}



	public boolean isBuySingleFlg() {
		return buySingleFlg;
	}



	public void setBuySingleFlg(boolean buySingleFlg) {
		this.buySingleFlg = buySingleFlg;
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

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}




	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

//	public String getPay() {
//		return pay;
//	}
//
//	public void setPay(String pay) {
//		this.pay = pay;
//	}
//
//	public String getPayment() {
//		return payment;
//	}
//
//	public void setPayment(String payment) {
//		this.payment = payment;
//	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
	}



}
