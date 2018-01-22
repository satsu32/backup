package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.yataberyouhin.dto.ReviewInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class ReviewInfoDAO {
	public DBConnector db = new DBConnector();
	public Connection con = null;

	/**
	 * 新規レビューをDBに登録する
	 * @param reviewInfoDTO
	 * @return result
	 * @throws SQLException
	 */
	public boolean insertReview(ReviewInfoDTO reviewInfoDTO) throws SQLException {
		boolean result = false;
		int updateCount = 0;

		String sql = "INSERT INTO review_info(user_id, product_id, evaluation, review_detail, insert_date) "
					  + "VALUES(?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reviewInfoDTO.getUserId());
			ps.setInt(2, reviewInfoDTO.getProductId());
			ps.setInt(3, reviewInfoDTO.getEvaluation());
			ps.setString(4, reviewInfoDTO.getReviewDetail());
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
	 * 指定した商品のレビューを全て取得
	 * @param productId
	 * @return reviewList
	 * @throws SQLException
	 */
	public ArrayList<ReviewInfoDTO> aquireReviewInfo(int productId) throws SQLException {
		ArrayList<ReviewInfoDTO> reviewList = new ArrayList<>();

		String sql = "SELECT ui.family_name, ui.first_name, ri.evaluation, ri.review_detail, ri.insert_date FROM review_info as ri LEFT JOIN user_info as ui ON ri.user_id = ui.user_id WHERE product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ReviewInfoDTO reviewInfoDTO = new ReviewInfoDTO();
				reviewInfoDTO.setFamilyName(rs.getString("family_name"));
				reviewInfoDTO.setFirstName(rs.getString("first_name"));
				reviewInfoDTO.setEvaluation(rs.getInt("evaluation"));
				reviewInfoDTO.setReviewDetail(rs.getString("review_detail"));
				reviewInfoDTO.setInsertDate(rs.getDate("insert_date"));
				reviewList.add(reviewInfoDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return reviewList;
	}

	/**
	 * 目標のユーザーが目標の商品のレビューを既に書いていればtrueを返す
	 * @param userId
	 * @param productId
	 * @return result
	 * @throws SQLException
	 */
	public boolean isExist(String userId, int productId) throws SQLException {
		boolean result = false;
		String sql = "SELECT * FROM review_info WHERE user_id = ? AND product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				result = true;

			} else {
				result = false;

			}

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}

		return result;
	}

	/**
	 * 目標のユーザーの指定の商品のレビューを削除する
	 * @param userId
	 * @param productId
	 * @return result
	 * @throws SQLException
	 */
	public boolean deleteReview(String userId, int productId) throws SQLException {
		boolean result = false;
		int updateCount = 0;
		String sql = "DELETE FROM review_info WHERE user_id = ? AND product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
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
}