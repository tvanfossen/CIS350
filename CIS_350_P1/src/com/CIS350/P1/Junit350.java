package com.CIS350.P1;

import static org.junit.Assert.*;

import org.junit.Test;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class Junit350 {
	
	public static void main (String args[]) {
	}
	@Test
	public void testSessionConnect() {
		SessionConnect testSession = new SessionConnect("tvanfossen", "Targaryen!23");
		if (testSession.getSessionToken("tvanfossen", "Targaryen!23") == null) {
			fail("Does not login");
		} else {
			assert(true);
		}
		
		if (testSession.getAccount().getUserName() != "tvanfossen") {
			fail("Does not have correct username");
		} else {
			assert(true);
		}
	}
	
	@Test
	public void testFavorites() {
		SessionConnect testSession = new SessionConnect("tvanfossen", "Targaryen!23");
		
		MovieResultsPage test = testSession.getFavorites();
		
		for (MovieDb i : test) {
			if (i.getTitle() != "Wonder Woman") {
				if (i.getTitle() != "Logan") {
					if (i.getTitle() != "Dawn of the Planet of the Apes") {
						if (i.getTitle() != "Beauty and the Beast") {
							fail("Wrong favorites list");
						}
					}
				}
			}
		}
		
		assert(true);
	}
	
	@Test
	public void testSearch() {
		SessionConnect testSearch = new SessionConnect("tvanfossen", "Targaryen!23");
		
		MovieResultsPage test = testSearch.searchInput("ghost");
		boolean temp = false;
		
		for (MovieDb i : test) {
			if (i.getTitle() == "Ghost in the Shell") {
				temp = true;
			}
		}
		
		if (!temp) {
			fail("Not in list");
		} else {
			assert(true);
		}
		
	}
	
	
	@Test
	public void testPopup() {
		try {
			MovieInfoPopup temp = new MovieInfoPopup();
		}
		catch (Exception e) {
			fail("Didnt initialize");
		}
		
		assert(true);
	}
	
	@Test
	public void testLogin() {
		try {
			GUILogin temp = new GUILogin();
		}
		catch(Exception e) {
			fail ("Didnt initialize");
		}
		
		assert(true);
	}
	
	@Test
	public void testMainScreen() {
		try {
			GUIMain temp = new GUIMain();
		}
		catch (Exception e)
		{
			fail ("Didnt initialize");
		}
		
		assert(true);
	}
}
