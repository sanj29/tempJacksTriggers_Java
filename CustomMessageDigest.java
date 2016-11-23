package test.messagedigest;

import java.security.MessageDigest;

public class CustomMessageDigest extends MessageDigest{

	protected CustomMessageDigest(String algorithm) {
		super(algorithm);
	}

	@Override
	protected void engineUpdate(byte input) {
	}

	@Override
	protected void engineUpdate(byte[] input, int offset, int len) {
	}

	@Override
	protected byte[] engineDigest() {
		return new byte[117];
	}

	@Override
	protected void engineReset() {
	}
}
