package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.yataberyouhin.dto.UserInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class UserInfoDAO {
	public DBConnector db = new DBConnector();
	public Connection con = null;

	/**
	 * ユーザー情報を新規登録する
	 * @param userInfoDTO
	 * @return result
	 * @throws SQLException
	 */
	public boolean registerUser(UserInfoDTO userInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, insert_date) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getUserId());
			ps.setString(2, userInfoDTO.getPassword());
			ps.setString(3, userInfoDTO.getFamilyName());
			ps.setString(4, userInfoDTO.getFirstName());
			ps.setString(5, userInfoDTO.getFamilyNameKana());
			ps.setString(6, userInfoDTO.getFirstNameKana());
			ps.setBoolean(7, userInfoDTO.isSex());
			ps.setString(8, userInfoDTO.getEmail());

		updateCount = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		if(updateCount == 1) {
			result = true;

		}

		return result;
	}

	/**
	 * 指定したユーザーのパスワードを変更する
	 * @param password
	 * @param userId
	 * @return result
	 */
	public int  update(String password,String userId) {
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE user_info SET password = ? WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			int i = ps.executeUpdate();

			if(i > 0) {
				System.out.println(i + "件変更されました。");
				result = i;

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}
		return result;

	}

	/**
	 * ログインを試みる
	 * @param password
	 * @param userId
	 * @return userInfoDTOList
	 */
	public List<UserInfoDTO> select(String password,String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE password = ? AND user_id = ?";
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setUserId(rs.getString("userId"));
				userInfoDTOList.add(userInfoDTO);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}
		return userInfoDTOList;
	}

	/**
	 * 必要なユーザー情報を引き出している
	 * @param userId
	 * @return userInfoDTO
	 */
	public ArrayList<UserInfoDTO> userInfo(String userId) {
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
	    Connection con = db.getConnection();

		String sql = "SELECT family_name,first_name,family_name_kana,first_name_kana,sex,email FROM user_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				UserInfoDTO userInfodto = new UserInfoDTO();
				userInfodto.setFamilyName(rs.getString("family_name"));
				userInfodto.setFirstName(rs.getString("first_name"));
				userInfodto.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfodto.setFirstNameKana(rs.getString("first_name_kana"));
				userInfodto.setSex(rs.getBoolean("sex"));
				userInfodto.setEmail(rs.getString("email"));
				userInfoDTO.add(userInfodto);

			}

		}catch(SQLException e){
			e.printStackTrace();

		}

		try{
			con.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
		return userInfoDTO;

	}

	/**
	 * 目標のユーザーIDがあるかどうか
	 * @param userId
	 * @return result
	 * @throws SQLException
	 */
	public boolean existsUserId(String userId) throws SQLException {
		boolean result = false;
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				result = true;

			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}
		return result;
	}
}