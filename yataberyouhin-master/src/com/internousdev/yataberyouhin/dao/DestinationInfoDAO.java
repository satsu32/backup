package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.yataberyouhin.dto.DestinationInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class DestinationInfoDAO {
	public DBConnector db = new DBConnector();
	public Connection con = null;

	/**
	 * 宛先情報をDBに登録する
	 * @param destinationInfoDTO
	 * @return
	 * @throws SQLException
	 */
	public boolean registerDestination(DestinationInfoDTO destinationInfoDTO) throws SQLException {

		int updateCount = 0;
		boolean result = false;
		String sql = "INSERT INTO destination_info(user_id, "
				+ "family_name, "
				+ "first_name, "
				+ "family_name_kana, "
				+ "first_name_kana, "
				+ "email, "
				+ "tel_number, "
				+ "user_address, "
				+ "insert_date) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, destinationInfoDTO.getUserId());
			ps.setString(2, destinationInfoDTO.getFamilyName());
			ps.setString(3, destinationInfoDTO.getFirstName());
			ps.setString(4, destinationInfoDTO.getFamilyNameKana());
			ps.setString(5, destinationInfoDTO.getFirstNameKana());
			ps.setString(6, destinationInfoDTO.getEmail());
			ps.setString(7, destinationInfoDTO.getTelNumber());
			ps.setString(8, destinationInfoDTO.getUserAddress());
			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		if (updateCount == 1) {
			result = true;

		}

		return result;
	}

	/**
	 * 指定したユーザーの宛先情報取得
	 * @param userId
	 * @throws SQLException
	 */
	public ArrayList<DestinationInfoDTO> obtainingDestinationInfo(String userId) throws SQLException {
		ArrayList<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email FROM destination_info WHERE user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTOList.add(destinationInfoDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return destinationInfoDTOList;
	}

}