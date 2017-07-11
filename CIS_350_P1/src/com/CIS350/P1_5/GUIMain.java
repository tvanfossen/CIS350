package src.com.CIS350.P1_5;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
>>>>>>> refs/remotes/origin/GUI3

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
<<<<<<< HEAD
=======

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

>>>>>>> refs/remotes/origin/GUI3
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
<<<<<<< HEAD

import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.*;
import info.movito.themoviedbapi.model.config.*;
import info.movito.themoviedbapi.model.core.*;
import info.movito.themoviedbapi.model.people.*;
import java.util.*;
=======
import java.awt.GridLayout;
>>>>>>> refs/remotes/origin/GUI3

public class GUIMain implements ListSelectionListener {

	JFrame mainFrame;
	private JTextField keyword;
	private JButton btnSearch;
<<<<<<< HEAD
	private JButton btnGrabMovie;
	private JList list;
	private DefaultListModel<String> listModel;
	private SessionConnect newSession = new SessionConnect(GUILogin.usernameText.getText(), GUILogin.passwordText.getText());
=======
	private JList<String> search_list;
	private DefaultListModel<String> searchListModel;
	private SessionConnect newSession = new SessionConnect(GUILogin.usernameText.getText(), GUILogin.passwordText.getText());
	private JTabbedPane tabbedPane;
	private JPanel search_panel;
	private JPanel account_favorites_panel;
	private JList account_favorites_list;
	private JButton btnMovieInformation;
>>>>>>> refs/remotes/origin/GUI3

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
		mainFrame.setBounds(100, 100, 913, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{26, 141, 86, 84, 94, 0};
		gridBagLayout.rowHeights = new int[]{109, 42, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSeachByKeyword = new JLabel("Seach by keyword:");
		GridBagConstraints gbc_lblSeachByKeyword = new GridBagConstraints();
		gbc_lblSeachByKeyword.fill = GridBagConstraints.VERTICAL;
		gbc_lblSeachByKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeachByKeyword.gridx = 1;
		gbc_lblSeachByKeyword.gridy = 1;
		mainFrame.getContentPane().add(lblSeachByKeyword, gbc_lblSeachByKeyword);
=======
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
>>>>>>> refs/remotes/origin/GUI3
		
		keyword = new JTextField();
		GridBagConstraints gbc_keyword = new GridBagConstraints();
		gbc_keyword.insets = new Insets(0, 0, 5, 5);
<<<<<<< HEAD
		gbc_keyword.gridx = 2;
		gbc_keyword.gridy = 1;
		mainFrame.getContentPane().add(keyword, gbc_keyword);
=======
		gbc_keyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_keyword.gridx = 2;
		gbc_keyword.gridy = 0;
		search_panel.add(keyword, gbc_keyword);
>>>>>>> refs/remotes/origin/GUI3
		keyword.setColumns(10);
		
		btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
<<<<<<< HEAD
		gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 1;
		mainFrame.getContentPane().add(btnSearch, gbc_btnSearch);
		
		btnGrabMovie = new JButton("Grab Movie");
		GridBagConstraints gbc_btnGrabMovie = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 2;
		mainFrame.getContentPane().add(btnGrabMovie, gbc_btnGrabMovie);
		
		list = new JList();
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list.setSelectedIndex(0);
	    list.addListSelectionListener(this);
	    list.setVisibleRowCount(5);
	    //JScrollPane listScrollPane = new JScrollPane(list);
	    
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 7;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		mainFrame.getContentPane().add(list, gbc_list);
		
		ArrayList<MovieDb> curList = new ArrayList<MovieDb>();
		
		btnSearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				 listModel.removeAllElements();
				 curList.clear();
				 MovieResultsPage temp = newSession.searchInput(keyword.getText());
				 
				 Iterator<MovieDb> iterator = temp.iterator();
				 while (iterator.hasNext()) {
				 	MovieDb movie = iterator.next();
				 	curList.add(movie);
				 	listModel.addElement(movie.getTitle());
				 }	
				 
				 keyword.requestFocusInWindow();
				 keyword.setText("");
					
			  }
			} );
		
		btnGrabMovie.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				 MovieDb temp = new MovieDb();
				 for (MovieDb m : curList) {
					 if (m.getTitle().equals(list.getSelectedValue())){
						 temp = m;
						 break;
					 }
				 }
				 
				 System.out.println(temp.getPopularity());
			  }
=======
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
			favoriteListModel.addElement(movie.getTitle()+","+movie.getReleaseDate());
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
				
			}
		});
		GridBagConstraints gbc_btnMovieInformation = new GridBagConstraints();
		gbc_btnMovieInformation.insets = new Insets(0, 0, 5, 0);
		gbc_btnMovieInformation.gridx = 1;
		gbc_btnMovieInformation.gridy = 0;
		account_favorites_panel.add(btnMovieInformation, gbc_btnMovieInformation);
		
		btnSearch.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {

				 searchListModel.removeAllElements();
				 
				 ArrayList<String> temp = newSession.searchInput(keyword.getText());
				 
				 for (String i : temp) {
					 int index = search_list.getSelectedIndex();
					 if( index == -1 ) {
						 index = 0;
					 } else {
						 index++;
					 }
					 
					 searchListModel.insertElementAt(i, index);
				 }
				 
				 keyword.requestFocusInWindow();
				 keyword.setText("");
					
			  } 
>>>>>>> refs/remotes/origin/GUI3
			} );
			
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
