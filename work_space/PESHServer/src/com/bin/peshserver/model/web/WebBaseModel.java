/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin.peshserver.model.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author tanpt
 */
public abstract class WebBaseModel {

	private static final Logger LOGGER = Logger.getLogger(WebBaseModel.class);

	public abstract void processGet(HttpServletRequest req, HttpServletResponse resp);
	public abstract void processPost(HttpServletRequest req, HttpServletResponse resp);

	/**
	 * outAndClose: print data to client
	 *
	 * @param req
	 * @param resp
	 * @param content: String will be produced by content.toString()
	 * @return
	 */
	protected boolean outAndClose(HttpServletRequest req, HttpServletResponse resp, Object content) {
		boolean result = false;
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(content);
			result = true;
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage() + " while processing URI \"" + req.getRequestURI() + "?" + req.getQueryString() + "\"", ex);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return result;
	}

	/**
	 * prepareHeaderHtml: set http header for html content (text/html;
	 * charset=UTF-8)
	 *
	 * @param resp
	 */
	protected void prepareHeaderHtml(HttpServletResponse resp) {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
	}

	/**
	 * prepareHeaderJs: set http header for javascript content (text/javascript;
	 * charset=UTF-8)
	 *
	 * @param resp
	 */
	protected void prepareHeaderJs(HttpServletResponse resp) {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/javascript; charset=UTF-8");
	}
}
