package com.project.IMBD;


import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

public class Assertion extends WIKI_Search 
{
	@Test
	public  void compareInfo() throws InterruptedException {
	Thread.sleep(4000);
		try {
		
			assertTrue(wikiReleaseDate.trim().equalsIgnoreCase(imdbReleaseDAte.trim()));
			assertTrue(wikiCountryOrigin.trim().equalsIgnoreCase(imdbCountryOrigin.trim()));
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
}