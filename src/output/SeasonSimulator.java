package output;

import data.Standings;
import de.msiggi.sportsdata.webservices.ArrayOfGroup;
import de.msiggi.sportsdata.webservices.ArrayOfMatchdata;
import de.msiggi.sportsdata.webservices.ArrayOfTeam;
import de.msiggi.sportsdata.webservices.Group;
import de.msiggi.sportsdata.webservices.Matchdata;
import de.msiggi.sportsdata.webservices.Sportsdata;
import de.msiggi.sportsdata.webservices.SportsdataSoap;
import de.msiggi.sportsdata.webservices.Team;

public class SeasonSimulator {

	private final Standings standings = new Standings();
	private String league = null;
	private String season = null;
	private final SportsdataSoap service;
	private DataCollector collector;

	public SeasonSimulator() {
		super();
		service = new Sportsdata().getSportsdataSoap12();
	}

	public void simulate(String league, String season) {

		this.league = league;
		this.season = season;

		initStandings();
		simulateAllMatches();
	}

	private void initStandings() {
		ArrayOfTeam teams = service.getTeamsByLeagueSaison(league, season);
		standings.init(teams);
	}

	private void simulateAllMatches() {
		ArrayOfGroup groups = service.getAvailGroups(league, season);
		for (Group group : groups.getGroup()) {
			simulateMatchesOfGroup(group);
		}

	}

	private void simulateMatchesOfGroup(Group group) {
		int groupOrderID = group.getGroupOrderID();
		ArrayOfMatchdata matchesOfGroup = service
				.getMatchdataByGroupLeagueSaison(groupOrderID, league, season);

		collectData(matchesOfGroup);
		addResultsToStandings(matchesOfGroup);

	}

	private void collectData(ArrayOfMatchdata matchesOfGroup) {
		if (null != collector) {
			collector.addDatasets(matchesOfGroup, standings);
		}
	}

	private void addResultsToStandings(ArrayOfMatchdata matchesOfGroup) {
		for (Matchdata match : matchesOfGroup.getMatchdata()) {
			standings.add(match);
		}
	}

	public Team getWinner() {
		return standings.getTeamAtPosition(1);
	}

	public void setDataCollector(DataCollector collector) {
		this.collector = collector;
	}

}
