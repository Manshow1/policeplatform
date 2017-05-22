package com.ciii.police.dao;


import java.sql.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAO implements IDAO {
	private static Log log = LogFactory.getLog(DAO.class);
	private String driverName = "com.mysql.jdbc.Driver"; 
	private String dbURL = "jdbc:mysql://localhost:3306/policeplatform"; 
	private String userName = "litong";
	private String userPwd = "123456";
	private Connection dbConn; 
	private Statement stat;
		
	/*
	 * DAO构造函数
	 */
	public DAO() {			
		ConfigureReader reader = new ConfigureReader("com/ciii/police/dao/sql.properties");
		driverName = reader.getValue("db_connect_driverName");
		dbURL = reader.getValue("db_connect_url");
		String encoding = reader.getValue("db_connect_encoding");
		if (!encoding.isEmpty()) {
			dbURL += "?useUnicode=true&" + encoding;
		}
		userName = reader.getValue("db_connect_username");
		userPwd = reader.getValue("db_connect_password");
	}

	/*
	 * DAO构造函数，可以传参数修改连接方式和连接数据库
	 */
	public DAO(String driverName, String dbURL, String userName, String userPwd) {
		super();
		this.driverName = driverName;
		this.dbURL = dbURL;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	/*
	 * 删除数据,并返回删除的行数
	 */
	@Override
	public int delete(String sql) {
		int count = 0;
		try {
			Statement stmt = dbConn.createStatement();
			count = stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			log.error(e.getMessage() + ", sql=" + sql);
			return 0;
		}
		return count;
	}

	/*
	 * 获取数据集，使用完成后需要自己关闭数据集，失败返回null
	 */
	@Override
	public ResultSet getResultSet(String sql) {
		ResultSet rs = null;
		try {
			Statement stmt = dbConn.createStatement();
			rs = stmt.executeQuery(sql);	
		}
		catch (Exception e) {
			log.error(e.getMessage() + ", sql=" + sql);
			return null;
		}
		return rs;
	}

	/*
	 * 打开数据库连接
	 */
	@Override
	public boolean openConnection() {
		try { 
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);	
			//log.info("Connection Successful!" + this); //如果连接成功 控制台输出
		}
		catch (Exception e) {
			log.error("Connection Failed! error:" + e.getMessage());
			return false;
		}		
		return true;
	}

	/*
	 * 关闭数据库连接
	 */
	@Override
	public boolean closeConnection() {
		try{
			if (dbConn != null) {
				if (stat != null)
					stat.close();			
				dbConn.close();				
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	protected void finalize() throws Throwable {
		try{
			if (dbConn != null) {
				if (stat != null)
					stat.close();			
				dbConn.close();				
			}
			//log.info("Disconnect Connection!" + this);
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		super.finalize();
	}
	
	/*
	 * 插入数据，并返回插入数据索引
	 */
	@Override
	public int insert(String sql){
		int i = 1;	
		PreparedStatement pstat = null;
		try {
			pstat = dbConn.prepareStatement(sql, 
					Statement.RETURN_GENERATED_KEYS);
			pstat.executeUpdate();
			ResultSet rsTmp = pstat.getGeneratedKeys();
			if (rsTmp.next()) {
				i = rsTmp.getInt(1);
				log.info("AutoGenerateKey = " + i + ", sql=" + sql);
			}
			pstat.close();
		}
		catch (Exception e) {
			log.error(e.getMessage() + ", sql = " + sql);
			try {
				pstat.close();
			} 
			catch (SQLException e1) {
				log.error(e1.getMessage());
				return 0;
			}
			return 0;
		}
		return i;
	}

	/*
	 * 更新数据，并返回影响的行数
	 */
	@Override
	public int update(String sql) {
		int count = 0;
		try {
			Statement stmt = dbConn.createStatement();
			count = stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			log.error(e.getMessage() + ", sql=" + sql);
			return 0;
		}
		return count;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}	
	
	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}	

	public Statement getStat() {
		return stat;
	}

	public void setStat(Statement stat) {
		this.stat = stat;
	}
}
