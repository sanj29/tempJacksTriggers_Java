import javax.net.ssl;
import javax.net.ssl.SSLSession;

class UnsafeCertPinning
{
    public static void main(String args[])
    {
	SSLSession foo = new SSLSession();
	foo.checkServerTrusted();
	foo.getPeerCertificates();
	foo.getPeerCertificateChain();
    }
}
