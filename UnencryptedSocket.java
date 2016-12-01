package com.codiscope.jaks.triggers.java.UnencryptedSocket;

import java.io.IOException;
import java.net.Socket;

import javax.net.ssl.SSLSocketFactory;

public class UnencryptedSocket {

	public static void main(String[] args) throws IOException {
		
		Socket soc = new Socket("www.google.com",80);	
		soc = SSLSocketFactory.getDefault().createSocket("www.google.com", 443);
	}
	
}
