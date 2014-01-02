package test.webservices;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfSport;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Sportsdata;
import de.msiggi.sportsdata.webservices.SportsdataSoap;

public class LeagueTest {

	private static final String SEASON_2012 = "2012";
	private static final String BL1 = "bl1";
	private SportsdataSoap service;

	@Before
	public void setup() {
		service = new Sportsdata().getSportsdataSoap12();	       
	}
	
	@Test
	public void numberOfTeams() {
		ArrayOfTeam teams = service.getTeamsByLeagueSaison(BL1, SEASON_2012);
		
		assertEquals("There must be 18 teams", 18, teams.getTeam().size());
	}
	
	@Test
	public void numberOfGamesInSeason() {
		ArrayOfMatchdata matches = service.getMatchdataByLeagueSaison(BL1, SEASON_2012);
		
		assertEquals("There must be 34*9 matches in one season", 34*9, matches.getMatchdata().size());
	}

}
