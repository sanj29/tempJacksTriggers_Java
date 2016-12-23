package test.messagedigest;

import java.security.MessageDigest;

public class UseMessageDigest {

	public void testMessageDigest(String password){
		MessageDigest digest = MessageDigest.getInstance("SHA256");
		digest.update(password.getBytes());
	}
}
