package io.swagger.interceptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Properties;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Signer {

	private static Signer instance = new Signer();
	private Properties prop = new Properties();

	private Logger logger = LoggerFactory.getLogger(Signer.class.getName());
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public static Signer getInstance() {
		return instance;
	}

	private Signer() {
		InputStream input = null;
		try {
			input = new FileInputStream(
					new File(Signer.class.getClassLoader().getResource("config.properties").getFile()));
			prop.load(input);
			privateKey = readPrivateKeyFromKeystore();
			publicKey = readPublicKeyFromKeystore();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String signPayload(String payload) {
		String signature = null;
		try {
			Signature signing = Signature.getInstance("SHA256withECDSA");
			signing.initSign(privateKey);
			signing.update(payload.getBytes());
			signature = Hex.encodeHexString(signing.sign(), true);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return signature;
	}

	public boolean verifyPayload(String payload, String signature) {
		boolean verify = false;
		Signature signing;
		try {
			byte[] signatureBytes = Hex.decodeHex(signature);
			signing = Signature.getInstance("SHA256withECDSA");
			signing.initVerify(publicKey);
			signing.update(payload.getBytes());
			verify = signing.verify(signatureBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return verify;
	}

	private PrivateKey readPrivateKeyFromKeystore() {
		PrivateKey ecKey = null;
		try {
			ClassLoader classLoader = Signer.class.getClassLoader();
			logger.debug("keystore_file:" + prop.getProperty("keystore_file"));
			File file = new File(classLoader.getResource(prop.getProperty("keystore_file")).getFile());
			FileInputStream inputStream = new FileInputStream(file);
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

			logger.debug("keystore_password:" + prop.getProperty("keystore_password"));

			keystore.load(inputStream, prop.getProperty("keystore_password").toCharArray());
			ecKey = (PrivateKey) keystore.getKey(prop.getProperty("privatekey_alias"),
					prop.getProperty("privatekey_password").toCharArray());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} finally {
		}
		return ecKey;
	}

	private PublicKey readPublicKeyFromKeystore() {
		PublicKey publicKey = null;
		ClassLoader classLoader = Signer.class.getClassLoader();
		logger.debug("truststore_file:" + prop.getProperty("truststore_file"));
		File file = new File(classLoader.getResource(prop.getProperty("truststore_file")).getFile());
		try {
			FileInputStream inputStream = new FileInputStream(file);
			KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
			truststore.load(inputStream, prop.getProperty("truststore_password").toCharArray());

			logger.debug("truststore_password:" + prop.getProperty("truststore_password"));

			Certificate certificate = truststore.getCertificate(prop.getProperty("publickey_alias"));
			publicKey = certificate.getPublicKey();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return publicKey;
	}
}
