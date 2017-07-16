/**
 * @author Tristan VanFossen & Mark Baker
 * 
 * 	Main page of search engine
 * 	Multiple tabs for account info and searchable movies
 * 	Single keyword search
 */

package com.CIS350.P1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.PersonCrew;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.awt.GridLayout;

public class GUIMain implements ListSelectionListener {

	JFrame mainFrame;
	private JTextField keyword;
	private JButton btnSearch;
	private JList<String> search_list;
	private DefaultListModel<String> searchListModel;
	private SessionConnect newSession = new SessionConnect(GUILogin.usernameText.getText(), GUILogin.passwordText.getText());
	private JTabbedPane tabbedPane;
	private JPanel search_panel;
	private JPanel account_favorites_panel;
	private JList account_favorites_list;
	private JButton btnMovieInformation;
	private JButton btnSearchInformation;
	private ArrayList<MovieDb> resultsList;

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
	 * 
	 * Creates multiple tabs and buttons to operate the various parts of the engine
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 913, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 897, 661);
		mainFrame.getContentPane().add(tabbedPane);
		
		search_panel = new JPanel();
		tabbedPane.addTab("Search", null, search_panel, null);
		GridBagLayout gbl_search_panel = new GridBagLayout();
		gbl_search_panel.columnWidths = new int[]{581, 57, 103, 0, 0};
		gbl_search_panel.rowHeights = new int[]{0, 402, 0};
		gbl_search_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_search_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		search_panel.setLayout(gbl_search_panel);
		
		JLabel lblSeachByKeyword = new JLabel("Seach by keyword:");
		GridBagConstraints gbc_lblSeachByKeyword = new GridBagConstraints();
		gbc_lblSeachByKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeachByKeyword.gridx = 1;
		gbc_lblSeachByKeyword.gridy = 0;
		search_panel.add(lblSeachByKeyword, gbc_lblSeachByKeyword);
		
		keyword = new JTextField();
		GridBagConstraints gbc_keyword = new GridBagConstraints();
		gbc_keyword.insets = new Insets(0, 0, 5, 5);
		gbc_keyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_keyword.gridx = 2;
		gbc_keyword.gridy = 0;
		search_panel.add(keyword, gbc_keyword);
		keyword.setColumns(10);
		
		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 0;
		search_panel.add(btnSearch, gbc_btnSearch);
		
		search_list = new JList<String>();
		searchListModel = new DefaultListModel<String>();
		search_list = new JList<String>(searchListModel);
		GridBagConstraints gbc_search_list = new GridBagConstraints();
		gbc_search_list.gridwidth = 4;
		gbc_search_list.anchor = GridBagConstraints.WEST;
		gbc_search_list.gridx = 0;
		gbc_search_list.gridy = 1;
		search_panel.add(search_list, gbc_search_list);
		search_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		search_list.setSelectedIndex(0);
		search_list.addListSelectionListener(this);
		search_list.setVisibleRowCount(5);
		
		search_list.addKeyListener(new KeyAdapter(){
			  public void keyPressed(KeyEvent ke){
			    if(ke.getKeyCode() == KeyEvent.VK_DOWN && search_list.getSelectedIndex() == searchListModel.getSize()-1)
			    {
			      ke.consume();
			      search_list.setSelectedIndex(0);
			    }}});
		
		account_favorites_panel = new JPanel();
		tabbedPane.addTab("Account Favorites", null, account_favorites_panel, null);
		GridBagLayout gbl_account_favorites = new GridBagLayout();
		gbl_account_favorites.columnWidths = new int[]{527, 131, 0};
		gbl_account_favorites.rowHeights = new int[]{40, 591, 0};
		gbl_account_favorites.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_account_favorites.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		account_favorites_panel.setLayout(gbl_account_favorites);
		
		account_favorites_list = new JList<String>();
		DefaultListModel favoriteListModel = new DefaultListModel<String>();
		account_favorites_list = new JList<String>(favoriteListModel);
		
		MovieResultsPage tempFavoritesList = newSession.getFavorites();
		ArrayList<MovieDb> favoritesArray = new ArrayList<MovieDb>();
		
		Iterator<MovieDb> iterator = tempFavoritesList.iterator();
		while (iterator.hasNext()) 
		{
			MovieDb movie = iterator.next();
			favoriteListModel.addElement(movie.getTitle()+";"+movie.getReleaseDate());
			
			favoritesArray.add(movie);
		}
		
		GridBagConstraints gbc_account_favorites_list = new GridBagConstraints();
		gbc_account_favorites_list.gridheight = 2;
		gbc_account_favorites_list.insets = new Insets(0, 0, 0, 5);
		gbc_account_favorites_list.fill = GridBagConstraints.BOTH;
		gbc_account_favorites_list.gridx = 0;
		gbc_account_favorites_list.gridy = 0;
		account_favorites_panel.add(account_favorites_list, gbc_account_favorites_list);
		
		btnMovieInformation = new JButton("Movie Information");
		btnMovieInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MovieInfoPopup infoPopup = new MovieInfoPopup();
					String temp [] = account_favorites_list.getSelectedValue().toString().split(";");
					for (MovieDb m : favoritesArray) {
						if (m.getTitle().equals(temp[0]) && m.getReleaseDate().equals(temp[1])) {
							MovieDb selectedMovie = m;
							String castString = new String();							
							String tempDescription = new String();
							String description = new String();													
							tempDescription = selectedMovie.getOverview();
							int textWidth = 50;
							
							for (int i = 1; i<tempDescription.length(); i++){
								if (i%textWidth == 0) {
									description += tempDescription.substring(i-textWidth, i) + '\n';
								}
							}
							
							List<PersonCrew> crew = selectedMovie.getCrew();
							if (crew == null) {
								castString = "Cast info not available for this movie";
								System.out.println("Cast info not available for this movie");
							} else {
								Iterator<PersonCrew> iterator = crew.iterator();
								while (iterator.hasNext()) {
									PersonCrew person = iterator.next();
									castString += person.getName() + " : " + person.getJob() + '\n';
								}
							}
														
							infoPopup.titleText.setText(selectedMovie.getTitle());
							infoPopup.releaseText.setText(selectedMovie.getReleaseDate());
							infoPopup.crewText.setText(castString);
							infoPopup.descriptionText.setText(description);
							System.out.println(selectedMovie.getTitle());
							System.out.println(selectedMovie.getPopularity());
						}
					}
					
					infoPopup.infoFrame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainFrame, "No Movie Selected");
				}
				
			}
		});
		GridBagConstraints gbc_btnMovieInformation = new GridBagConstraints();
		gbc_btnMovieInformation.insets = new Insets(0, 0, 5, 0);
		gbc_btnMovieInformation.gridx = 1;
		gbc_btnMovieInformation.gridy = 0;
		account_favorites_panel.add(btnMovieInformation, gbc_btnMovieInformation);
		
		btnSearchInformation = new JButton("Movie Information");
		btnSearchInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MovieInfoPopup infoPopup = new MovieInfoPopup();
					String temp [] = search_list.getSelectedValue().split(";");
					for (MovieDb m : resultsList) {
						if (m.getTitle().equals(temp[0]) && m.getReleaseDate().equals(temp[1])) {
							MovieDb selectedMovie = m;
							String castString = new String();							
							String tempDescription = new String();
							String description = new String();													
							tempDescription = selectedMovie.getOverview();
							int textWidth = 50;
							
							for (int i = 1; i<tempDescription.length(); i++){
								if (i%textWidth == 0) {
									description += tempDescription.substring(i-textWidth, i) + '\n';
								}
							}
							
							List<PersonCrew> crew = selectedMovie.getCrew();
							if (crew == null) {
								castString = "Cast info not available for this movie";
								System.out.println("Cast info not available for this movie");
							} else {
								Iterator<PersonCrew> iterator = crew.iterator();
								while (iterator.hasNext()) {
									PersonCrew person = iterator.next();
									castString += person.getName() + " : " + person.getJob() + '\n';
								}
							}
														
							infoPopup.titleText.setText(selectedMovie.getTitle());
							infoPopup.releaseText.setText(selectedMovie.getReleaseDate());
							infoPopup.crewText.setText(castString);
							infoPopup.descriptionText.setText(description);
							System.out.println(selectedMovie.getTitle());
							System.out.println(selectedMovie.getPopularity());
						}
					}
					
					infoPopup.infoFrame.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(mainFrame, "No Movie Selected");
				}
				
			}
		});
		GridBagConstraints gbc_btnSearchInformation = new GridBagConstraints();
		gbc_btnSearchInformation.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchInformation.gridx = 3;
		gbc_btnSearchInformation.gridy = 1;
		search_panel.add(btnSearchInformation, gbc_btnSearchInformation);
		
		btnSearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {

				 searchListModel.removeAllElements();
				 
				 MovieResultsPage results = newSession.searchInput(keyword.getText());
				 resultsList = new ArrayList<MovieDb>();
				 Iterator<MovieDb> iterator = results.iterator();
				 while (iterator.hasNext()) {
					 MovieDb movie = iterator.next();
					 searchListModel.addElement(movie.getTitle()+';'+movie.getReleaseDate());
					 resultsList.add(movie);
				 }
			 
				 keyword.requestFocusInWindow();
				 keyword.setText("");
					
			  } 
			} );
			
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
