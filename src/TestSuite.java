import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import output.SeasonSimulatorTest;
import output.SimpleDataCollectorTest;
import test.integration.StandingsIntegrationTest;
import test.webservices.LeagueTest;
import data.StandingsTest;
import data.TeamResultTest;

@RunWith(Suite.class)
@SuiteClasses({ LeagueTest.class, TeamResultTest.class, StandingsTest.class,
		StandingsIntegrationTest.class, SeasonSimulatorTest.class,
		SimpleDataCollectorTest.class })
public class TestSuite {

}
