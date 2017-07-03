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
	
	public Account getAccount()	
	{	//Returns the account to obtain default info for main screen
		TmdbAccount tmdbAccount = tmdbApi.getAccount();
		Account act = tmdbAccount.getAccount(sessionToken);
		return act;
	}
	
	public MovieResultsPage getFavorites()
	{	//Returns favorite movies of the logged in account
		AccountID actId = new AccountID(getAccount().getId());
		return tmdbApi.getAccount().getFavoriteMovies(sessionToken, actId);
	}
	
	public SessionConnect(String username, String password)
	{
		tmdbApi = new TmdbApi("ce49e03c06591fd406f5be8992cdd711");
		sessionToken = getSessionToken(username, password);		
	}
	
	private static SessionToken getSessionToken(String username, String password)
	{	
		TmdbAuthentication tmdbAuth = tmdbApi.getAuthentication();
		TokenSession tokenSession = tmdbAuth.getSessionLogin(username,password);
		SessionToken sessionToken = new SessionToken(tokenSession.getSessionId());
		
		return sessionToken;
	}
	
	public ArrayList searchInput(String input)
	{
		ArrayList<String> output = new ArrayList<String>();
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		MovieResultsPage results = tmdbSearch.searchMovie(input, 0, "en", false, 0);
		
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) 
		{
			MovieDb movie = iterator.next();
			String temp = new String();
			
			temp += (movie.getTitle() + ',' + movie.getOriginalTitle() + ',' + movie.getReleaseDate());
			
			output.add(temp);
		}	
		
		return output;
	}
}
