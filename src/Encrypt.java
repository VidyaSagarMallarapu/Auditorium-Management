import java.io.*;
import java.util.*;
public class Encrypt {
	 public static void main(String[] args) {
		String m=encrypt("JNSNSJN SJBS ","JNSNSJN SJBS ");
		System.out.println(m);
		m=decrypt(m,"MAMA");
		System.out.println(m);
	}

	public static String encrypt(String plainText, String secretKey) {
		StringBuffer encryptedString = new StringBuffer();
		int encryptedInt;
		for (int i = 0; i < plainText.length(); i++) {
			int plainTextInt = (int) (plainText.charAt(i) - 'A');
			int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			encryptedInt = (plainTextInt + secretKeyInt) % 26;
			encryptedString.append((char) ((encryptedInt) + (int) 'A'));
		}
		return encryptedString.toString();
	}

	public static String decrypt(String decryptedText, String secretKey) {
		StringBuffer decryptedString = new StringBuffer();
		int decryptedInt;
		for (int i = 0; i < decryptedText.length(); i++) {
			int decryptedTextInt = (int) (decryptedText.charAt(i) - 'A');
			int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			decryptedInt = decryptedTextInt - secretKeyInt;
			if (decryptedInt < 1)
				decryptedInt += 26;
			decryptedString.append((char) ((decryptedInt) + (int) 'A'));
		}
		return decryptedString.toString();
	}
}