package webservices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.ArrayOfSport;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Sportsdata;
import de.msiggi.sportsdata.webservices.SportsdataSoap;

public class LeagueTest {

	private SportsdataSoap service;

	@Before
	public void setup() {
		service = new Sportsdata().getSportsdataSoap12();	       
	}
	
	@Test
	public void numberOfTeams() {
		ArrayOfTeam teams = service.getTeamsByLeagueSaison("bl1", "2012");
		
		assertEquals("There must be 18 teams", 18, teams.getTeam().size());
	}

}