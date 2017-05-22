/**
 * 
 */
package com.ciii.police.database.operator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.dao.DAO;
import com.ciii.police.model.response.student.OutputAlarms;
import com.ciii.police.model.web.student.AlarmMessageInfo;
import com.ciii.police.model.web.student.AlarmPositionInfo;
import com.ciii.police.trans.TimeTransfer;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public final class StudentAlarmMapOperator extends SQLInjection{
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(StudentMapOperator.class);
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	public static Integer insertAlarmMap() throws SQLException, ParseException, java.text.ParseException{
		Integer ret = 0;
		
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		OutputAlarms data = StudentInfo.getOutputAlarmsInfoList(0);
		int total = data.getData().getTotal();
		//System.out.println("插入报警信息->总数："+total);
		for(int index = 0; index < total; index++){
			String _id = data.getData().getData().get(index).get_id();
			String sql = "SELECT * FROM alarm WHERE _id ='" + _id + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			} 
			else {
				String alarmMode = data.getData().getData().get(index).getAlarmMode();
				int alarmType = data.getData().getData().get(index).getAlarmType();
				String description = data.getData().getData().get(index).getDescription();
				String userId = data.getData().getData().get(index).getUserId();
				String IMEI = data.getData().getData().get(index).getIMEI();
				int __v = data.getData().getData().get(index).get__v();
				//String extraDes = data.getData().getData().get(index).getExtraDes();
				double longitude = data.getData().getData().get(index).getLongitude();
				double latitude = data.getData().getData().get(index).getLatitude();
				long timestamp = data.getData().getData().get(index).getUploadTime();
				int deviceAlarm = data.getData().getData().get(index).getDeviceAlarm();
				int state = 1;
				sql = "INSERT INTO alarm(_id, alarmMode, description, userId, IMEI, __v, longitude, latitude, deviceAlarm, alarmType, timestamp, state) "
						+ "VALUES ('" + _id + "','" + alarmMode + "','" + description + "','" + userId + "','" + IMEI + "','" + __v +  "','" + longitude +  "','" + latitude +  "','" + deviceAlarm +  "','" + alarmType +  "','" + timestamp +  "','" + state + "')";
				dao.insert(sql);
				//System.out.println(sql);
				//log.info(date.toString()+"：alarm表插入一条记录!"+ _id + "...");
			}
		}
		
		dao.closeConnection();
		return ret;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static boolean getAlarmPositionInfo(int timestamp) throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		String sql = "SELECT IMEI,description,longitude,latitude,timestamp FROM alarm WHERE timestamp >'" + timestamp + "' AND state = '1'";
		ResultSet rs = dao.getResultSet(sql);
		log.info(date.toString()+"：alarm表中查询AlarmPosition");
		if (rs == null) {
			dao.closeConnection();
			return false;
		}
		while(rs.next()){
			AlarmPositionInfo alarmPositionInfo = new AlarmPositionInfo();
			alarmPositionInfo.setIMEI(rs.getString("IMEI"));
			alarmPositionInfo.setDescription(rs.getString("description"));
			alarmPositionInfo.setLongitude(rs.getDouble("longitude"));
			alarmPositionInfo.setLatitude(rs.getDouble("latitude"));
			alarmPositionInfo.setUploadTime(TimeTransfer.stampToDate(rs.getLong("timestamp")));
			//System.out.println(alarmPositionInfo.toString());
			StudentInfo.addAlarmPositionInfo(alarmPositionInfo);
			//System.out.println("addAlarmPositionInfo");
		}
		
		dao.closeConnection();
		return true;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static boolean getAlarmMessageInfo(String IEMI, long startStamp, long endStamp, int state) throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		boolean haswhere = false;
		String sql = "SELECT IMEI,description,timestamp,state FROM alarm";
		if(false == IEMI.equals("")){
			if(false == haswhere){
				sql +=  " WHERE ";
				haswhere = true;
			}
			sql +=  "IMEI ='" + IEMI + "'";
		}
		if(0 < startStamp){
			if(false == haswhere){
				sql +=  " WHERE ";
				haswhere = true;
			}
			if(false == IEMI.equals("")){
				sql += " AND ";
			}
			sql += "timestamp >'" + startStamp + "'";
		}
		if(0 < endStamp){
			if(false == haswhere){
				sql +=  " WHERE ";
				haswhere = true;
			}
			if((false == IEMI.equals(""))||(0 < startStamp)){
				sql += " AND ";
			}
			sql += "timestamp <'" + endStamp + "'";
		}
		if(0 == state){
		}
		if(/*(0 == state)||*/(1 == state)||(2 == state)||(3 == state)||(4 == state) ){
			if(false == haswhere){
				sql +=  " WHERE ";
				haswhere = true;
			}
			if((false == IEMI.equals(""))||(0 < startStamp)||(0 < endStamp)){
				sql += " AND ";
			}
			sql += "state ='" + state + "'";
		}
		sql += " ORDER BY timestamp DESC";
		ResultSet rs = dao.getResultSet(sql);
		log.info(date.toString()+"：alarm表中查询AlarmMessage");
		if (rs == null) {
			dao.closeConnection();
			return false;
		}
		while(rs.next()){
			AlarmMessageInfo alarmMessageInfo = new AlarmMessageInfo();
			alarmMessageInfo.setIMEI(rs.getString("IMEI"));
			alarmMessageInfo.setDescription(rs.getString("description"));
			alarmMessageInfo.setUploadTime(TimeTransfer.stampToDate(rs.getLong("timestamp")));
			alarmMessageInfo.setState(rs.getInt("state"));
			StudentInfo.addAlarmMessageInfo(alarmMessageInfo);
		}
		
		dao.closeConnection();
		return true;
	}
	
	/**
	 * 
	 */
	public static void GetAlarmNumber() throws SQLException{
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
				
		String sql = "SELECT state FROM alarm";
		ResultSet rs = dao.getResultSet(sql);
		if (rs == null) {
			log.info(date.toString()+"：数据库查询出现异常!");
			dao.closeConnection();
			return;
		}
		StudentInfo.initTotalalarm();
		StudentInfo.initUntreatedAlarm();
		while (rs.next()) {
			StudentInfo.addTotalalarm();
			if(1 == rs.getInt("state")){
				StudentInfo.addUntreatedAlarm();
			}
		}
		
		dao.closeConnection();
	}
	
	/**
	 * 
	 */
	public static void updateAlarmState(String IMEI, int timestamp, int state) {
		//Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
				
		String sql = "UPDATE alarm SET state = '"+ state + "' WHERE timestamp = '" + timestamp + "' AND " + "IMEI = '" + IMEI +"'";
		dao.update(sql);
		
		dao.closeConnection();
	}
}
