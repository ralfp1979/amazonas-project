package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Team;

public class Standings {

	private final List<TeamResult> results = new ArrayList<TeamResult>();
	private final List<TeamResult> homeResults = new ArrayList<TeamResult>();
	private final List<TeamResult> awayResults = new ArrayList<TeamResult>();
	private final MatchResolver matchResolver = new MatchResolver();

	public int getNumberOfTeams() {
		return results.size();
	}

	public void init(ArrayOfTeam teams) {
		for (Team team : teams.getTeam()) {
			TeamResult result = new TeamResult(team);
			results.add(result.clone());
			homeResults.add(result.clone());
			awayResults.add(result.clone());
		}
	}

	public void add(Matchdata match) {
		addResult(match);

		Collections.sort(results);
		Collections.sort(homeResults);
		Collections.sort(awayResults);
	}

	private void addResult(Matchdata match) {
		MatchResult result = matchResolver.getResult(match);

		switch (result) {
		case HOME:
			addPointsForTeam(match.getIdTeam1(), 3, results);
			addPointsForTeam(match.getIdTeam1(), 3, homeResults);
			break;
		case AWAY:
			addPointsForTeam(match.getIdTeam2(), 3, results);
			addPointsForTeam(match.getIdTeam2(), 3, awayResults);
			break;
		case DEUCE:
			addPointsForTeam(match.getIdTeam1(), 1, results);
			addPointsForTeam(match.getIdTeam2(), 1, results);
			addPointsForTeam(match.getIdTeam1(), 1, homeResults);
			addPointsForTeam(match.getIdTeam2(), 1, awayResults);
			break;

		}
	}

	private void addPointsForTeam(int teamId, int points,
			List<TeamResult> currentResults) {
		Team lookup = new Team();
		lookup.setTeamID(teamId);
		TeamResult result = new TeamResult(lookup);
		int index = currentResults.indexOf(result);

		if (index > -1) {
			result = currentResults.get(index);
			result.addPoints(points);
		}

	}

	protected Team getTeamAtPositionInternal(int pos,
			List<TeamResult> currentResults) {
		int index = pos - 1;
		TeamResult teamResult = results.get(index);
		return teamResult.getTeam();
	}

	public Team getTeamAtPosition(int pos) {
		Team team = getTeamAtPositionInternal(pos, results);
		return team;
	}

	public Team getTeamAtHomePosition(int pos) {
		Team team = getTeamAtPositionInternal(pos, homeResults);
		return team;
	}

	public Team getTeamAtAwayPosition(int pos) {
		Team team = getTeamAtPositionInternal(pos, awayResults);
		return team;
	}

	public int getPositionOfTeamInternal(Team team,
			List<TeamResult> currentResults) {
		TeamResult searched = new TeamResult(team);
		int indexInList = currentResults.indexOf(searched);
		return indexInList + 1;
	}

	public int getPositionOfTeam(Team team) {
		int pos = getPositionOfTeamInternal(team, results);
		return pos;
	}

	public int getHomePositionOfTeam(Team team) {
		int pos = getPositionOfTeamInternal(team, homeResults);
		return pos;
	}

	public int getAwayPositionOfTeam(Team team) {
		int pos = getPositionOfTeamInternal(team, awayResults);
		return pos;
	}

}
