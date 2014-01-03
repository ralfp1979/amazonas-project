package output;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data.Standings;
import data.StandingsTest;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class SimpleDataCollectorTest {

	private DataCollector cut;

	@Before
	public void setup() {
		cut = new SimpleDataCollector();
	}

	@Test
	public void testEmptyAtBeginning() throws Exception {
		assertEquals(0, cut.getDataSize());
	}

	@Test
	public void testDataSetAdded() throws Exception {
		ArrayOfTeam teams = initTeams();

		ArrayOfMatchdata matches = initMatches(teams, 1);

		Standings standings = new Standings();
		standings.init(teams);

		cut.addDatasets(matches, standings);
		assertEquals(1, cut.getDataSize());
	}

	@Test
	public void test3DataSetAdded() throws Exception {
		ArrayOfTeam teams = initTeams();

		ArrayOfMatchdata matches = initMatches(teams, 3);

		Standings standings = new Standings();
		standings.init(teams);

		cut.addDatasets(matches, standings);
		assertEquals(3, cut.getDataSize());
	}

	private ArrayOfMatchdata initMatches(ArrayOfTeam teams, int games) {
		ArrayOfMatchdata matches = new ArrayOfMatchdata();

		for (int ii = 0; ii < games; ii++) {
			Matchdata match = new Matchdata();

			Team a = teams.getTeam().get(0);
			Team b = teams.getTeam().get(1);
			match.setIdTeam1(a.getTeamID());
			match.setIdTeam2(b.getTeamID());

			matches.getMatchdata().add(match);
		}

		return matches;
	}

	private ArrayOfTeam initTeams() {
		ArrayOfTeam teams = new ArrayOfTeam();
		Team teamA = StandingsTest.createTeam(1, "A");
		teams.getTeam().add(teamA);
		Team teamB = StandingsTest.createTeam(2, "B");
		teams.getTeam().add(teamB);
		return teams;
	}
}
