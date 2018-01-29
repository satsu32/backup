package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.joker.dto.ItemInfoTransactionDTO;
import com.internousdev.joker.util.DBConnector;

public class ItemInfoTransactionDAO {

	List<ItemInfoTransactionDTO> itemInfoTransactionList=new ArrayList<ItemInfoTransactionDTO>();

	public List<ItemInfoTransactionDTO> selectItemInfoTransactionList() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql= "select * from item_info_transaction";

		try{
			  PreparedStatement preparedStatement = con.prepareStatement(sql);
			  ResultSet rs = preparedStatement.executeQuery();

			  while(rs.next()) {
				  ItemInfoTransactionDTO dto = new ItemInfoTransactionDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemImage(rs.getString("item_image"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdateDate(rs.getString("update_date"));

//				System.out.println("ItemInfoTransactionDAO----");
//				System.out.println(dto.getId());
//				System.out.println(dto.getItemName());
//				System.out.println(dto.getItemImage());
//				System.out.println(dto.getItemPrice());
//				System.out.println(dto.getItemStock());
//				System.out.println(dto.getInsertDate());
//				System.out.println(dto.getUpdateDate());
//				System.out.println("-------------------------");
				itemInfoTransactionList.add(dto);
			  }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return itemInfoTransactionList;
	}

}
