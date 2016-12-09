package testcode.crypto;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

public class DesKeyGeneration {

    public static void weakDesKeyGenerator() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator.getInstance("AES"); //OK!
        KeyGenerator.getInstance("RSA"); //OK!
	Cipher cipher2 = Cipher.getInstance("NotDesLawl");
    }

    static class DummyProvider extends Provider {

        protected DummyProvider() {
            super("dummy", 1.0, "");
        }
    }
}
