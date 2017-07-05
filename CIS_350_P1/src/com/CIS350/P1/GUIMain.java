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
	private JButton button_1_1;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_10;
	private JButton button_2_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
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
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 3;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		mainFrame.getContentPane().add(label, gbc_label);
		
		button_1_1 = new JButton("Information");
		GridBagConstraints gbc_button_1_1 = new GridBagConstraints();
		gbc_button_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1_1.gridx = 4;
		gbc_button_1_1.gridy = 2;
		mainFrame.getContentPane().add(button_1_1, gbc_button_1_1);
		
		label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 3;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		mainFrame.getContentPane().add(label_1, gbc_label_1);
		
		label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 4;
		mainFrame.getContentPane().add(label_2, gbc_label_2);
		
		button_1 = new JButton("Information");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 4;
		mainFrame.getContentPane().add(button_1, gbc_button_1);
		
		label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 5;
		mainFrame.getContentPane().add(label_3, gbc_label_3);
		
		button_2 = new JButton("Information");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 5;
		mainFrame.getContentPane().add(button_2, gbc_button_2);
		
		label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 6;
		mainFrame.getContentPane().add(label_4, gbc_label_4);
		
		button_3 = new JButton("Information");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 6;
		mainFrame.getContentPane().add(button_3, gbc_button_3);
		
		label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 7;
		mainFrame.getContentPane().add(label_5, gbc_label_5);
		
		button_4 = new JButton("Information");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 0);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 7;
		mainFrame.getContentPane().add(button_4, gbc_button_4);
		
		label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 8;
		mainFrame.getContentPane().add(label_6, gbc_label_6);
		
		button_5 = new JButton("Information");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.gridx = 4;
		gbc_button_5.gridy = 8;
		mainFrame.getContentPane().add(button_5, gbc_button_5);
		
		label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 9;
		mainFrame.getContentPane().add(label_7, gbc_label_7);
		
		button_6 = new JButton("Information");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 4;
		gbc_button_6.gridy = 9;
		mainFrame.getContentPane().add(button_6, gbc_button_6);
		
		label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 10;
		mainFrame.getContentPane().add(label_8, gbc_label_8);
		
		button_7 = new JButton("Information");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 0);
		gbc_button_7.gridx = 4;
		gbc_button_7.gridy = 10;
		mainFrame.getContentPane().add(button_7, gbc_button_7);
		
		label_9 = new JLabel("");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 1;
		gbc_label_9.gridy = 11;
		mainFrame.getContentPane().add(label_9, gbc_label_9);
		
		button_10 = new JButton("Information");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 0);
		gbc_button_10.gridx = 4;
		gbc_button_10.gridy = 11;
		mainFrame.getContentPane().add(button_10, gbc_button_10);

		button_2_1 = new JButton("Information");
		GridBagConstraints gbc_button_2_1 = new GridBagConstraints();
		gbc_button_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_2_1.gridx = 4;
		gbc_button_2_1.gridy = 3;
		mainFrame.getContentPane().add(button_2_1, gbc_button_2_1);
		
		SessionConnect newSession = new SessionConnect(GUILogin.usernameText.getText(), GUILogin.passwordText.getText());
		ArrayList<String> temp = newSession.searchInput(keyword.getText());
		String[] data = {};
		for (int i = 0; i< temp.size(); i++)
		{
			data[i] = temp.get(i);
		}
		list = new JList<String>(data);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 12;
		mainFrame.getContentPane().add(list, gbc_list);
		
		btnSearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
					
			  } 
			} );
		
		
	}
}
