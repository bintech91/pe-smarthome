/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.app;

import com.bin.peshdataserver.common.transport.TransportException;
import com.bin.peshdataserver.servers.HDataModelServers;
import com.bin.peshdataserver.servers.SDataModelServers;
import com.bin.peshdataserver.servers.TDataModelServers;

/**
 *
 * @author tanpt
 */
public class MainApp {

	public static void main(String[] args) throws TransportException {
		// TODO code application logic here
		///
		///serial servers
		///
		SDataModelServers sDataModelServers = new SDataModelServers();
		if (!sDataModelServers.setupAndStart()) {
			System.err.println("Could not start serial servers! Exit now.");
			System.exit(1);
		}

		///
		///serial servers
		///
		HDataModelServers hDataModelServers = new HDataModelServers();
		if (!hDataModelServers.setupAndStart()) {
			System.err.println("Could not start http servers! Exit now.");
			System.exit(1);
		}

		///
		///thrift servers
		///
		TDataModelServers tDataModelServers = new TDataModelServers();
		if (!tDataModelServers.setupAndStart()) {
			System.err.println("Could not start thrift servers! Exit now.");
			System.exit(1);
		}
	}

}
