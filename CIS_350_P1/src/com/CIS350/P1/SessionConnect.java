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
