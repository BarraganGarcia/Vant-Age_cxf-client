package io.swagger.interceptor;

public class VerifyingSignatureException extends RuntimeException {

	private static final long serialVersionUID = -7207636115095691756L;

	public VerifyingSignatureException(String message) {
		super(message);

	}
}