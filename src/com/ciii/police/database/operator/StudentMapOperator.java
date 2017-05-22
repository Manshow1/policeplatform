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
import com.ciii.police.model.response.student.NanGongStudentData;

/**
 * @author litong
 *
 */
public final class StudentMapOperator extends SQLInjection{
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(StudentMapOperator.class);
	
	/**
	 * 
	 */
	public static Integer insertStudentMap() throws SQLException{
		Integer ret = 0;
		
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<NanGongStudentData> data = StudentInfo.getOutputNanGongStudentsInfo().getData();
		for(int index = 0; index < data.size(); index++){
			String id = data.get(index).getId();
			String sql = "SELECT * FROM student WHERE id ='" + id + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			} 
			else {
				String name = data.get(index).getName();
				String school_id = data.get(index).getSchool_id();
				String avatar = data.get(index).getAvatar();
				String school = data.get(index).getSchool();
				sql = "INSERT INTO student(id, name, school_id, avatar, school) VALUES ('" + id + "','" + name + "','" + school_id + "','" + avatar + "','" + school +"')";
				dao.insert(sql);
				log.info(date.toString()+"：student表插入一条记录!"+ id + "...");
			}
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
		
		String sql = "SELECT id FROM student";
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
}
