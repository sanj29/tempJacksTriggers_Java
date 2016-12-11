package com.codiscope.jaks.triggers.java.unsafecertPinning;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

class UnsafeCertPinning
{
    public static void main(String args[]) throws SSLPeerUnverifiedException
    {
    	SSLSocket serverPeer = null;
    	SSLSession session = serverPeer.getSession();
    	//SSLSession foo = new SSLSession();
    	//session.checkServerTrusted();
    	session.getPeerCertificates();
    	session.getPeerCertificateChain();
    }
}
