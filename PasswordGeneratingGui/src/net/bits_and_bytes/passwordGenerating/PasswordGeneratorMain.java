
/**
 * 
 * This program generates passwords. To do this, the user must enter 
 * the length of the password. The password length must meet certain 
 * specifications. The password is generated randomly.
 * 
 */

package net.bits_and_bytes.passwordGenerating;

public class PasswordGeneratorMain {

	public static void main(String[] args) {
		PasswordGeneratorGUI pwGenerator = new PasswordGeneratorGUI();
		pwGenerator.pack();
		pwGenerator.setVisible(true);
	}
}
