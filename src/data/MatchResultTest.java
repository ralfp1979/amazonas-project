package data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatchResultTest {

	@Test
	public void testHomeConstant() {
		assertEquals("1", MatchResult.HOME.getId());
	}

	@Test
	public void testDeuceConstant() {
		assertEquals("2", MatchResult.DEUCE.getId());
	}

	@Test
	public void testAwayConstant() {
		assertEquals("3", MatchResult.AWAY.getId());
	}

}
