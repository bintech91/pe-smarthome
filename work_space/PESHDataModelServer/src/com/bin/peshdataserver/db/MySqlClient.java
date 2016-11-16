/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class MySqlClient {

	private static final Logger _Logger = Logger.getLogger(MySqlClient.class);
	private final String _host;
	private final int _port;
	private final String _dbname;
	private final String _user;
	private final String _password;
	private BlockingQueue<Connection> pool;
	private String url;
	private int _poolSize;

	public MySqlClient(String host, int port, String dbname, String user, String password, int poolSize) {
		_host = host;
		_port = port;
		_dbname = dbname;
		_user = user;
		_password = password;
		_poolSize = poolSize;
		init(_poolSize);
	}

	private boolean init(int poolsize) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://" + _host + ((_port > 0) ? (":" + _port) : "") + "/" + _dbname + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&interactiveClient=true&" + "&user=" + _user
					+ "&password=" + _password;

			BlockingQueue<Connection> cnnPool = new ArrayBlockingQueue<Connection>(poolsize);
			while (cnnPool.size() < poolsize) {
				cnnPool.add(DriverManager.getConnection(url));
			}
			pool = cnnPool;
			_Logger.info("MysqlClient init pool success");
		} catch (Exception ex) {
			_Logger.error(ex.getMessage(), ex);
			return false;
		}
		return true;
	}

	public Connection getDbConnection() {
		Connection conn = null;
		int retry = 0;
		do {
			try {
				conn = pool.poll(10000, TimeUnit.MILLISECONDS);
				if (conn == null || !conn.isValid(0)) {
					conn = DriverManager.getConnection(url);
				}
			} catch (Exception ex) {
				_Logger.warn(ex);
			}
			++retry;
		} while (conn == null && retry < 3);
		return conn;
	}

	public void releaseDbConnection(java.sql.Connection conn) {
		if (conn != null) {
			try {
				pool.add(conn);
			} catch (Exception ex) {
				_Logger.error(ex.getMessage(), ex);
			}
		}
	}

	public int updateData(Connection conn, String sql) {
		int error = 0;
		try {
			Statement statement = conn.createStatement();
			int er = statement.executeUpdate(sql);
			statement.close();
			return er;
		} catch (Exception ex) {
			_Logger.error(ex.getMessage(), ex);
		}
		return error;
	}
}
