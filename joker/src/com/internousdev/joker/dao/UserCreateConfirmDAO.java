package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.joker.util.DBConnector;

public class UserCreateConfirmDAO {

	public boolean isExistsLoginUserId(String loginUserId) {
		boolean result = false;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select count(login_id) as count from login_user_transaction where login_id=?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();

			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
			if (count > 0) {
				result = true;
			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
