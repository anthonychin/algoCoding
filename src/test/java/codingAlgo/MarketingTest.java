package codingAlgo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MarketingTest {
	public Marketing marketing;

	@Before
	public void setUp() {
		marketing = new Marketing();
	}

	@Test
	public void caseOne() {
		String[] expectedResult = {"1 4","2","3","0",""};
		String[] actualResult = {};
		assertArrayEquals(expectedResult, actualResult);
	}
	
}
