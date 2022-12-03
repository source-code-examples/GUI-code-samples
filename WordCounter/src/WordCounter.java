
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * The program counts the words entered by the user. Numbers are counted as words. 
 */
public class WordCounter extends JFrame{

	private static final long serialVersionUID = 1L;

	//constructor
	public WordCounter() {
		setTitle(" W o r d    C o u n t e r");
		setLayout(null);
	    setBounds(300, 300, 600, 450);
	    setResizable(false);
		setUndecorated(true);
	    createGui();
	    setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}  
	
	//create and style the graphical user interface
    private void createGui() {
    	rootPane.setWindowDecorationStyle(1);
    	getContentPane().setBackground(new Color(190, 190, 190));
	    
    	JLabel label = new JLabel("Enter your text:");
    	label.setFont(new Font("arial black", 0, 13));
    	label.setBounds(50, 40, 120, 40);
	    
	    JTextArea textArea  = new JTextArea();
	    textArea.setBackground(new Color(220, 220, 220));
	    textArea.setFont(new Font("arial", 0, 14));
     
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 80, 500, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        JPanel panel =new JPanel();
        panel.setBounds(50, 300, 500, 40);
        panel.setLayout(new GridLayout(1, 3));
        panel.setBackground(new Color(190, 190, 190));
        JButton countBtn = new JButton("Count Words");
        countBtn.setBackground(new Color(140, 140, 140));
        countBtn.setForeground(Color.WHITE);
        countBtn.setFont(new Font("arial black", 0, 11));
        JLabel spaceLabel = new JLabel();
        JButton clearBtn = new JButton("Clear Screen");
        clearBtn.setBackground(new Color(140, 140, 140));
        clearBtn.setFont(new Font("arial black", 0, 11));
        clearBtn.setForeground(Color.WHITE);
        panel.add(countBtn);
        panel.add(spaceLabel);
        panel.add(clearBtn);
        
        add(label);
        add(scrollPane);
        add(panel);
        
        countBtn.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
			 	String textInput = textArea.getText();       
			 	int numOfWords = countWords(textInput);
			 	JOptionPane.showMessageDialog(rootPane, "<html><body color='gray'>The text countains<span color='#119999'> " 
			 			+ numOfWords + " words</span>.</body></html>", " Word Counter", JOptionPane.PLAIN_MESSAGE);
        	}
        });
        
        clearBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");			
			}
		});
	}
    
    //filter out the non-words and calculate the total number of words
	private static int countWords(String textInp) {
		if (textInp.isEmpty()) {
			return 0;
		} else {
			int numberOfWords = textInp.trim().split("[\\W{_}]+").length;
			return numberOfWords;
		}
	}
		

	public static void main(String[] args){
    	new WordCounter();
    }        
}

