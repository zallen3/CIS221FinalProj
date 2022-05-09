/*
Zachery Allen
CIS 221 - Tues/Thurs 2:10-4:00 PM
GUI Final Project
*/
//Importing all relevant items
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Class GUI implements the ActionListener at the bottom
public class GUI implements ActionListener {
	
	//Creation of Java swing variables to set in main
    private static JLabel label;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel fail;
    
    //Array list altered in action performed to hold usernames
    static ArrayList<String> userNames = new ArrayList<String>();
   
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//Creates file object from file, scanner to scan the file, and add the names to the userNames list
    	File file = new File("..\\CIS221FinalProj\\usernames.txt");
    	Scanner scan = new Scanner(file);
    	while (scan.hasNext()) {
	    	userNames.add(scan.nextLine());
	    	System.out.println(userNames);
	    }	
		
		scan.close();
    	
    	//Set Jframe and panel size, set close operation
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add panel(will be repeated for each object)
        frame.add(panel);

        panel.setLayout(null);
        
        //label next to username text field
        label = new JLabel("USER");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);
        
        //Text field for username
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        //label next to password text field
        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        //text field for password
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        //button to run the action of checking the username and password
        button = new JButton("LOGIN");
        button.setBounds(10, 100, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);
        
        //If login info is correct display this
        success = new JLabel("");
        success.setBounds(10, 120, 300, 25);
        panel.add(success);
        
        //If login is incorrect display this, Could not get working correctly
//        fail = new JLabel("");
//        fail.setBounds(10, 120, 300, 25);
//        panel.add(fail);

        frame.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//Set bottom text to blank when button is pressed again
    	success.setText("");
        //fail.setText(""); (couldn't get working)

        
        //Gets text from user and password textfields
        String user = userText.getText();
        String password = passwordText.getText();
        
        //Console test to see if read correctly
        System.out.println(user + ", " + password);
        
        //loop userNames when button is pressed, if both the name and password match show success and exit loop, else show fail text
        for(int i = 0; i < userNames.size(); i++) {
        	if (user.equals(userNames.get(i)) && password.equals("Password")) {
        		success.setText("LOGIN SUCCESSFUL");
        		break;
        	}        	
        }
    }
}


