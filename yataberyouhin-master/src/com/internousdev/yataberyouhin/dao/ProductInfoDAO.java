package com.internousdev.yataberyouhin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.internousdev.yataberyouhin.dto.ProductInfoDTO;
import com.internousdev.yataberyouhin.util.DBConnector;

public class ProductInfoDAO {
	public ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	/**
	 * Product_InfoDTOの中身を全て取得
	 * @return productInfoDTOList
	 */
	public ArrayList<ProductInfoDTO> selectAll() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM product_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setStock(rs.getInt("stock"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getShort("status"));
				productInfoDTO.setInsertDate(rs.getDate("insert_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(productInfoDTO);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}

		return productInfoDTOList;
	}

	/**
	 * ProductIdに対応したDTOの中身を取得
	 *
	 * @param productId
	 * @return productInfoDTO
	 */
	public ProductInfoDTO selectByProductId(int productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT * FROM product_info WHERE product_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setStock(rs.getInt("stock"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getShort("status"));
				productInfoDTO.setInsertDate(rs.getDate("insert_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}
		return productInfoDTO;
	}

	/**
	 * CategoryIdに対応したDTOの中身を取得
	 *
	 * @param productId
	 * @return productInfoDTOList
	 */
	public ArrayList<ProductInfoDTO> selectByCategoryId(int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		if(categoryId == 1) {
			productInfoDTOList = this.selectAll();

		} else {
			String sql = "SELECT *  FROM product_info WHERE category_id = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, categoryId);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(rs.getInt("id"));
					productInfoDTO.setProductId(rs.getInt("product_id"));
					productInfoDTO.setProductName(rs.getString("product_name"));
					productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
					productInfoDTO.setProductDescription(rs.getString("product_description"));
					productInfoDTO.setCategoryId(rs.getInt("category_id"));
					productInfoDTO.setPrice(rs.getInt("price"));
					productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
					productInfoDTO.setImageFileName(rs.getString("image_file_name"));
					productInfoDTO.setReleaseDate(rs.getDate("release_date"));
					productInfoDTO.setReleaseCompany(rs.getString("release_company"));
					productInfoDTO.setStatus(rs.getShort("status"));
					productInfoDTO.setInsertDate(rs.getDate("insert_date"));
					productInfoDTO.setUpdateDate(rs.getDate("update_date"));
					productInfoDTOList.add(productInfoDTO);

				}

			} catch(SQLException e) {
				e.printStackTrace();

			}

			try {
				con.close();

			} catch(SQLException e) {
				e.printStackTrace();

			}
		}
		return productInfoDTOList;
	}

	/**
	 * キーワードに対応したDTOの中身を取得
	 *
	 * @param keyword
	 * @return productInfoDTOList
	 */
	public ArrayList<ProductInfoDTO> selectByKeyWord(String keyword) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT *  FROM product_info WHERE product_name LIKE '%" + keyword
					+ "%' OR product_name_kana LIKE '%" + keyword + "%'";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getShort("status"));
				productInfoDTO.setInsertDate(rs.getDate("insert_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(productInfoDTO);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}
		return productInfoDTOList;
	}

	/**
	 *カテゴリーIDとキーワードに対応したDTOの中身を取得
	 *
	 * @param categoryId
	 * @param keyword
	 * @return productInfoDTOList
	 */
	public ArrayList<ProductInfoDTO> selectByMultiple(int categoryId, String keyword) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

			String sql = "SELECT *  FROM product_info WHERE (product_name LIKE '%" + keyword + "%' AND category_id=" + categoryId+ ") OR (product_name_kana LIKE '%" + keyword + "%' AND category_id=" + categoryId +")";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					productInfoDTO = new ProductInfoDTO();
					productInfoDTO.setId(rs.getInt("id"));
					productInfoDTO.setProductId(rs.getInt("product_id"));
					productInfoDTO.setProductName(rs.getString("product_name"));
					productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
					productInfoDTO.setProductDescription(rs.getString("product_description"));
					productInfoDTO.setCategoryId(rs.getInt("category_id"));
					productInfoDTO.setPrice(rs.getInt("price"));
					productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
					productInfoDTO.setImageFileName(rs.getString("image_file_name"));
					productInfoDTO.setReleaseDate(rs.getDate("release_date"));
					productInfoDTO.setReleaseCompany(rs.getString("release_company"));
					productInfoDTO.setStatus(rs.getShort("status"));
					productInfoDTO.setInsertDate(rs.getDate("insert_date"));
					productInfoDTO.setUpdateDate(rs.getDate("update_date"));
					productInfoDTOList.add(productInfoDTO);

				}

				if(rs.wasNull()) {
					productInfoDTOList = null;

				}

			} catch(SQLException e) {
				e.printStackTrace();

			}

			try {
				con.close();

			} catch(SQLException e) {
				e.printStackTrace();

		}
		return productInfoDTOList;
	}

