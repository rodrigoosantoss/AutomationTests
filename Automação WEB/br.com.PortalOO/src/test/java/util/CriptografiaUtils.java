package util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Classe para Criptografia e descriptografia de chaves simetricas utilizando AES
 * 
 * @see <a href="https://docs.oracle.com/javase/6/docs/technotes/guides/security/SunProviders.html"> Java Cryptography
 *      Architecture Sun Providers Documentation </a>
 * 
 *      <br/>
 * 
 * @see <a href="https://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html"> Java Cryptography
 *      Architecture Standard Algorithm Name Documentation for JavaTM Platform Standard Edition 6 </a>
 * 
 *      <br/>
 *      <br/>
 * 
 *      Utiliza como algoritimo Cipher AES/CBC/PKCS5Padding
 * 
 *      <br/>
 *      <br/>
 * 
 * @author diomar.rockenbach
 *
 */
public class CriptografiaUtils implements Serializable {

	private static final long serialVersionUID = 6724072918853622210L;

	private final static String algoritmo = "AES";
	private static final String AES_TRANSFORMATION_MODE = "AES/CBC/PKCS5PADDING";

	public static String decrypt(String encrypted, String key) throws Exception {
		
		String decryptedText = "";

		if (encrypted == null || key == null)
	        return decryptedText;

	    try {
	    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), algoritmo);
	        //separate prefix with IV from the rest of encrypted data
	        byte[] encryptedPayload = Base64.decodeBase64(encrypted);
	        byte[] iv = new byte[16];
	        byte[] encryptedBytes = new byte[encryptedPayload.length - iv.length];

	        //populate iv with bytes:
	        System.arraycopy(encryptedPayload, 0, iv, 0, 16);

	        //populate encryptedBytes with bytes:
	        System.arraycopy(encryptedPayload, iv.length, encryptedBytes, 0, encryptedBytes.length);

	        Cipher decryptCipher = Cipher.getInstance(AES_TRANSFORMATION_MODE);
	        decryptCipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));

	        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);
	        decryptedText = new String(decryptedBytes);

	    } catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException | InvalidAlgorithmParameterException | InvalidKeyException e) {
	        e.printStackTrace();
	    }
	    
	    return decryptedText;
	}

	public static String encrypt(String data, String key) {
	    String encryptedText = "";

	    if (data == null || key == null)
	        return encryptedText;

	    try {
	    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	        Cipher encryptCipher = Cipher.getInstance(AES_TRANSFORMATION_MODE);
	        encryptCipher.init(Cipher.ENCRYPT_MODE, skeySpec, new SecureRandom());//new IvParameterSpec(getIV()) - if you want custom IV

	        //encrypted data:
	        byte[] encryptedBytes = encryptCipher.doFinal(data.getBytes("UTF-8"));

	        //take IV from this cipher
	        byte[] iv = encryptCipher.getIV();

	        //append Initiation Vector as a prefix to use it during decryption:
	        byte[] combinedPayload = new byte[iv.length + encryptedBytes.length];

	        //populate payload with prefix IV and encrypted data
	        System.arraycopy(iv, 0, combinedPayload, 0, iv.length);
	        System.arraycopy(encryptedBytes, 0, combinedPayload, iv.length, encryptedBytes.length);

	        encryptedText = Base64.encodeBase64String(combinedPayload);

	    } catch (NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException | UnsupportedEncodingException | InvalidKeyException e) {
	        e.printStackTrace();
	    }

	    return encryptedText;
	}
}
