package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.joker.dto.BuyItemDTO;
import com.internousdev.joker.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private List<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();


	public BuyItemDTO getBuyItemInfo() {
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		String sql= "SELECT id, item_name, item_image, item_price FROM item_info_transaction";

		try{
			  PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

		String sql= "SELECT id, item_name, item_image, item_price FROM item_info_transaction";

		try{
			  PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

}
