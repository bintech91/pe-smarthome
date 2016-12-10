/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.servers;

import com.bin.peshserver.common.servers.WebServers;
import com.bin.peshserver.common.servers.WebServers.Config;
import com.bin.peshserver.handlers.web.IndexHandler;
import com.bin.peshserver.handlers.web.LoginHandler;
import com.bin.peshserver.handlers.web.LogoutHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 *
 * @author tanpt
 */
public class HServers {

	public boolean setupAndStart() {
		Config config = new WebServers.Config();

		WebServers servers = new WebServers(config);
		//session
		ServletContextHandler serCtxHandler = new ServletContextHandler();
		serCtxHandler.setSessionHandler(new SessionHandler());

		//page
		serCtxHandler.addServlet(IndexHandler.class, "/");
		serCtxHandler.addServlet(LoginHandler.class, "/login");
		serCtxHandler.addServlet(LogoutHandler.class, "/logout");

		//static resource
		ContextHandler ctxHandler = new ContextHandler("/stc");
		ctxHandler.setResourceBase("static");
		ctxHandler.setHandler(new ResourceHandler());

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[]{ctxHandler, serCtxHandler});
		servers.setup(handlers);
		return servers.start();
	}
}
