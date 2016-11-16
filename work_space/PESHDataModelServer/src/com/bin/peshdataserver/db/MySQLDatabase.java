/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.db;

import java.sql.Connection;

/**
 *
 * @author tanpt
 */
public class MySQLDatabase {

	public static final MySQLDatabase Instance = new MySQLDatabase();

	private MySqlClient _mySqlCli;

	private MySQLDatabase() {
		_mySqlCli = new MySqlClient("host", 1234 /* port */, "dbname", "user", "password", 10 /* poolSize */);
	}

	public Connection getDbConnection() {
		return _mySqlCli.getDbConnection();
	}

	public void releaseDbConnection(java.sql.Connection conn) {
		_mySqlCli.releaseDbConnection(conn);
	}

	public int updateData(Connection conn, String sql) {
		return _mySqlCli.updateData(conn, sql);
	}
}
