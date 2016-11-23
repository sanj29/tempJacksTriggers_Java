package com.codiscope.jaks.triggers.java.staticVI;

import javax.crypto.spec.IvParameterSpec;

public class StaticVector {

	private static byte[] IV = new byte[4];
	//(byte)0,(byte)1,(byte)2,(byte)3};

	public void encrypt(String message) throws Exception {
	SecureRandom secureRandom = new SecureRandom();
	secureRandom.nextBytes(randomIV);
	    IvParameterSpec ivSpec = new IvParameterSpec(randomIV);
	    
}
}
