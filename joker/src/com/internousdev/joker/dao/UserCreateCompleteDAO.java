package com.internousdev.joker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.joker.util.DBConnector;

public class UserCreateCompleteDAO {

	public int cerateUser(String loginUserId, String loginUserPassword, String userName) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values(?,?,?,NOW())";
		int count = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);

			count = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}

}
