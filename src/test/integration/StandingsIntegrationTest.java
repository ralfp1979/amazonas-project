package test.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Sportsdata;
import de.msiggi.sportsdata.webservices.SportsdataSoap;
import de.msiggi.sportsdata.webservices.Team;

public class StandingsIntegrationTest {

	private static final String SEASON_2012 = "2012";
	private static final String BL1 = "bl1";
	private SportsdataSoap service;

	@Before
	public void setup() {
		service = new Sportsdata().getSportsdataSoap12();
	}

	@Test
	public void simulateSeason() {
		ArrayOfTeam teams = service.getTeamsByLeagueSaison(BL1, SEASON_2012);

		Standings standings = new Standings();
		standings.init(teams);

		ArrayOfMatchdata matches = service.getMatchdataByLeagueSaison(BL1,
				SEASON_2012);

		for (Matchdata match : matches.getMatchdata()) {
			standings.add(match);
		}

		Team team = standings.getTeamAtPosition(1);
		assertEquals("Bayern was the winner", 40, team.getTeamID());
	}

}
