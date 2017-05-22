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
import com.ciii.police.model.response.student.NanGongSchoolData;

/**
 * @author litong
 *
 */
public final class SchoolMapOperator extends SQLInjection{
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(SchoolMapOperator.class);
	
	/**
	 * 
	 */
	public static Integer insertSchoolMap() throws SQLException{
		Integer ret = 0;
		
		Date date = new Date();
		
		DAO dao = new DAO();
		dao.openConnection();
		
		ArrayList<NanGongSchoolData> data = StudentInfo.getOutputNanGongSchoolsInfo().getData();
		for(int index = 0; index < data.size(); index++){
			String id = data.get(index).getId();
			String sql = "SELECT * FROM school WHERE id ='" + id + "'";
			ResultSet rs = dao.getResultSet(sql);
			if (rs == null) {
				continue;
			}
			else if (rs.next()) {
				continue;
			}
			else {
				String title =  data.get(index).getTitle();
				sql = "INSERT INTO school(id, title) VALUES ('" + id + "','" + title +"')";
				dao.insert(sql);
				log.info(date.toString()+"：school表插入一条记录!"+ id + "...");
			}
		}
		
		dao.closeConnection();
		return ret;
	}
}
