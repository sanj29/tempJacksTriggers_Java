package test.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

public class EncryptedSocket {
	
	@SuppressWarnings("unused")
	public void testEncryptedSocket() throws UnknownHostException, IOException{
		Socket soc = SSLSocketFactory.getDefault().createSocket("www.google.com", 443);
	}
}
