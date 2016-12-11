package com.codiscope.jaks.triggers.java.Des;


import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESedeInsecure {
	public static void main(String[] args) throws Exception {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
	    keyGenerator.init(128);
	    Key blowfishKey = keyGenerator.generateKey();

	    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	    keyPairGenerator.initialize(2048);
	    KeyPair keyPair = keyPairGenerator.genKeyPair();

	    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS1Padding");
	    
	    
	    cipher = Cipher.getInstance(" / /NoPadding"); 
	    
	    cipher = Cipher.getInstance("DES/ECB/NoPadding", " "); // 
	   //DES/CBC/PKCS5Padding
	    cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
	  }
}
