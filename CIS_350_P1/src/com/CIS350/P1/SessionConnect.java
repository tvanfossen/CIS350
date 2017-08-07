package com.CIS350.P1;

import java.util.*;
import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.model.*;
import info.movito.themoviedbapi.model.config.*;
import info.movito.themoviedbapi.model.core.*;
import info.movito.themoviedbapi.model.keywords.Keyword;
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
	
	public SessionToken getSessionToken(String username, String password)
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
	
	public ArrayList<MovieDb> multiKeywordSearch (String input) {
		
		System.out.println("SEARCHING FOR: " + input);
		String [] splitInput = input.split(" ");
		ArrayList<MovieDb> finResults = new ArrayList<MovieDb>();
		ArrayList<MovieDb> results = new ArrayList<MovieDb>();
		ArrayList<MovieDb> initResults = new ArrayList<MovieDb>();
		ArrayList<Keyword> kwl = new ArrayList<Keyword>();
		
		if (splitInput.length>0) {
			TmdbSearch tmbdSearch = tmdbApi.getSearch();
			TmdbMovies tmdbMovies = tmdbApi.getMovies();
			TmdbPeople tmbdPeople = tmdbApi.getPeople();
			
			
			for (String i : splitInput) { // Provides an initial list of search keywords to find movies relating
				for (Keyword j : tmbdSearch.searchKeyword(i, 0)) {
					System.out.println(j.getName());
					kwl.add(j);
				}
				for (Keyword j : tmbdSearch.searchKeyword(input, 0)) {
					System.out.println(j.getName());
					kwl.add(j);
				}
				for (Person j : tmbdSearch.searchPerson(i, false, 0)) {
					System.out.println(j.getName());
					for (PersonCredit p : tmbdPeople.getPersonCredits(j.getId()).getCast()) {
						System.out.println("\t" + tmdbMovies.getMovie(p.getMovieId(), "en", null).getTitle());
						initResults.add(tmdbMovies.getMovie(p.getMovieId(), "en", null));
					}
				}
			}
			System.out.println("KEYWORD LIST FINISHED");
			
			
			System.out.println("SEARCHED POSSIBLE ACTORS");
			
			
			
			for (Keyword i : kwl) { // Provides a large list of all movies relating to keyword input
				for (MovieDb j : tmbdSearch.searchMovie(i.getName(), 0, "en", false, 0)) {
					initResults.add(j);
				}
			}
			for (MovieDb j : tmbdSearch.searchMovie(input, 0, "en", false, 0)) {
				initResults.add(j);
			}
			
			System.out.println("INIT MOVIE LIST FINISHED");
			int maxCount = 0;
			for (MovieDb i : initResults) {
				int matches = 0;
				int count = 0;
				for (MovieDb j : initResults) {
					if (j.getTitle().toLowerCase().equals(i.getTitle().toLowerCase()) && j.getReleaseDate().equals(i.getReleaseDate())) {
						count++;
					}
				}
				
				
				String [] splitDesc = null;
				if (i.getOverview() != null) {
					splitDesc = i.getOverview().split(" ");
				}
				
				if (splitDesc != null) {
					for (Keyword j : kwl) { //Look for matches in description with keywords
						for (String k : splitDesc) {
							if (j.getName().toLowerCase().equals(k.toLowerCase())) {
								matches++;
							}
						}
					}
				}
				
				if (i.getGenres() != null) {
					for (String j : splitInput) {
						for (Genre k : i.getGenres()) {
							if (j.toLowerCase().equals(k.getName().toLowerCase())) {
								matches++;
							}
						}
					}
				}
				
				for (String j : splitInput) {
					for (String k : i.getTitle().split(" ")) {
						if (j.toLowerCase().equals(k.toLowerCase())) {
							matches++;
						}
					}
				}
				if (matches*count>=splitInput.length/2) {
					results.add(i);
				}
				System.out.println(matches + " : " + i.getTitle());
			}
			
			
			while (results.size()>20) {
				double minPop = -100.001;
				MovieDb lowMovie = null;
				for (MovieDb i : results) {
					if (minPop == -100.001) {
						minPop = i.getPopularity();
						lowMovie = i;
					}
					else if (minPop>i.getPopularity()) {
						minPop = i.getPopularity();
						lowMovie = i;
					}
				}
				results.remove(lowMovie);
			}
			
			
			System.out.println("FINAL RESULTS LIST FINISHED");
			
			for (MovieDb i : finResults) {
				System.out.println(i.getTitle());
			}
			
			return results;
		} else {
			TmdbMovies tmdbMovies = tmdbApi.getMovies();
			for (MovieDb i: tmdbMovies.getTopRatedMovies("en",0)) {
				results.add(i);
			}
			return results;
		}
	}
	
	
}
