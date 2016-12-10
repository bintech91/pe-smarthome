/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.model.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import sun.security.jca.GetInstance;

/**
 *
 * @author tanpt
 */
public class IndexModel extends WebBaseModel {

	private static final Logger LOGGER = Logger.getLogger(IndexModel.class);
	private static IndexModel _Instance = new IndexModel();

	private IndexModel() {
	}

	public static IndexModel getInstance() {
		if (_Instance == null) {
			_Instance = new IndexModel();
		}
		return _Instance;
	}

	@Override
	public void processPost(HttpServletRequest req, HttpServletResponse resp) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void processGet(HttpServletRequest req, HttpServletResponse resp) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
