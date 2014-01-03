package data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DataAndResultLineTest {

	DataAndResultLine cut;

	@Before
	public void setUp() throws Exception {
		cut = new DataAndResultLine();
	}

	@Test
	public void testGetterSetter() {
		cut.setData("0 0 1");
		cut.setResult("1");

		assertEquals("0 0 1", cut.getData());
		assertEquals("1", cut.getResult());
	}

}
