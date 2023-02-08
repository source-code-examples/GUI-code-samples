package net.bits_and_bytes.passwordManaging.graphicalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class StarterGui extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8405601804436453883L;
	private JPasswordField enterPwField;
	JButton openManagerBtn;
	JLabel iconLabel;
	String lockIcon = "C:\\Users\\jura7\\Downloads\\icons8-lock.gif";
	String errorIcon = "C:\\Users\\jura7\\Downloads\\attention (1).png";
	String errorIcon2 = "C:\\Users\\jura7\\Downloads\\icons8-error (3).gif";
	String disappSmileyIcon = "C:\\Users\\jura7\\Downloads\\icons8-disappointed.gif";
	int invalidPwCounter = 0;
	int invalidPwCounter2 = 0;
	public static String userName;

	public StarterGui() {
		setResizable(false);
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setTitle(" P a s s w o r d    M a n a g i n g");
		setPreferredSize(new Dimension(500, 300));
		setLocation(200, 300);

		getContentPane().setLayout(null);
		setType(Type.UTILITY);
//		setUndecorated(true);
		
		JLabel enterPwLabel = new JLabel("Enter password:");
		enterPwLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		enterPwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterPwLabel.setBounds(180, 117, 140, 20);
		getContentPane().add(enterPwLabel);
		
		enterPwField = new JPasswordField();
		enterPwField.setHorizontalAlignment(SwingConstants.CENTER);
		enterPwField.setBounds(110, 140, 270, 30);
		getContentPane().add(enterPwField);
		
		openManagerBtn = new JButton("Open");
		openManagerBtn.setToolTipText("Open the Password Manager Main Board");
		openManagerBtn.setBounds(110, 175, 85, 30);
		getContentPane().add(openManagerBtn);
		openManagerBtn.addActionListener( e -> {
			
			userName = "Mike";
			String password = "12345";
			var userInput = enterPwField.getPassword();
			String userPwInput = String.valueOf(userInput);
			
			if (userPwInput.equals(password)) {
				invalidPwCounter = 0;
				invalidPwCounter2 = 0;
				MainBoardGui mainBoardGui = new MainBoardGui();
				mainBoardGui.setVisible(true);
			} else {
				invalidPwCounter++;
				invalidPwCounter2++;
				iconLabel.setIcon(new ImageIcon(errorIcon));
				
				if (invalidPwCounter2 == 6) {
					JOptionPane.showMessageDialog(
						getFocusOwner(),
						"<html><body> You entered an<span color='#119999'> incorrect password</span> 6 times.<br> "
							+ "Therefore the<span color='#119999'> program is now terminated</span>.</body></html>", 
						"Too many fails!", 
						JOptionPane.PLAIN_MESSAGE, 
						new ImageIcon(disappSmileyIcon)
					);
					System.exit(0);
				} else if (invalidPwCounter == 3) {
					invalidPwCounter = 0;
					JOptionPane.showMessageDialog(
						getFocusOwner(), 
						"<html><body> You entered an<span color='#119999'> incorrect password</span> 3 times. "
							+ "<br>Try again in <span color='#119999'>20 seconds</span>.</body></html>", 
						"Too many fails!", 
						JOptionPane.PLAIN_MESSAGE, 
						new ImageIcon(errorIcon2)
					);	
					
					ThreadOne thread1 = new ThreadOne();
					enterPwField.setEnabled(false);
					openManagerBtn.setEnabled(false);
			        thread1.start();
				} else {
					JOptionPane.showMessageDialog(
						getFocusOwner(), 
						"<html><body>You entered an <span color='#119999'>Invalid Password</span>. Try again.</body<</html>", 
						"Failed attempt!", 
						JOptionPane.ERROR_MESSAGE				
					);
					iconLabel.setIcon(new ImageIcon(lockIcon));
				}
			}	
		});
		
		JButton exitManagerBtn = new JButton("Exit");
		exitManagerBtn.setToolTipText("Close the Password Manager ");
		exitManagerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitManagerBtn.setBounds(295, 175, 85, 30);
		getContentPane().add(exitManagerBtn);
		
		iconLabel = new JLabel("");
		iconLabel.setIcon(new ImageIcon(lockIcon));
		iconLabel.setBounds(161, 110, 23, 24);
		getContentPane().add(iconLabel);
		
		JLabel titleLabel = new JLabel("Password Managing");
		titleLabel.setForeground(new Color(64, 128, 128));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 28));
		titleLabel.setBounds(110, 30, 270, 52);
		getContentPane().add(titleLabel);		
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterPwField.setText("");
				enterPwField.requestFocus();
			}
		});
		resetBtn.setToolTipText("Open the Password Manager Main Board");
		resetBtn.setBounds(202, 175, 85, 30);
		getContentPane().add(resetBtn);
		
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(64, 128, 128), 2));
//		panel.setBounds(0, 0, 500, 300);
//		
//		getContentPane().add(panel);
	}
	
	class ThreadOne extends Thread {
		@Override
		public void run() {
	        try {
				Thread.sleep(20000);
				iconLabel.setIcon(new ImageIcon(lockIcon));
		    	enterPwField.setEnabled(true);
				openManagerBtn.setEnabled(true);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
