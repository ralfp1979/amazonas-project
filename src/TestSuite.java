import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import data.StandingsTest;

import test.webservices.LeagueTest;

@RunWith(Suite.class)
@SuiteClasses({
    LeagueTest.class,
    StandingsTest.class
})
public class TestSuite {

}
