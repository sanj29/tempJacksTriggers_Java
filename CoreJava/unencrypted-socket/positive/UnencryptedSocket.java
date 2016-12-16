package test.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class UnencryptedSocket {
	
	@SuppressWarnings({ "unused", "resource" })
	public void testUnencryptedSocket() throws UnknownHostException, IOException{
		Socket soc = new Socket("www.google.com",80);
	}

}
