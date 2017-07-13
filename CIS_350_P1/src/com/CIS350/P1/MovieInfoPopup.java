package com.CIS350.P1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MovieInfoPopup {

	JFrame infoFrame;
	JTextArea titleText = new JTextArea();
	JTextArea releaseText = new JTextArea();
	JTextArea castText = new JTextArea();
	JTextArea descriptionText = new JTextArea();

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
	 */
	private void initialize() {
		infoFrame = new JFrame();
		infoFrame.setBounds(100, 100, 700, 300);
		//infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.getContentPane().setLayout(null);
		
		//JTextArea titleText = new JTextArea();
		titleText.setBounds(86, 49, 112, 22);
		infoFrame.getContentPane().add(titleText);
		
		//JTextArea releaseText = new JTextArea();
		releaseText.setBounds(86, 77, 112, 22);
		infoFrame.getContentPane().add(releaseText);
		
		//JTextArea castText = new JTextArea();
		castText.setBounds(86, 110, 112, 124);
		infoFrame.getContentPane().add(castText);
		
		//JTextArea crewText = new JTextArea();
		descriptionText.setBounds(285, 110, 350, 124);
		infoFrame.getContentPane().add(descriptionText);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 54, 66, 14);
		infoFrame.getContentPane().add(lblTitle);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setBounds(10, 82, 74, 14);
		infoFrame.getContentPane().add(lblReleaseDate);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setBounds(10, 115, 46, 14);
		infoFrame.getContentPane().add(lblCast);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(208, 115, 46, 14);
		infoFrame.getContentPane().add(lblDescription);
	}
}
