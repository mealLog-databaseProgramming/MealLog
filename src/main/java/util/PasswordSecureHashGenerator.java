package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordSecureHashGenerator {
	public static String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        StringBuilder builder = new StringBuilder();
        for (byte b : md.digest()) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
