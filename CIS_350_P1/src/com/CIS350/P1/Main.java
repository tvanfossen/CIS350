package com.CIS350.P1;

public class Main {

	public static void main(String[] args)
	{
		SessionConnect newSession = new SessionConnect("tvanfossen", "Targaryen!23");
		
		newSession.searchInput("civil war");
		System.out.println("test");
	}

}
