package com.internousdev.joker.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.joker.dto.UserInfoDTO;
import com.internousdev.joker.util.DBConnector;

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

		String sql = "INSERT INTO login_user_transaction(login_id, login_pass) "
						+ "VALUES(?, ?,NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDTO.getLoginPassword());
			ps.setString(2, userInfoDTO.getLoginUserId());


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
	public int  update(String loginPassword,String loginUserId) {
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE login_user_transaction SET login_pass = ? WHERE login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginPassword);
			ps.setString(2, loginUserId);
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
	public List<UserInfoDTO> select(String loginPassword,String loginUserId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM login_user_transaction WHERE login_pass  = ? AND login_id = ?";
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginPassword);
			ps.setString(2, loginUserId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setLoginPassword(rs.getString("login_pass"));
				userInfoDTO.setLoginUserId(rs.getString("login_id"));
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
	public ArrayList<UserInfoDTO> userInfo(String loginUserId) {
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
	    Connection con = db.getConnection();

		String sql = "SELECT * FROM login_user_transaction  WHERE login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				UserInfoDTO userInfodto = new UserInfoDTO();
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
	public boolean existsUserId(String loginUserId) throws SQLException {
		boolean result = false;
		Connection con = db.getConnection();

		String sql = "SELECT * FROM login_user_transaction WHERE login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
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