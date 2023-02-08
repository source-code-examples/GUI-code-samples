package net.bits_and_bytes.passwordManaging.graphicalUI;

//import net.bits_and_bytes.passwordManaging.graphicalUI.StarterGui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainBoardGui extends JFrame {

	public MainBoardGui() {
		setTitle("P a s s w o r t    M a n a g i n g");
//		setLocation(getLocation());
		setLocation(720, 300);
		setPreferredSize(new Dimension(700, 500));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		pack();
		getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(150, 30, 250, 50);
		titleLabel.setText("Hello " + StarterGui.userName);
		getContentPane().add(titleLabel);
	}
}
