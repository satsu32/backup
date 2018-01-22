package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.yataberyouhin.dto.MCategoryDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class MCategoryDAO {
	public ArrayList<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

	/**
	 * カテゴリー情報を引き出す
	 * @return
	 */
	public ArrayList<MCategoryDTO> selectAll() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM m_category";


		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(rs.getInt("id"));
				mCategoryDTO.setCategoryId(rs.getInt("category_id"));
				mCategoryDTO.setCategoryName(rs.getString("category_name"));
				mCategoryDTO.setCategoryDescription(rs.getString("category_description"));
				mCategoryDTO.setInsertDate(rs.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(rs.getDate("update_date"));
				mCategoryDTOList.add(mCategoryDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();

		}
		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}

		return mCategoryDTOList;
	}

}
