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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MovieInfoPopup {

	JFrame infoFrame;
	JTextArea titleText = new JTextArea();
	JTextArea releaseText = new JTextArea();
	JTextArea descriptionText = new JTextArea();
	JTextArea crewText = new JTextArea();
	JLabel lblPoster = new JLabel();

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
		infoFrame.setBounds(100, 100, 1018, 702);
		//infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.getContentPane().setLayout(null);
		
		//JTextArea titleText = new JTextArea();
		titleText.setBounds(176, 11, 284, 22);
		infoFrame.getContentPane().add(titleText);
		
		//JTextArea releaseText = new JTextArea();
		releaseText.setBounds(176, 49, 284, 22);
		infoFrame.getContentPane().add(releaseText);
		
		//JTextArea descriptionText = new JTextArea();
		descriptionText.setBounds(663, 11, 312, 199);
		infoFrame.getContentPane().add(descriptionText);
		
		//JTextArea crewText = new JTextArea();
		crewText.setBounds(663, 241, 312, 399);
		infoFrame.getContentPane().add(crewText);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(45, 16, 121, 14);
		infoFrame.getContentPane().add(lblTitle);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setBounds(45, 54, 121, 14);
		infoFrame.getContentPane().add(lblReleaseDate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(547, 16, 106, 14);
		infoFrame.getContentPane().add(lblDescription);
		
		JLabel lblCrew = new JLabel("Crew");
		lblCrew.setBounds(572, 246, 81, 14);
		infoFrame.getContentPane().add(lblCrew);
		
		
		lblPoster.setBounds(55, 82, 491, 503);
		infoFrame.getContentPane().add(lblPoster);
		
	}
}
