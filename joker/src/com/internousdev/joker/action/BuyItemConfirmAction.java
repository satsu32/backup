package com.internousdev.joker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.BuyItemDAO;
import com.internousdev.joker.dto.LoginDTO;
import com.internousdev.joker.dto.UserBuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String id;
	private String itemName;
	private String itemImage;
	private String itemPrice;
	private String stock;
	private String payment;
	private Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		System.out.println("BuyItemConfirmAction------");
		System.out.println("LOGIN_USER_ID:"+loginUserId);
		System.out.println(id);
		System.out.println(itemName);
		System.out.println(itemImage);
		System.out.println(itemPrice);
		System.out.println(stock);
		System.out.println(payment);
		System.out.println("--------------------------");

		String[] itemTransactionIdList = id.split(", ", 0);
		String[] itemNameList = itemName.split(", ", 0);
		String[] itemImageList = itemImage.split(", ", 0);
		String[] itemPriceList = itemPrice.split(", ", 0);
		String[] stockList = stock.split(", ", 0);

		for (int i = 0; i < itemTransactionIdList.length; i++) {
			UserBuyItemDTO dto = new UserBuyItemDTO();
			dto.setItemTransactionId(itemTransactionIdList[i].toString());
			dto.setItemName(itemNameList[i].toString());
			dto.setItemImage(itemImageList[i].toString());
			dto.setItemPrice(itemPriceList[i].toString());

			System.out.println("---");
			int price=Integer.parseInt(String.valueOf(itemPriceList[i]));
			System.out.println("PRICE:"+price);
			int count=Integer.parseInt(String.valueOf(stockList[i]));
			System.out.println("COUNT:"+count);
			int total=price*count;
			System.out.println("TOTAL:"+total);
			System.out.println("---");

			dto.setTotalPrice(String.valueOf(total));
			dto.setTotalCount(String.valueOf(count));

			LoginDTO loginUser = (LoginDTO)session.get("loginUser");
			if(loginUserId != null){
				dto.setUserMasterId(loginUserId);
			}
			if(loginUser.getLoginId()!=null){
				dto.setUserMasterId(loginUser.getLoginId());
			}

			dto.setPay(payment);

			BuyItemDAO dao = new BuyItemDAO();
			int insertedCount = dao.insertUserBuyItemTransaction(dto);
			if(insertedCount>0){
				result=SUCCESS;
			}else{
				result=ERROR;
			}
		}
		return result;
	}


	public String getLoginUserId() {
		return loginUserId;
	}


	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
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
