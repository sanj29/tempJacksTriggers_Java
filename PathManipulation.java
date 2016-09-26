package com.codiscope.jaks.triggers.java.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathManipulation extends HttpServlet {
	 
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException{
	      File taintedFile = new File("/public/readonly/" + request.getParameter("file_name"));
	      FileInputStream fin = new FileInputStream(taintedFile);
	  }
	} 
