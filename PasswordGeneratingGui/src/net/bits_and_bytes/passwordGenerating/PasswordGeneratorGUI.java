package net.bits_and_bytes.passwordGenerating;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

/*
 * Create the graphical user interface of the Password Generator.
 */
public class PasswordGeneratorGUI extends JFrame {
	private JTextField fieldPwResult;
	private JLabel labelIcon2;
	private JTextField fieldEnterPwSize;
	private JButton btnCreatePassword;
	private String iconCheckmark;

	// constructor to initialize
	public PasswordGeneratorGUI() {
		// default settings
		setResizable(false);
		setType(Type.UTILITY);
		setLocation(300, 200);
		setPreferredSize(new Dimension(600, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// GUI components		
		JLabel labelTitle = new JLabel("Password Generating");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setForeground(new Color(64, 126, 126));
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 32));
		labelTitle.setBounds(110, 36, 356, 52);
		getContentPane().add(labelTitle);
		
		JLabel labelEnterPwSize = new JLabel("Length of Password:");
		labelEnterPwSize.setForeground(new Color(64, 128, 128));
		labelEnterPwSize.setHorizontalAlignment(SwingConstants.CENTER);
		labelEnterPwSize.setFont(new Font("Sylfaen", Font.BOLD, 18));
		labelEnterPwSize.setBounds(180, 157, 171, 25);
		getContentPane().add(labelEnterPwSize);
		
		fieldEnterPwSize = new JTextField();
		fieldEnterPwSize.setForeground(new Color(94, 118, 236));
		fieldEnterPwSize.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		fieldEnterPwSize.setHorizontalAlignment(SwingConstants.CENTER);
		fieldEnterPwSize.setBounds(391, 151, 120, 30);
		fieldEnterPwSize.setToolTipText("The password must contain a minimum "
				+ "of 6 and a maximum of 20 characters.");
		getContentPane().add(fieldEnterPwSize);
		
		btnCreatePassword = new JButton("Create Password");
		btnCreatePassword.setForeground(new Color(64, 128, 128));
		btnCreatePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreatePassword.setBounds(274, 193, 160, 40);
		getContentPane().add(btnCreatePassword);
		
		JLabel labelPwResult = new JLabel("Password is:");
		labelPwResult.setHorizontalAlignment(SwingConstants.CENTER);
		labelPwResult.setForeground(new Color(64, 128, 128));
		labelPwResult.setFont(new Font("Sylfaen", Font.BOLD, 18));
		labelPwResult.setBounds(180, 279, 125, 25);
		getContentPane().add(labelPwResult);
		
		fieldPwResult = new JTextField();
		fieldPwResult.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		fieldPwResult.setForeground(new Color(94, 118, 236));
		fieldPwResult.setEditable(false);
		fieldPwResult.setToolTipText("the password must contain a minimum "
				+ "of 6 and a maximum of 20 characters.");
		fieldPwResult.setHorizontalAlignment(SwingConstants.CENTER);
		fieldPwResult.setBounds(310, 273, 200, 30);
		getContentPane().add(fieldPwResult);
		
		JLabel labelIcon = new JLabel();
		ImageIcon icon = new ImageIcon("..\\PasswordGeneratingGui\\src\\net\\"
				+ "bits_and_bytes\\passwordGenerating\\images\\dices.png");
		Image iconDice = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);	
		labelIcon.setIcon(new ImageIcon(iconDice));
		labelIcon.setBounds(29, 113, 125, 157);
		getContentPane().add(labelIcon);
		
		labelIcon2 = new JLabel("");
		labelIcon2.setIcon(new ImageIcon(""));
		labelIcon2.setBounds(514, 274, 31, 27);
		getContentPane().add(labelIcon2);
		
		// what happens after clicking the "Create Password" button
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pwSize = 0;
				try {
					pwSize = Integer.parseInt(fieldEnterPwSize.getText());	
					// the password should meet the following specifications, otherwise an 
					// error message appear in a new window
					if (pwSize < 6 || pwSize > 20) {
						JOptionPane.showMessageDialog(
							null, 
							"<html><body color='#606060'>The password must contain "
									+ "<span color='#339999'>more than 5</span> and "
									+ "<span color='#339999'>less than 21 characters"
									+ "</span>.</body></html>", 
							"Invalid number of characters", 
							JOptionPane.INFORMATION_MESSAGE
						);
					} else {
						// invoke the algorithm for generating the random password 
						String password = PasswordCreator.createPassword(pwSize).toString();
						fieldPwResult.setText(password);
		
						labelIcon2.setIcon(new ImageIcon("..\\PasswordGeneratingGui\\src\\net\\"
								+ "bits_and_bytes\\passwordGenerating\\images\\checkmark.gif"));
						fieldEnterPwSize.setEnabled(false);
						btnCreatePassword.setEnabled(false);
						
						// start thread for time limited animation and restrict access to the 
						// button and the input field for a limited time
						ThreadOne threadOne = new ThreadOne();
						threadOne.start();
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(
						null, 
						"<html><body color='#606060'>Please enter a <span color='#339999'>"
								+ "number</span>.</body></html>", 
						"Incorrect input", 
						JOptionPane.WARNING_MESSAGE
					);
				} 
				// make the input field for the password length empty 
				fieldEnterPwSize.setText("");
				// and place the cursor at a position in the input field
				fieldEnterPwSize.requestFocus();
			}
		});
	}
	
	class ThreadOne extends Thread {
		@Override
		public void run() {
	        try {
	        	// Limit animation to 4 seconds
				Thread.sleep(4000);
				labelIcon2.setIcon(new ImageIcon(""));
				fieldEnterPwSize.setEnabled(true);
				btnCreatePassword.setEnabled(true);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
