/** 
 * @author Tristan VanFossen & Mark Baker
 * 
 * Utility functions used by the various parts of the front end to obtain info
 * from the tmbdApi library
 */
package com.CIS350.P1;

import java.util.*;
import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.*;
import info.movito.themoviedbapi.model.config.*;
import info.movito.themoviedbapi.model.core.*;
import info.movito.themoviedbapi.model.people.*;

public class SessionConnect
{
	private static TmdbApi tmdbApi;
	private static SessionToken sessionToken;
	private TmdbMovies movies;
	
	/**
	 * 
	 * @return Returns account to grab user info from
	 */
	
	public Account getAccount()	
	{	//Returns the account to obtain default info for main screen
		TmdbAccount tmdbAccount = tmdbApi.getAccount();
		Account act = tmdbAccount.getAccount(sessionToken);
		return act;
	}
	
	/**
	 * 
	 * @return Returns the favorites list to be iterated through for the account tab of GUI
	 */
	public MovieResultsPage getFavorites()
	{	//Returns favorite movies of the logged in account
		AccountID actId = new AccountID(getAccount().getId());
		return tmdbApi.getAccount().getFavoriteMovies(sessionToken, actId);
	}
	
	/**
	 * 
	 * @param username string username
	 * @param password string password
	 * 
	 * Correct username/password entry creates the object otherwise the GUI login class will throw an exception/popup window
	 */
	public SessionConnect(String username, String password)
	{
		tmdbApi = new TmdbApi("ce49e03c06591fd406f5be8992cdd711");
		sessionToken = getSessionToken(username, password);		
	}
	
	/**
	 * 
	 * @param username 
	 * @param password
	 * @return Obtains the session token for user info in GUI
	 */
	private static SessionToken getSessionToken(String username, String password)
	{	
		TmdbAuthentication tmdbAuth = tmdbApi.getAuthentication();
		TokenSession tokenSession = tmdbAuth.getSessionLogin(username,password);
		SessionToken sessionToken = new SessionToken(tokenSession.getSessionId());
		
		return sessionToken;
	}
	/**
	 * 
	 * @param input keyword input for search
	 * @return if there is an input, return the movie results else return the top rated movies
	 * 
	 * TODO: update single keyword search to multi keyword search spanning cast/crew/etc
	 */
	
	public MovieResultsPage searchInput(String input)
	{
		if (input.length()>0){
			TmdbSearch tmdbSearch = tmdbApi.getSearch();
			return tmdbSearch.searchMovie(input, 0, "en", false, 0);
		} else {
			TmdbMovies tmdbMovies = tmdbApi.getMovies();
			return tmdbMovies.getTopRatedMovies("en",0);
		}
		
	}
}
