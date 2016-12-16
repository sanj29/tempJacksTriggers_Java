import javax.net.ssl;
import javax.net.ssl.SSLSession;

class UnsafeCertPinning
{
    public static void main(String args[])
    {
	boolean safe = true;
	SSLSession foo = new SSLSession();
	for (int i = 0, size = peerCertificates.size(); i < size; i++) {
	    X509Certificate x509Certificate = peerCertificates.get(i); 
	    safe = safe && pins.contains(sha1(x509Certificate));
	}
	if (safe) {
	    // Do something safe
	} else {
	    // Be unsafe
	}
    }
}
