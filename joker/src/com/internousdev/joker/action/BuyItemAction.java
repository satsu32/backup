package com.internousdev.joker.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dao.BuyItemDAO;
import com.internousdev.joker.dto.BuyItemDTO;
import com.internousdev.joker.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	private Collection<String> checkList;

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

	/**
	 * 合計金額
	 */
	private int total;

	private String errorMessage;

	/**
	 * アイテム情報を格納
	 */
	public Map<String, Object> session;

	private List<BuyItemDTO> buyItemList;

	private ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

	private String loginUserId;

	private String search;

	private boolean buySingleFlg;

	public String execute() {

		// 処理結果
		String result = ERROR;
		System.out.println("BuyItemAction----------");
		System.out.println("LOGIN_USER_ID:"+loginUserId);

		System.out.println(id);
		System.out.println(itemName);
		System.out.println(itemImage);
		System.out.println(itemPrice);
		System.out.println(checkList);
		System.out.println(stock);
		System.out.println(pay);
		System.out.println("-------------------------");

		if(checkList==null || buySingleFlg == false){
			errorMessage="商品が何も選択されていません。\n";
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			buyItemList = buyItemDAO.getBuyItemList();
			return ERROR;

		}

		// 商品が選択されたか？
		if (checkList.size() <= 0 || buySingleFlg == false) {
			result = ERROR;
		}






		String[] itemTransactionIdList = id.split(", ", 0);
		String[] itemNameList = itemName.split(", ", 0);
		String[] itemImageList = itemImage.split(", ", 0);
		String[] itemPriceList = itemPrice.split(", ", 0);
		String[] stockList = stock.split(", ", 0);

		for (int i = 0; i < itemTransactionIdList.length; i++) {
			CartDTO dto = new CartDTO();
			dto.setId(itemTransactionIdList[i].toString());
			dto.setItemName(itemNameList[i].toString());
			dto.setItemImage(itemImageList[i].toString());
			dto.setItemPrice(itemPriceList[i].toString());
			dto.setCheck(false);
			dto.setStock(stockList[i].toString());


			// 選択された商品を抽出する
			for (String check : checkList) {
				int itemId = Integer.parseInt(check);

				if(i==(itemId-1)){
					dto.setCheck(true);
					cartList.add(dto);
				}
//				cartList.get(itemId - 1).check = true;
//				System.out.println(itemId);
			}

		}
//
//		for (int i = 0; i < itemNameList.length; i++) {
//			CartDTO dto = new CartDTO();
//			cartList.add(dto);
//			cartList.get(i).itemName = itemNameList[i].toString();
//		}
//
//		for (int i = 0; i < itemImageList.length; i++) {
//			cartList.get(i).itemImage = itemImageList[i].toString();
//		}
//
//		for (int i = 0; i < itemPriceList.length; i++) {
//			cartList.get(i).itemPrice = itemPriceList[i].toString();
//		}
//
//
//
//		for (int i = 0; i < stockList.length; i++) {
//			cartList.get(i).stock = stockList[i].toString();
//		}

		total = 0;
		for (int i = 0; i < cartList.size(); i++) {
			int price = Integer.parseInt(itemPriceList[i].toString());
			int count = Integer.parseInt(stockList[i].toString());
			System.out.println("-----------------");
			System.out.println(price);
			System.out.println(count);
			System.out.println("-----------------");
			// cartList.get(i).subTotal=
			// (Integer.parseInt(itemPriceList[i].toString())) *
			// (Integer.parseInt(stockList[i].toString()));
			// total+=cartList.get(i).subTotal;
		}

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

		switch (pay) {
		case "1":
			payment = "現金払い";
			break;
		case "2":
			payment = "クレジットカード";
			break;
		case "3":
			payment = "代引き払い";
			break;
		default:
			payment = "";
		}

		result = SUCCESS;
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

	public ArrayList<CartDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartList = cartList;
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

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Map<String, Object> getSession() {
		return session;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public String getSearch() {
		return search;
	}



	public void setSearch(String search) {
		this.search = search;
	}



	public boolean isBuySingleFlg() {
		return buySingleFlg;
	}



	public void setBuySingleFlg(boolean buySingleFlg) {
		this.buySingleFlg = buySingleFlg;
	}



}
