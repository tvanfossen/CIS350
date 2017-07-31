/**
 * @author Tristan VanFossen & Mark Baker
 *
 *	GUI login function. Creates page to input login/password info
 */

package com.CIS350.P1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class GUILogin {

	private JFrame frame;
	public static JPasswordField passwordText;
	public static JTextField usernameText;
	public static JLabel title;
	private static GUILogin window = new GUILogin();

	/**
	 * Launch the application.
	 * 
	 * @exception e prevents errors
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GUILogin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws excep in case of of invalid login info
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(244, 164, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(148, 165, 86, 20);
		frame.getContentPane().add(passwordText);
		passwordText.setColumns(10);
		
		usernameText = new JTextField();
		usernameText.setBounds(148, 139, 86, 20);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		title = new JLabel("Forgot the Movie?");
		title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		title.setBounds(131,42,122,32);
		frame.getContentPane().add(title);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(65, 139, 71, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 166, 73, 18);
		frame.getContentPane().add(lblPassword);
		
		btnEnter.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  
				  try {
					  SessionConnect newSession = new SessionConnect(usernameText.getText(), passwordText.getText());
					  GUIMain mainWindow = new GUIMain();
					  mainWindow.mainFrame.setVisible(true);
					  window.frame.setVisible(false);
				  } catch (Exception excep) {
					  JOptionPane.showMessageDialog(frame, "Invalid Login");
				  }
			  } 
			} );
	}
}



