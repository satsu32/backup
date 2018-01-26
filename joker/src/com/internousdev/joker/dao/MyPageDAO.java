package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.joker.dto.MyPageDTO;
import com.internousdev.joker.util.DBConnector;


public class MyPageDAO {

	   DBConnector db = new DBConnector();
	   Connection con = db.getConnection();



	     public ArrayList<MyPageDTO> selectUserBuyItemTransaction(String user_master_id) throws SQLException {
	  	   DBConnector db = new DBConnector();
		   Connection con = db.getConnection();
	    	 ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

	    	 String sql = "SELECT ubit.id, iit.item_name, iit.item_image, ubit.total_price,ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id =iit.id where ubit.user_master_id = ? AND ubit.delete_date IS NULL ORDER BY insert_date DESC";

	    	 try {
	    		 PreparedStatement ps = con.prepareStatement(sql);
	    		 ps.setString(1, user_master_id);

	    		 ResultSet rs = ps.executeQuery();

	    		 while(rs.next()){
	    			 MyPageDTO dto = new MyPageDTO();
	    			 dto.setId(rs.getString("id"));
	    			 dto.setItemName(rs.getString("item_name"));
	    			 dto.setItemImage(rs.getString("item_image"));
	    			 dto.setTotalPrice(rs.getString("total_price"));
	    			 dto.setTotalCount(rs.getString("total_count"));
	    			 dto.setPayment(rs.getString("pay"));
	    			 dto.setInsert_date(rs.getString("insert_date"));
//	    			 dto.setLoginUserId(resultSet.getString("loginUserId"));
//	    			 dto.setUserName(resultSet.getString("userName"));
	    			 myPageDTO.add(dto);
	    		 }


	    	 } catch(Exception e){
	    		 e.printStackTrace();
	    	 } finally{
	    		 con.close();
	    	 }
	    	 return myPageDTO;
	     }



	     public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException {
	  	   DBConnector db = new DBConnector();
		   Connection con = db.getConnection();
	    	 ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

	    	 String sql = "SELECT ubit.id, iit.item_name, ubit.total_price,ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id =iit.id where ubit.item_transaction_id =? AND ubit.user_master_id = ? AND ubit.delete_date IS NULL  ORDER BY insert_date DESC";

	    	 try {
	    		 PreparedStatement preparedStatement = con.prepareStatement(sql);
	    		 preparedStatement.setString(1, item_transaction_id);
	    		 preparedStatement.setString(2, user_master_id);

	    		 ResultSet resultSet = preparedStatement.executeQuery();

	    		 while(resultSet.next()){
	    			 MyPageDTO dto = new MyPageDTO();
	    			 dto.setId(resultSet.getString("id"));
	    			 dto.setItemName(resultSet.getString("item_name"));
	    			 dto.setTotalPrice(resultSet.getString("total_price"));
	    			 dto.setTotalCount(resultSet.getString("total_count"));
	    			 dto.setPayment(resultSet.getString("pay"));
	    			 dto.setInsert_date(resultSet.getString("insert_date"));
	    			 dto.setLoginUserId(resultSet.getString("loginUserId"));
	    			 dto.setUserName(resultSet.getString("userName"));
	    			 myPageDTO.add(dto);
	    		 }


	    	 } catch(Exception e){
	    		 e.printStackTrace();
	    	 } finally{
	    		 con.close();
	    	 }
	    	 return myPageDTO;
	     }




	     public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException {
	  	   DBConnector db = new DBConnector();
		   Connection con = db.getConnection();
	    	 String sql = "DELETE FROM user_buy_item_transaction where item_transaction_id =? AND user_master_id = ?";

	    	 PreparedStatement preparedStatement;
	    	 int result =0;
	    	 try {
	    		  preparedStatement = con.prepareStatement(sql);
	    		  preparedStatement.setString(1, item_transaction_id);
	    		  preparedStatement.setString(2, user_master_id);

	    		  result = preparedStatement.executeUpdate();
	    	 } catch (SQLException e){
	    		 e.printStackTrace();

	    	 }finally {
	    		 con.close();
	    	 }
	    	 return result;
	     }


	     public int deleteBuyItemHistory(String user_master_id) throws SQLException {
	  	   DBConnector db = new DBConnector();
		   Connection con = db.getConnection();
//	    	 String sql = "DELETE FROM user_buy_item_transaction where user_master_id = ?";
		     String sql = "update user_buy_item_transaction set delete_date = NOW() where user_master_id = ?";
	    	 PreparedStatement preparedStatement;
	    	 int result =0;
	    	 try {
	    		  preparedStatement = con.prepareStatement(sql);
	    		  preparedStatement.setString(1, user_master_id);

	    		  result = preparedStatement.executeUpdate();
	    	 } catch (SQLException e){
	    		 e.printStackTrace();

	    	 }finally {
	    		 con.close();
	    	 }
	    	 return result;
	     }


}
