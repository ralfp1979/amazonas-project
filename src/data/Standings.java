package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class Standings {

	private final List<TeamResult> results = new ArrayList<TeamResult>();

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
		// DEUCE
		if (match.getPointsTeam1() == match.getPointsTeam2()) {
			addPointsForTeam(match.getIdTeam1(), 1);
			addPointsForTeam(match.getIdTeam2(), 1);
		}
		// TEAM1 HAS WON
		else if (match.getPointsTeam1() > match.getPointsTeam2()) {
			addPointsForTeam(match.getIdTeam1(), 3);
		}
		// TEAM2 HAS WON
		else if (match.getPointsTeam1() < match.getPointsTeam2()) {
			addPointsForTeam(match.getIdTeam2(), 3);
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
