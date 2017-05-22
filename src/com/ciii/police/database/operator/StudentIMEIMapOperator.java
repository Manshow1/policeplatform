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

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.dao.DAO;
import com.ciii.police.model.response.student.OutputNanGongStudent;
/**
 * @author litong
 *
 */
public final class StudentIMEIMapOperator extends SQLInjection{
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(StudentMapOperator.class);
	
	/**
	 * 
	 */
	public static Integer insertIEMIMap() throws SQLException{
		Integer ret = 0;
		
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<OutputNanGongStudent> data = StudentInfo.getOutputNanGongStudentListInfo();
		for(int index = 0; index < data.size(); index++){
			String id = data.get(index).getData().getId();
			String sql = "SELECT * FROM iemi WHERE id ='" + id + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			} 
			else {
				String name = data.get(index).getData().getName();
				String cid = data.get(index).getData().getCid();
				String gender = data.get(index).getData().getGender();
				String phone = data.get(index).getData().getPhone();
				String avatar = data.get(index).getData().getAvatar();
				String school = data.get(index).getData().getSchool();
				String _class = data.get(index).getData().get_class();
				String iemi = data.get(index).getData().getDevice().getImei();
				String state = data.get(index).getData().getDevice().getState();
				data.get(index).getData().getDevice().getSims();
				sql = "INSERT INTO iemi(id, name, cid, gender, phone, avatar, school, class, iemi, state, phone1, name1, phone2, name2, phone3, name3, phone4, name4) "
						+ "VALUES ('" + id + "','" + name + "','" + cid + "','" + gender + "','" + phone + "','" + avatar + "','" + school + "','" + _class + "','" + iemi + "','" + state;
				Integer num = data.get(index).getData().getDevice().getSims().size();
				for(int index1 = 0; index1 < num; index1++){
					sql += "','" + data.get(index).getData().getDevice().getSims().get(index1).getPhone();
					sql += "','" + data.get(index).getData().getDevice().getSims().get(index1).getName();
				}
				for(int index2 = 0; index2 < 4-num; index2++){
					sql += "','"+"";//phone
					sql += "','"+"";//name
				}
				sql += "')";
				dao.insert(sql);
				log.info(date.toString()+"：iemi表插入一条记录!"+ id + "...");
			}
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * 
	 */
	public static String GetUserIdByIEMI(String imei) throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		String ret = "";
				
		String sql = "SELECAT id FROM iemi WHERE iemi ='" +imei + "'";
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
	public static boolean getInfoforAlarmPosition() throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		for(int index = 0; index < StudentInfo.getAlarmPositionInfoList().size(); index++){
			String sql = "SELECT name,school FROM iemi WHERE iemi ='" +StudentInfo.getAlarmPositionInfoList().get(index).getIMEI() + "'";
			ResultSet rs = dao.getResultSet(sql);
			log.info(date.toString()+"：iemi表中查询name,school");
			if (rs == null) {
				dao.closeConnection();
				return false;
			}
			while(rs.next()){
				StudentInfo.getAlarmPositionInfoList().get(index).setName(rs.getString("name"));
				StudentInfo.getAlarmPositionInfoList().get(index).setSchool(rs.getString("school"));
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
		
		for(int index = 0; index < StudentInfo.getAlarmMessageInfoList().size(); index++){
			String sql = "SELECT name,school,name1,phone1 FROM iemi WHERE iemi ='" +StudentInfo.getAlarmMessageInfoList().get(index).getIMEI() + "'";
			ResultSet rs = dao.getResultSet(sql);
			log.info(date.toString()+"：iemi表中查询name,school,Parentname,Parentphone");
			if (rs == null) {
				dao.closeConnection();
				return false;
			}
			while(rs.next()){
				StudentInfo.getAlarmMessageInfoList().get(index).setName(rs.getString("name"));
				StudentInfo.getAlarmMessageInfoList().get(index).setSchool(rs.getString("school"));
				StudentInfo.getAlarmMessageInfoList().get(index).setParentname(rs.getString("name1"));
				StudentInfo.getAlarmMessageInfoList().get(index).setParentphone(rs.getString("phone1"));
			}
		}
		
		dao.closeConnection();
		return true;
	}
}
