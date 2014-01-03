import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import output.SeasonSimulatorTest;
import output.SimpleDataCollectorTest;
import output.SimpleFeatureGeneratorTest;
import output.file.OctaveFileWriterTest;
import test.integration.DataCollectorIntegrationTest;
import test.integration.StandingsIntegrationTest;
import test.webservices.LeagueTest;
import data.DataAndResultLineTest;
import data.MatchResolverTest;
import data.MatchResultTest;
import data.StandingsTest;
import data.TeamResultTest;

@RunWith(Suite.class)
@SuiteClasses({ LeagueTest.class, TeamResultTest.class, StandingsTest.class,
		StandingsIntegrationTest.class, SeasonSimulatorTest.class,
		SimpleDataCollectorTest.class, DataAndResultLineTest.class,
		MatchResolverTest.class, MatchResultTest.class,
		SimpleFeatureGeneratorTest.class, DataCollectorIntegrationTest.class,
		OctaveFileWriterTest.class })
public class TestSuite {

}
