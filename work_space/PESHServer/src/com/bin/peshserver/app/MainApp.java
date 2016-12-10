/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.app;

import com.bin.peshserver.common.transport.TransportException;
import com.bin.peshserver.servers.HServers;
import com.bin.peshserver.servers.SServers;
import com.bin.peshserver.servers.TServers;

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
//		SServers sServers = new SServers();
//		if (!sServers.setupAndStart()) {
//			System.err.println("Could not start serial servers! Exit now.");
//			System.exit(1);
//		}

		///
		///serial servers
		///
		HServers hServers = new HServers();
		if (!hServers.setupAndStart()) {
			System.err.println("Could not start http servers! Exit now.");
			System.exit(1);
		}

		///
		///thrift servers
		///
		TServers tServers = new TServers();
		if (!tServers.setupAndStart()) {
			System.err.println("Could not start thrift servers! Exit now.");
			System.exit(1);
		}
	}

}
