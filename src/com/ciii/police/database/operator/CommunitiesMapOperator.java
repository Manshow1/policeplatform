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
import com.ciii.police.model.database.InputOldPeoples;
import com.ciii.police.model.response.oldpeople.NanGongCommunitiesAllResult;

/**
 * @author litong
 *
 */
public final class CommunitiesMapOperator extends SQLInjection {
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(SchoolMapOperator.class);
	
	/**
	 * 
	 */
	public static Integer insertCommunitiesMap() throws SQLException{
		Integer ret = 0;
		
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<NanGongCommunitiesAllResult> data = OldPeopleInfo.getOutputNanGongCommunitiesAll().getResult();
		for(int index = 0; index < data.size(); index++){
			String gid = data.get(index).getGid();
			String sql = "SELECT * FROM communities WHERE gid ='" + gid + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			}
			else {
				String title =  data.get(index).getTitle();
				String address = data.get(index).getAddress();
				String manager = data.get(index).getManager();
				sql = "INSERT INTO communities(gid, title, address, manager) VALUES ('" + gid + "','" + title + "','" + address + "','" + manager +"')";
				dao.insert(sql);
				log.info(date.toString()+"：communities表插入一条记录!"+ gid + "...");
			}
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * 
	 */
	public static ArrayList<String> getManager() throws SQLException{
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<String> arrManager = new ArrayList<String>();
		String sql = "SELECT manager FROM communities";
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			dao.closeConnection();
			return arrManager;
		}
		while(rs.next()){
			boolean repetition  = false;
			for(int index = 0; index < arrManager.size(); index++){
				if(arrManager.get(index).equals(rs.getString("manager"))){
					repetition  = true;
					break;
				}
			}
			if(true == repetition){
				continue;
			}
			else{
				arrManager.add(rs.getString("manager"));
			}
		}
		
		dao.closeConnection();
		return arrManager;
	}
	
	/**
	 * 
	 */
	public static void getGidTitleByManager(InputOldPeoples in) throws SQLException{
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		for(int index = 0; index < in.getData().size(); index++){
			
			String manager = in.getData().get(index).getUid();
			String sql = "SELECT gid,title FROM communities WHERE manager ='" + manager + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				dao.closeConnection();
			}
			while(rs.next()){
				in.getData().get(index).addGid(rs.getString("gid"));
				in.getData().get(index).addTitle(rs.getString("title"));
			}
		}
		
		dao.closeConnection();
	}
}
