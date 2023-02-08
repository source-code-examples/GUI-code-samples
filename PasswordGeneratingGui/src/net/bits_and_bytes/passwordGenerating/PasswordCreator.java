package net.bits_and_bytes.passwordGenerating;

import java.security.SecureRandom;

/*
 * Algorithm for generating random passwords.
 */
public class PasswordCreator {
	
	static StringBuilder createPassword(int pwSize) {
		SecureRandom secureRandom = new SecureRandom();
		// all possible characters for generating the password
		String possbileChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "1234567890!§$%&/=?*+,.-;:_<>\"\'\\~";	
		StringBuilder pwBuilder = new StringBuilder(pwSize);
		
		for (int i = 0; i < pwSize; i++) {
			// append the randomly determined characters to the StringBuilder
			pwBuilder.append(possbileChars.charAt(secureRandom.nextInt(possbileChars.length())));
		}
		
		return pwBuilder;
	}
}
