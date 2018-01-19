package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.joker.dto.BuyItemDTO;
import com.internousdev.joker.dto.UserBuyItemDTO;
import com.internousdev.joker.util.DBConnector;

public class BuyItemDAO {


	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();


	public BuyItemDTO getBuyItemInfo() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		BuyItemDTO buyItemDTO = new BuyItemDTO();
		String sql= "SELECT id, item_name, item_image, item_price FROM item_info_transaction";

		try{
			  PreparedStatement preparedStatement = con.prepareStatement(sql);
			  ResultSet resultSet = preparedStatement.executeQuery();

			  if(resultSet.next()) {
				  buyItemDTO.setId(resultSet.getInt("id"));
				  buyItemDTO.setItemName(resultSet.getString("item_name"));
				  buyItemDTO.setItemImage(resultSet.getString("item_image"));
				  buyItemDTO.setItemPrice(resultSet.getString("item_price"));

			  }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}

	public List<BuyItemDTO> getBuyItemList() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql= "SELECT id, item_name, item_image, item_price FROM item_info_transaction";

		try{
			  PreparedStatement preparedStatement = con.prepareStatement(sql);
			  ResultSet resultSet = preparedStatement.executeQuery();

			  while(resultSet.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemImage(resultSet.getString("item_image"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemList.add(buyItemDTO);

			  }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemList;
	}

	public int insertUserBuyItemTransaction(UserBuyItemDTO dto) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into user_buy_item_transaction("
				+ "item_transaction_id,"
				+ "total_price,"
				+ "total_count,"
				+ "user_master_id,"
				+ "pay,"
				+ "insert_date"
				+ ") "
				+ "values(?,?,?,?,?,NOW())";
		int count = 0;
		try {
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, dto.getItemTransactionId());
			ps.setString(2, dto.getTotalPrice());
			ps.setString(3, dto.getTotalCount());
			ps.setString(4, dto.getUserMasterId());
			ps.setString(5, dto.getPay());
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
