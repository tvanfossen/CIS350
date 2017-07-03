package com.CIS350.P1;

import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		SessionConnect newSession = new SessionConnect("tvanfossen", "Targaryen!23");
		
		ArrayList<String> temp = newSession.searchInput("game");
		
		for (String i : temp)
		{
			System.out.println(i);
		}
		
	}

}
