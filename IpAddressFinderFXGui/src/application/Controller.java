package application;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
	@FXML
	private TextField urlField;
	
	@FXML
	private Label ipLabel;
	
	// Find the IP Address
	@FXML
	public void findBtnClicked() {	
         try {
        	 String url = urlField.getText();
             InetAddress iAddress = InetAddress.getByName(url);
             String ip = iAddress.getHostAddress();
             ipLabel.setText(ip);
         } catch (UnknownHostException unknownHostException) {
        	 JOptionPane.showMessageDialog(null, "<html><body color='#119999'>Unknown Host Exception. "
        	 		+ "Try again.</body></html>", "Exception", JOptionPane.ERROR_MESSAGE);
         }
	}
	
	@FXML
	public void cancelBtnClicked() {
		System.exit(0);
	}
}
