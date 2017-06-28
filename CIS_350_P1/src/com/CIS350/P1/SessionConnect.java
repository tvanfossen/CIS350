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
	
	public String searchInput(String input)
	{
		
		
		return "0";
	}
}
