package net.bits_and_bytes.passwordManaging;

import java.awt.Color;

import net.bits_and_bytes.passwordManaging.graphicalUI.StarterGui;

public class PasswordManagingMain {

	public static void main(String[] args) {
		StarterGui basicGui = new StarterGui();
//		basicGui.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		basicGui.pack();
		basicGui.setVisible(true);
	}

}
