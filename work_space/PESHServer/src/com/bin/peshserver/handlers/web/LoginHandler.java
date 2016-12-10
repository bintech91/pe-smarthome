/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.handlers.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public class LoginHandler extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(LoginHandler.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processPost(req, resp);
	}

	private void processGet(HttpServletRequest req, HttpServletResponse resp) {

	}

	private void processPost(HttpServletRequest req, HttpServletResponse resp) {

	}
}
