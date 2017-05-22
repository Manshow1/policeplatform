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
		Integer ret = 0;//1 ���ݿ��ѯ�����쳣 2������� 3�˺Ų����� -1�Ƿ��˺�
		if (sqlInjection(account)) {
			ret = -1;
			log.info("�Ƿ��˺ţ�uid=" + account);
			return ret;
		}
		
		Date date = new Date();
		String sql = "SELECT account, password FROM police WHERE account ='" +account + "'";
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			ret = 1;
			log.info(date.toString()+"�����ݿ��ѯ�����쳣!");
		}
		else if (rs.next()) {
			String pwd = rs.getString("password");
			if (!password.equalsIgnoreCase(pwd)) {
				ret = 2;
				log.info(date.toString()+"���������!");
			}
		}
		else {
			ret = 3;
			log.info(date.toString()+"���˺Ų�����!");
		}
		
		dao.closeConnection();
		return ret;
	}
}