	/**
	 *複数のキーワードを取得
	 * @param keywords
	 * @return productInfoDTOList
	 */
	public ArrayList<ProductInfoDTO> selectByKeyWords(String[] keywords) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT *  FROM product_info WHERE ";

		for(int k = 0; k < keywords.length; k ++) {

			if(k != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[k] + "%' OR product_name_kana LIKE '%" + keywords[k]+ "%') ";

			} else {
				sql = sql + " (product_name LIKE '%" + keywords[k] + "%' OR product_name_kana LIKE '%" + keywords[k]+ "%') ";

			}
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getShort("status"));
				productInfoDTO.setInsertDate(rs.getDate("insert_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));
				productInfoDTOList.add(productInfoDTO);

			}

		} catch(SQLException e) {
			e.printStackTrace();

		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();

		}

		return productInfoDTOList;
	}

	/**
	 * 在庫の数を変更するメソッド
	 * @return result
	 * @throws SQLException
	 */
	public int updateStock(int productId,int stock) throws SQLException {
		int result = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE product_info SET stock = ? WHERE product_id = ? ";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, productId);
			result = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();

		}
		return result;
	}


	/**
	 * 商品名が既に使われているか確認
	 * @param productName
	 * @return result
	 * @throws SQLException
	 */
	public boolean existsProductName(String productName) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = null;
		boolean result = false;
		String sql = "SELECT * FROM product_info WHERE product_name = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productName);
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


	/**
	 * 商品名かなが既に使われているか確認
	 * @param productNameKana
	 * @return result
	 * @throws SQLException
	 */
	public boolean existsProductNameKana(String productNameKana) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = null;
		boolean result = false;
		String sql = "SELECT * FROM product_info WHERE product_name_kana = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productNameKana);
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


	/**
	 * 商品IDが既に使われているか確認
	 * @param productNameKana
	 * @return result
	 * @throws SQLException
	 */
	public boolean existsProductId(int productId) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = null;
		boolean result = false;
		String sql = "SELECT * FROM product_info WHERE product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
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


	/**
	 * 新規商品情報を登録する
	 * @param productInfoDTO
	 * @return result
	 * @throws SQLException
	 */
	public boolean insertNewProduct(ProductInfoDTO productInfoDTO) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = null;

		//DBに入れるためのDateの型変換
		Calendar cal = Calendar.getInstance();
		cal.setTime(productInfoDTO.getReleaseDate());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date releaseDate = new java.sql.Date(cal.getTimeInMillis());

		boolean result = false;
		int updateCount = 0;
		String sql = "INSERT INTO product_info(product_id, product_name, product_name_kana, product_description, category_id, price, stock, image_file_path, image_file_name, release_date, release_company, insert_date) "
					 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productInfoDTO.getProductId());
			ps.setString(2, productInfoDTO.getProductName());
			ps.setString(3, productInfoDTO.getProductNameKana());
			ps.setString(4, productInfoDTO.getProductDescription());
			ps.setInt(5, productInfoDTO.getCategoryId());
			ps.setInt(6, productInfoDTO.getPrice());
			ps.setInt(7, productInfoDTO.getStock());
			ps.setString(8, productInfoDTO.getImageFilePath());
			ps.setString(9, productInfoDTO.getImageFileName());
			ps.setDate(10, releaseDate);
			ps.setString(11, productInfoDTO.getReleaseCompany());

			updateCount = ps.executeUpdate();

		} catch (SQLException e) {
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
	 * 全商品の在庫を100個まで補充する
	 * @return
	 * @throws SQLException
	 */
	public int replenishStock() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = null;
		int updateCount = 0;

		String sql = "UPDATE product_info SET stock = 100";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return updateCount;
	}
}