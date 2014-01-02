import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.webservices.LeagueTest;
import data.StandingsTest;
import data.TeamResultTest;

@RunWith(Suite.class)
@SuiteClasses({ LeagueTest.class, TeamResultTest.class, StandingsTest.class })
public class TestSuite {

}
