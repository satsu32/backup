package com.internousdev.joker.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.joker.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction  extends ActionSupport implements SessionAware {


	private Collection<String> checkList;


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

    /**
     * アイテム情報を格納
     */
    public Map<String, Object> session;


    public ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

    /**
     * 処理結果
     */
    private String result;

   public String execute() {
	   System.out.println(itemName);
	   System.out.println(itemImage);
	   System.out.println(itemPrice);
	   System.out.println(checkList);
	   System.out.println(stock);
	   System.out.println(pay);

	   // 商品が選択されたか？
	   if(checkList.size()<=0){
		   result = ERROR;
	   }


		   String[] itemNameList = itemName.split(",", 0);
		   for(int i=0; i < itemNameList.length;i++){
			   CartDTO cartDTO = new CartDTO();
			   cartList.add(cartDTO);
			   cartList.get(i).itemName=itemNameList[i].toString();
		   }

		   String[] itemImageList = itemImage.split(",", 0);
		   for(int i=0; i < itemImageList.length;i++){
			   cartList.get(i).itemImage=itemImageList[i].toString();
		   }

		   String[] itemPriceList = itemPrice.split(",", 0);
		   for(int i=0; i < itemPriceList.length;i++){
			   cartList.get(i).itemPrice=itemPriceList[i].toString();
		   }


	   // 選択された商品を抽出する
	   for(String check : checkList){
		   int id=Integer.parseInt(check);
		   cartList.get(id-1).check=true;
		   System.out.println(id);
	   }

	   String[] stockList = stock.split(",", 0);
	   for(int i=0; i < stockList.length;i++){
		   cartList.get(i).stock=stockList[i].toString();
	   }

	   total=0;
	   for(int i=0;i<cartList.size();i++){
		   int price=Integer.parseInt(itemPriceList[i].toString());
		   int count=Integer.parseInt(stockList[i].toString());
		   System.out.println("-----------------");
		   System.out.println(price);
		   System.out.println(count);
		   System.out.println("-----------------");
//		   cartList.get(i).subTotal= (Integer.parseInt(itemPriceList[i].toString())) * (Integer.parseInt(stockList[i].toString()));
//		   total+=cartList.get(i).subTotal;
	   }

	   for(int i=0;i<cartList.size();i++){
		   System.out.println("---チェック ["+ i + "]");
		   System.out.println(cartList.get(i).itemName);
		   System.out.println(cartList.get(i).itemImage);
		   System.out.println(cartList.get(i).itemPrice);
		   System.out.println(cartList.get(i).check);
		   System.out.println(cartList.get(i).stock);
		   System.out.println(cartList.get(i).subTotal);
		   System.out.println("----------------------");
	   }

	   System.out.println(total);


	   switch(pay){
	   case "1":
		   payment="現金払い";
		   break;
	   case "2":
		   payment="クレジットカード";
		   break;
	   case "3":
		   payment="代引き払い";
		   break;
	   default:
		   payment="";
	   }

	   result = SUCCESS;
	   return result;
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



@Override
   public void setSession(Map<String, Object> session) {
	   this.session = session;
   }
}
