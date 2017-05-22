/**
 * 
 */
package com.ciii.police.database.operator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.dao.DAO;
import com.ciii.police.model.database.InputOldPeopleData;
import com.ciii.police.model.database.InputOldPeoples;
import com.ciii.police.model.response.oldpeople.OutputNanGongUserLogin;
import com.ciii.police.model.response.oldpeople.OutputNanGongUsernameID;

/**
 * @author litong
 *
 */
public final class UsernameIdMapOperator extends SQLInjection {
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(SchoolMapOperator.class);
	
	/**
	 * 
	 */
	public static Integer insertUsernameIdMap() throws SQLException{
		Integer ret = 0;
		
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<OutputNanGongUsernameID> data = OldPeopleInfo.getOutputNanGongUsernameIDList();
		for(int index = 0; index < data.size(); index++){
			String result = data.get(index).getResult();
			String sql = "SELECT * FROM usernameid WHERE result ='" + result + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			}
			else {
				String status =  data.get(index).getStatus();
				String description = data.get(index).getDescription();
				sql = "INSERT INTO usernameid(status, description, result) VALUES ('" + status + "','" + description + "','" + result +"')";
				dao.insert(sql);
				log.info(date.toString()+"：usernameid表插入一条记录!"+ result + "...");
			}
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * 
	 */
	public static ArrayList<String> getResult() throws SQLException{
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<String> arrResult = new ArrayList<String>();
		String sql = "SELECT result FROM usernameid";
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			dao.closeConnection();
			return arrResult;
		}
		while(rs.next()){
			arrResult.add(rs.getString("result"));
		}
		
		dao.closeConnection();
		return arrResult;
	}
	
	/**
	 * 
	 */
	public static void updateUsernameIdMap() {
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<OutputNanGongUserLogin> data = OldPeopleInfo.getOutputNanGongUserLoginList();
		for(int index = 0; index < data.size(); index++){
			String result = data.get(index).getEmail();
			String token = data.get(index).getResult().getToken();
			String uid = data.get(index).getResult().getUid();
			String sql = "UPDATE usernameid SET token = '"+ token + "', uid = '"+ uid +"' WHERE result = '" + result +"'";
			dao.update(sql);
		}
		
		dao.closeConnection();
	}
	
	/**
	 * 
	 */
	public static void getResultTokenUid(InputOldPeoples inputOldPeoples) throws SQLException{
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		String sql = "SELECT token, uid FROM usernameid";
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			dao.closeConnection();
		}
		while(rs.next()){
			InputOldPeopleData data = new InputOldPeopleData();
			data.setToken(rs.getString("token"));
			data.setUid(rs.getString("uid"));
			inputOldPeoples.addData(data);
		}
		
		dao.closeConnection();
	}
}
