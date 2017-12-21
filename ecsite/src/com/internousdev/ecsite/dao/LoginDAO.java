package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	 private LoginDTO loginDTO =new LoginDTO();


      /**
       * ログインユーザ情報取得メソッド
       *
       * @param loginUserId
       * @param loginPassword
       * @return LoginDTO
       */
	 public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		 String sql = "SELECT * FROM login_user_transaction where login_id = ? AND llogin_pass=?";

		 try {
			   PreparedStatement preparedStatement = connection.prepareStatement(sql);
			   preparedStatement.setString(1, loginUserId);
			   preparedStatement.setString(2, loginPassword);

			   ResultSet resultSet = preparedStatement.executeQuery();

			   if(resultSet.next()){
		 }
	 }