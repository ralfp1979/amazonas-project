package data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class StandingsTest {

	private Standings cut;
	private ArrayOfTeam teams;
	private Team teamA;
	private Team teamB;

	@Before
	public void setUp() throws Exception {
		cut = new Standings();
		teams = new ArrayOfTeam();

		teamA = createTeam(1, "A");
		teams.getTeam().add(teamA);

		teamB = createTeam(2, "B");
		teams.getTeam().add(teamB);
	}

	static protected Team createTeam(int id, String name) {
		Team team = new Team();
		team.setTeamID(id);
		team.setTeamName(name);
		return team;
	}

	@Test
	public void testInit() {

		assertEquals(0, cut.getNumberOfTeams());
		cut.init(teams);

		assertEquals(teams.getTeam().size(), cut.getNumberOfTeams());

	}

	@Test
	public void testDay1TeamAWins() throws Exception {
		cut.init(teams);
		Matchdata match = createMatch(teamA, teamB, 3, 1);

		cut.add(match);

		assertEquals(1, cut.getPositionOfTeam(teamA));
	}

	@Test
	public void testDay1TeamBWins() throws Exception {
		cut.init(teams);
		Matchdata match = createMatch(teamA, teamB, 1, 3);

		cut.add(match);

		assertEquals(2, cut.getPositionOfTeam(teamA));
	}

	private Matchdata createMatch(Team team1, Team team2, int points1,
			int points2) {
		Matchdata match = new Matchdata();

		match.setIdTeam1(team1.getTeamID());
		match.setNameTeam1(team1.getTeamName());
		match.setPointsTeam1(points1);

		match.setIdTeam2(team2.getTeamID());
		match.setNameTeam2(team2.getTeamName());
		match.setPointsTeam2(points2);

		return match;
	}
}
