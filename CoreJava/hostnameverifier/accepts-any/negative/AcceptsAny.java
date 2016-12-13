package testcode.trustmanager;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Basically accept everything
 */
public class AcceptsAny {

    // Not finding

    public static void main(String[] args) {
        HostnameVerifier anonymousClass = new HostnameVerifier() {
		public boolean verify(final String hostname, final SSLSession session) {
		    return true;
		}
        };
    }


    static class InnerVerifier implements HostnameVerifier {
        public boolean verify(final String hostname, final SSLSession session) {
            return true;
        }

    }

    // Not handling this case currently
    static class FakeImpl implements Runnable {

        public boolean verify(final String hostname, final SSLSession session) {
            return true;
        }
    }
}
