package testcode.crypto;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

public class DesKeyGeneration {

    public static void weakDesKeyGenerator() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator.getInstance("DES");
        KeyGenerator.getInstance("des");
        KeyGenerator.getInstance("DESede");
        KeyGenerator.getInstance("DESEDE");
        KeyGenerator.getInstance("DES",new DummyProvider());
        KeyGenerator.getInstance("des",new DummyProvider());
        KeyGenerator.getInstance("DESede",new DummyProvider());
        KeyGenerator.getInstance("DES", "SUN");
        KeyGenerator.getInstance("des", "SUN");
        KeyGenerator.getInstance("DESede", "SUN");
	Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    }

    static class DummyProvider extends Provider {

        protected DummyProvider() {
            super("dummy", 1.0, "");
        }
    }
}