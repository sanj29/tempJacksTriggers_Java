package com.codiscope.jaks.triggers.java.ErrorPage;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class ErrorHandling {
	HttpServletRequest request = null;

	public void test(HttpServletRequest request, HttpServletResponse response) {

		JspFactory factory = JspFactory.getDefaultFactory();
		PageContext pageContext = factory.getPageContext((Servlet) this, request,
				response, null, true, JspWriter.DEFAULT_BUFFER, true);
	}
}