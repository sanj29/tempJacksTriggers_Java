package com.codiscope.jaks.triggers.java.ErrorPage;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/*
 Rule:
 <Rule id="CIGITAL-JAVA-ERROR-HANDLING" lang="java">
 <Category>Error Handling</Category>
 <Title>Error Page</Title>
 <Description>Specify error page so that an application can reveal as little information as possible.</Description>
 <Match>
 <QualifiedName>javax.servlet.jsp.JspFactory</QualifiedName>
 <Method>getPageContext</Method>
 <Argument value="null" comparator="equals" type="String">3</Argument>
 </Match>
 <Standards>
 <Standard file="java-error-handling-page-context.xml">
 <Context>J2EE</Context>
 </Standard>
 </Standards>
 </Rule>
 */
public class ErrorHandling {
	HttpServletRequest request = null;

	public void test(HttpServletRequest request, HttpServletResponse response) {

		JspFactory factory = JspFactory.getDefaultFactory();
		PageContext pageContext = factory.getPageContext((Servlet) this, request,
				response, null, true, JspWriter.DEFAULT_BUFFER, true);
	}
}
