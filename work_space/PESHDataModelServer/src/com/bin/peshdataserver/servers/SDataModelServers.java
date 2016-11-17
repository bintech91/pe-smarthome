/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.servers;

import com.bin.peshdataserver.common.servers.SerialServers;
import com.bin.peshdataserver.common.transport.TransportException;

/**
 *
 * @author tanpt
 */
public class SDataModelServers {

	public boolean setupAndStart() throws TransportException {
		SerialServers.Config config = new SerialServers.Config();
		config.appName = "";
		config.portName = "";
		config.baudRate = 9600;
		config.dataBits = 1;

		SerialServers servers = new SerialServers(config);
		return servers.start();
	}
}
