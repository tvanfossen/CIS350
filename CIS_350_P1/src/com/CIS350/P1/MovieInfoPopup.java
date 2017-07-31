package com.CIS350.P1;

/**
 * @author Tristan VanFossen & Mark Baker
 * 
 * Used to display specific movie information after a button is pressed on the GUIMain page
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class MovieInfoPopup {

	JFrame infoFrame;
	JTextArea titleText = new JTextArea();
	JTextArea releaseText = new JTextArea();
	JTextArea descriptionText = new JTextArea();
	JTextArea crewText = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieInfoPopup window = new MovieInfoPopup();
					window.infoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieInfoPopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * Creates various parts of GUI, text areas can be updated as needed to display correct info
	 */
	private void initialize() {
		infoFrame = new JFrame();
		infoFrame.setBounds(100, 100, 750, 400);
		//infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.getContentPane().setLayout(null);
		
		//JTextArea titleText = new JTextArea();
		titleText.setBounds(86, 49, 112, 22);
		infoFrame.getContentPane().add(titleText);
		
		//JTextArea releaseText = new JTextArea();
		releaseText.setBounds(86, 77, 112, 22);
		infoFrame.getContentPane().add(releaseText);
		
		//JTextArea castText = new JTextArea();
		crewText.setBounds(58, 110, 224, 400);
		infoFrame.getContentPane().add(crewText);
		
		//JTextArea crewText = new JTextArea();
		descriptionText.setBounds(380, 110, 450, 400);
		infoFrame.getContentPane().add(descriptionText);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 54, 66, 14);
		infoFrame.getContentPane().add(lblTitle);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setBounds(10, 82, 74, 14);
		infoFrame.getContentPane().add(lblReleaseDate);
		
		JLabel lblCast = new JLabel("Crew");
		lblCast.setBounds(10, 115, 46, 14);
		infoFrame.getContentPane().add(lblCast);
		
		JLabel lblCrew = new JLabel("Description");
		lblCrew.setBounds(292, 115, 78, 14);
		infoFrame.getContentPane().add(lblCrew);
	}
}
