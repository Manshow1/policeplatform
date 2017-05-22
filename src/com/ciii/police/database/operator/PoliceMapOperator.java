/**
 * 
 */
package com.ciii.police.database.operator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ciii.police.controller.PoliceController;
import com.ciii.police.dao.DAO;

/**
 * @author litong
 *
 */
public final class PoliceMapOperator extends SQLInjection{
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(PoliceController.class);
	
	/**
	 * 
	 */
	public Integer verification(String account, String password) throws SQLException{
		Integer ret = 0;//1 数据库查询出现异常 2密码错误 3账号不存在 -1非法账号
		if (sqlInjection(account)) {
			ret = -1;
			log.info("非法账号，uid=" + account);
			return ret;
		}
		
		Date date = new Date();
		String sql = "SELECT account, password FROM police WHERE account ='" +account + "'";
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			ret = 1;
			log.info(date.toString()+"：数据库查询出现异常!");
		}
		else if (rs.next()) {
			String pwd = rs.getString("password");
			if (!password.equalsIgnoreCase(pwd)) {
				ret = 2;
				log.info(date.toString()+"：密码错误!");
			}
		}
		else {
			ret = 3;
			log.info(date.toString()+"：账号不存在!");
		}
		
		dao.closeConnection();
		return ret;
	}
}
