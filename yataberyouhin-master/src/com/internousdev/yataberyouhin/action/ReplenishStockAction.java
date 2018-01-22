package com.internousdev.yataberyouhin.action;

import java.sql.SQLException;

import com.internousdev.yataberyouhin.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReplenishStockAction extends ActionSupport{

	/**
	 * 在庫を補充した商品の数
	 */
	int replenishCount;

	public String execute() throws SQLException {
		ProductInfoDAO productDAO = new ProductInfoDAO();
		replenishCount = productDAO.replenishStock();

		return SUCCESS;
	}

	/**
	 * @return replenishCount
	 */
	public int getReplenishCount() {
		return replenishCount;
	}

	/**
	 * @param replenishCount セットする replenishCount
	 */
	public void setReplenishCount(int replenishCount) {
		this.replenishCount = replenishCount;
	}
}
