package com.ciii.police.dao;

import java.sql.ResultSet;

public interface IDAO {
	abstract int delete(String sql);
	abstract int update(String sql);
	abstract ResultSet getResultSet(String sql);
	abstract boolean openConnection();
	abstract boolean closeConnection();
	abstract int insert(String sql);
}
