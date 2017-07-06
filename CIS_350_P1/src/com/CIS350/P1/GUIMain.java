package com.CIS350.P1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUIMain {

	JFrame mainFrame;
	private JTextField keyword;
	private JButton btnSearch;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 630, 587);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{26, 141, 86, 84, 94, 0};
		gridBagLayout.rowHeights = new int[]{109, 42, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSeachByKeyword = new JLabel("Seach by keyword:");
		GridBagConstraints gbc_lblSeachByKeyword = new GridBagConstraints();
		gbc_lblSeachByKeyword.fill = GridBagConstraints.VERTICAL;
		gbc_lblSeachByKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeachByKeyword.gridx = 1;
		gbc_lblSeachByKeyword.gridy = 1;
		mainFrame.getContentPane().add(lblSeachByKeyword, gbc_lblSeachByKeyword);
		
		keyword = new JTextField();
		GridBagConstraints gbc_keyword = new GridBagConstraints();
		gbc_keyword.insets = new Insets(0, 0, 5, 5);
		gbc_keyword.gridx = 2;
		gbc_keyword.gridy = 1;
		mainFrame.getContentPane().add(keyword, gbc_keyword);
		keyword.setColumns(10);
		
		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 1;
		mainFrame.getContentPane().add(btnSearch, gbc_btnSearch);
	
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 10;
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		mainFrame.getContentPane().add(list, gbc_list);
		
		btnSearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  SessionConnect newSession = new SessionConnect(GUILogin.usernameText.getText(), GUILogin.passwordText.getText());
				  ArrayList<String> temp = newSession.searchInput(keyword.getText());
				  
				  for (String i : temp)
					{
						
					}
					
			  } 
			} );
		
		
	}
}
