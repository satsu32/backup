package com.internousdev.yataberyouhin.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.yataberyouhin.dao.CartInfoDAO;
import com.internousdev.yataberyouhin.dao.ProductInfoDAO;
import com.internousdev.yataberyouhin.dao.PurchaseHistoryDAO;
import com.internousdev.yataberyouhin.dto.CartInfoDTO;
import com.internousdev.yataberyouhin.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseCompletionAction extends ActionSupport implements SessionAware {

	/**
	 * カート情報
	 */
	private ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 商品一覧情報
	 */
	private ProductInfoDTO productInfoDTO = new ProductInfoDTO();

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	public String execute() throws SQLException {
		String result = SUCCESS;
		CartInfoDAO cartInfodao = new CartInfoDAO();
		PurchaseHistoryDAO purchaseHistorydao = new PurchaseHistoryDAO();
		ProductInfoDAO productInfodao = new ProductInfoDAO();

		cartInfoDTO = cartInfodao.aquireUserCartInfo(session.get("userId").toString());

		for (CartInfoDTO dto : cartInfoDTO) {
			productInfoDTO = productInfodao.selectByProductId(dto.getProductId());

			if (!(productInfoDTO.getStock() - dto.getCount() < 0)) {
				productInfodao.updateStock(productInfoDTO.getProductId(), (productInfoDTO.getStock() - dto.getCount()));
				purchaseHistorydao.purchaseHistoryInfo(session.get("userId").toString(), dto.getProductId(), dto.getCount());

			} else {

				errorMessage = "在庫を超える数を購入しようとしました。";
				cartInfodao.deleteProductFromCart(session.get("userId").toString(), dto.getProductId());
				result = ERROR;
			}
		}
		cartInfodao.deleteUserCartInfo(session.get("userId").toString());

		return result;

	}

	/**
	 * @return Session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param Session セットする Session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return ProductInfoDTO
	 */
	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;
	}

	/**
	 * @param productInfoDTO セットする productInfoDTO
	 */
	public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
		this.productInfoDTO = productInfoDTO;
	}

	/**
	 * @return ErrorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage セットする ErrorMassage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}