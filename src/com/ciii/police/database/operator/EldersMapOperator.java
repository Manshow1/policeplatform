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
import com.ciii.police.model.response.oldpeople.NanGongCommunityIdEldersResult;

/**
 * @author litong
 *
 */
public final class EldersMapOperator extends SQLInjection {
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
		
		for(int index = 0; index < OldPeopleInfo.getOutputNanGongCommunityIdEldersList().size(); index++){
			ArrayList<NanGongCommunityIdEldersResult> data = OldPeopleInfo.getOutputNanGongCommunityIdEldersList().get(index).getResult();
			for(int i = 0; i < data.size(); i++){
				String id = data.get(i).getId();
				String sql = "SELECT * FROM elder WHERE id ='" + id + "'";
				ResultSet rs = dao.getResultSet(sql);
				if (rs == null) {
					continue;
				}
				else if (rs.next()) {
					continue;
				}
				else {
					String name =  data.get(i).getName();
					String username = data.get(i).getUsername();
					String age = data.get(i).getAge();
					String sex = data.get(i).getSex();
					String title = data.get(i).getTitle();
					switch(data.get(i).getContacts().getFamily().size()){
					case 1:
						sql = "INSERT INTO elder(id, name, username, age, sex, title, mobile1, name1) "
								+ "VALUES ('" + id + "','" + name + "','" + username + "','" + age + "','" + sex + "','"  + title + "','"
								+ data.get(i).getContacts().getFamily().get(0).getMobile() + "','" + data.get(i).getContacts().getFamily().get(0).getName() 
								+"')";
						break;
					case 2:
						sql = "INSERT INTO elder(id, name, username, age, sex, title, mobile1, name1, mobile2, name2) "
								+ "VALUES ('" + id + "','" + name + "','" + username + "','" + age + "','" + sex +"','"  + title + "','"
								+ data.get(i).getContacts().getFamily().get(0).getMobile() + "','" + data.get(i).getContacts().getFamily().get(0).getName() +"','"
								+ data.get(i).getContacts().getFamily().get(1).getMobile() + "','" + data.get(i).getContacts().getFamily().get(1).getName() 
								+"')";
						break;
					case 3:
						sql = "INSERT INTO elder(id, name, username, age, sex, title, mobile1, name1, mobile2, name2, mobile3, name3) "
								+ "VALUES ('" + id + "','" + name + "','" + username + "','" + age + "','" + sex + "','" + title + "','" 
								+ data.get(i).getContacts().getFamily().get(0).getMobile() + "','" + data.get(i).getContacts().getFamily().get(0).getName() +"','"
								+ data.get(i).getContacts().getFamily().get(1).getMobile() + "','" + data.get(i).getContacts().getFamily().get(1).getName() +"','" 
								+ data.get(i).getContacts().getFamily().get(2).getMobile() + "','" + data.get(i).getContacts().getFamily().get(2).getName()
								+"')";
						break;
					case 4:
						sql = "INSERT INTO elder(id, name, username, age, sex, title, mobile1, name1, mobile2, name2, mobile3, name3, mobile4, name4) "
								+ "VALUES ('" + id + "','" + name + "','" + username + "','" + age + "','" + sex  + "','" + title + "','" 
								+ data.get(i).getContacts().getFamily().get(0).getMobile() + "','" + data.get(i).getContacts().getFamily().get(0).getName() +"','"
								+ data.get(i).getContacts().getFamily().get(1).getMobile() + "','" + data.get(i).getContacts().getFamily().get(1).getName() +"','" 
								+ data.get(i).getContacts().getFamily().get(2).getMobile() + "','" + data.get(i).getContacts().getFamily().get(2).getName() +"','" 
								+ data.get(i).getContacts().getFamily().get(3).getMobile() + "','" + data.get(i).getContacts().getFamily().get(3).getName()
								+"')";
						break;
					default:
						sql = "INSERT INTO elder(id, name, username, age, sex, title) VALUES ('" + id + "','" + name + "','" + username + "','" + age + "','" + sex + "','" + title +"')";
						break;
					}
					dao.insert(sql);
					log.info(date.toString()+"：elder表插入一条记录!"+ id + "...");
				}
			}
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * 
	 */
	public static String GetUserIdByphone(String oldpeoplephone) throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		String ret = "";
				
		String sql = "SELECAT id FROM elder WHERE username ='" +oldpeoplephone + "'";
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			log.info(date.toString()+"：数据库查询出现异常!");
		}
		else if (rs.next()) {
			ret = rs.getString("id");
			dao.closeConnection();
			return ret;
		}
		else {
			log.info(date.toString()+"：账号不存在!");
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static ArrayList<String> getAllUserid() throws SQLException{
		Date date = new Date();
		
		ArrayList<String> alluserid = new ArrayList<String>();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		String sql = "SELECT id FROM elder";
		ResultSet rs = dao.getResultSet(sql);
		log.info(date.toString()+"：提取全部userID");
		if (rs == null) {
			dao.closeConnection();
			return alluserid;
		}
		while(rs.next()){
			alluserid.add(rs.getString("id"));
		}
		
		dao.closeConnection();
		return alluserid;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static boolean getInfoforAlarmPosition() throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		for(int index = 0; index < OldPeopleInfo.getAlarmPositionInfoList().size(); index++){
			String sql = "SELECT name,title FROM elder WHERE id ='" +OldPeopleInfo.getAlarmPositionInfoList().get(index).getUserId() + "'";
			ResultSet rs = dao.getResultSet(sql);
			log.info(date.toString()+"：iemi表中查询name,title");
			if (rs == null) {
				dao.closeConnection();
				return false;
			}
			while(rs.next()){
				OldPeopleInfo.getAlarmPositionInfoList().get(index).setName(rs.getString("name"));
				OldPeopleInfo.getAlarmPositionInfoList().get(index).setTitle(rs.getString("title"));
			}
		}
		
		dao.closeConnection();
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static boolean getInfoforAlarmMessage() throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		for(int index = 0; index < OldPeopleInfo.getAlarmMessageInfoList().size(); index++){
			String sql = "SELECT name,title,name1,mobile1 FROM elder WHERE id ='" +OldPeopleInfo.getAlarmMessageInfoList().get(index).getUserId() + "'";
			ResultSet rs = dao.getResultSet(sql);
			log.info(date.toString()+"：iemi表中查询name,title,name1,mobile1");
			if (rs == null) {
				dao.closeConnection();
				return false;
			}
			while(rs.next()){
				OldPeopleInfo.getAlarmMessageInfoList().get(index).setName(rs.getString("name"));
				OldPeopleInfo.getAlarmMessageInfoList().get(index).setTitle(rs.getString("school"));
				OldPeopleInfo.getAlarmMessageInfoList().get(index).setKinsfolkname(rs.getString("name1"));
				OldPeopleInfo.getAlarmMessageInfoList().get(index).setKinsfolkphone(rs.getString("mobile1"));
			}
		}
		
		dao.closeConnection();
		return true;
	}
}
