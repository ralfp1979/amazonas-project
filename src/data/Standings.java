package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class Standings {

	private final List<TeamResult> results = new ArrayList<TeamResult>();
	private final MatchResolver matchResolver = new MatchResolver();

	public int getNumberOfTeams() {
		return results.size();
	}

	public void init(ArrayOfTeam teams) {
		for (Team team : teams.getTeam()) {
			TeamResult result = new TeamResult(team);
			results.add(result);
		}
	}

	public void add(Matchdata match) {
		addResult(match);

		Collections.sort(results);
	}

	private void addResult(Matchdata match) {
		MatchResult result = matchResolver.getResult(match);

		switch (result) {
		case HOME:
			addPointsForTeam(match.getIdTeam1(), 3);
			break;
		case AWAY:
			addPointsForTeam(match.getIdTeam2(), 3);
			break;
		case DEUCE:
			addPointsForTeam(match.getIdTeam1(), 1);
			addPointsForTeam(match.getIdTeam2(), 1);
			break;

		}
	}

	private void addPointsForTeam(int teamId, int points) {
		Team lookup = new Team();
		lookup.setTeamID(teamId);
		TeamResult result = new TeamResult(lookup);
		int index = results.indexOf(result);

		if (index > -1) {
			result = results.get(index);
			result.addPoints(points);
		}

	}

	public int getPositionOfTeam(Team team) {
		TeamResult searched = new TeamResult(team);
		int indexInList = results.indexOf(searched);
		return indexInList + 1;
	}

	public Team getTeamAtPosition(int pos) {
		int index = pos - 1;
		TeamResult teamResult = results.get(index);
		return teamResult.getTeam();
	}

}
