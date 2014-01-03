package test.webservices;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.ArrayOfGroup;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Group;
import de.msiggi.sportsdata.webservices.Matchdata;
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
		ArrayOfMatchdata matches = service.getMatchdataByLeagueSaison(BL1,
				SEASON_2012);

		assertEquals("There must be 34*9 matches in one season", 34 * 9,
				matches.getMatchdata().size());
	}

	@Test
	public void scoreInOnMatch() {
		Matchdata match = service.getMatchByMatchID(23976);

		assertEquals(2, match.getPointsTeam1());
		assertEquals(2, match.getPointsTeam2());

	}

	@Test
	public void testGroups() throws Exception {
		ArrayOfGroup groups = service.getAvailGroups(BL1, SEASON_2012);

		int expectedSize = 34;
		assertEquals(expectedSize, groups.getGroup().size());

		for (int ii = 0; ii < expectedSize; ii++) {
			Group group = groups.getGroup().get(ii);
			assertEquals(ii + 1, group.getGroupOrderID());
		}
	}
}
