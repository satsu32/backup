package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.yataberyouhin.dto.UserInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;


public class LoginDAO {

	/**
	 * ユーザー情報を引き出す
	 * @param userId
	 * @param password
	 * @return
	 */
	public UserInfoDTO select(String userId,String password) /*throws SQLException*/ {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user_info where user_id=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));

			}

		} catch (SQLException e){
			e.printStackTrace();

		} /*finally {
			con.close();
		}*/

		return userInfoDTO;
	}

	/**
	 * ログイン
	 * @param userInfoDTO
	 * @return
	 * @throws SQLException
	 */
	public boolean login(UserInfoDTO userInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE user_info SET logined=1 WHERE user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getUserId());
			updateCount = ps.executeUpdate();
			if(updateCount > 0) {
				System.out.println("ログイン済み");
				result = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return result;

	}

	/**
	 * ログアウト
	 * @param userInfoDTO
	 * @return
	 * @throws SQLException
	 */
	public boolean logout(UserInfoDTO userInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE user_info SET logined=0 WHERE user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getUserId());
			updateCount = ps.executeUpdate();
			if(updateCount > 0) {
				System.out.println("未ログイン");
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	/**
	 * ユーザーIDが存在してるか確認
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean existsUserId(String userId) throws SQLException {

		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return result;
	}

}