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
	public void caseZero() {
		String[] competitors = {"1 4","2","3","0",""};
		assertEquals(2, marketing.howMany(competitors));
	}

	@Test
	public void caseOne() {
		String[] competitors = {"1", "2", "0"};
		assertEquals(-1, marketing.howMany(competitors));
	}

	@Test
	public void caseTwo() {
		String[] competitors = {"1", "2", "3", "0", "0 5", "1"};
		assertEquals(2, marketing.howMany(competitors));
	}

	@Test
	public void caseThree() {
		String[] competitors = {"","","","","","","","","","",
				 "","","","","","","","","","",
				 "","","","","","","","","",""};
		assertEquals(1073741824, marketing.howMany(competitors));
	}

	@Test
	public void caseFour() {
		String[] competitors = {"1","2","3","0","5","6","4"};
		assertEquals(-1, marketing.howMany(competitors));
	}
}
