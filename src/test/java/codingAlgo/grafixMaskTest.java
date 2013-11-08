package codingAlgo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class grafixMaskTest {
	grafixMask gm;
	@Before
	public void setUp() {
		//grafixMask.class;
		gm = new grafixMask();
	}
	@Test
	public void test() {
		String[] test =  {"4 3 2 5", "2 2 2 2"};
		gm.sortedArea(test);
		
		
	}

}
