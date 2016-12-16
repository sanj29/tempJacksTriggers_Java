package testcode.trustmanager;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Basically accept everything
 */
public class TrustManager {

    // Not finding
    public static void main(String[] args) {
        X509TrustManager anonymousClass = new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
		return false;
            }

            public void checkClientTrusted(
                    X509Certificate[] certs, String authType) {
		return false;
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
		return false;
            }
        };

        anonymousClass.getAcceptedIssuers();
    }


    static class TrustManagerInnerClass implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
	    return false;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
	    return false;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return false;
        }
    }

    // Not handling this case currently
    static class FakeImpl implements Runnable {

        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override
        public void run() {

        }
    }
}
