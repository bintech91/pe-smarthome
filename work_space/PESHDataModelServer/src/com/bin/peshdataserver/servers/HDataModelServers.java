/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshdataserver.servers;

import com.bin.peshdataserver.common.ThriftServers;
import org.apache.thrift.server.TThreadedSelectorServer;

/**
 *
 * @author tanpt
 */
public class HDataModelServers {
	public boolean setupAndStart() {
		ThriftServers.Config config = new ThriftServers.Config();
		config.acceptPolicy = TThreadedSelectorServer.Args.AcceptPolicy.FAST_ACCEPT;
		config.acceptQueueSizePerThread = 10;
		config.framed = true;

		ThriftServers servers = new ThriftServers(config);
		ZLinkService.Processor processor = new ZLinkService.Processor(new TZLinkServiceHandler());
		servers.setup(processor);
		return servers.start();
	}
}
