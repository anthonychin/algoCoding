package codingAlgo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PathFindingTest {
	private PathFinding pathFinding;

	@Before
	public void setUp() {
		pathFinding = new PathFinding();
	}

	@Test
	public void caseZero() {
		String[] board = {"....",
						 ".A..",
						 "..B.",
						 "...."};
		assertEquals(2, pathFinding.minTurns(board));
	}

	@Test
	public void caseOne() {
		String[] board = {"XXXXXXXXX",
						  "A...X...B",
						  "XXXXXXXXX"};
		assertEquals(-1, pathFinding.minTurns(board));
	}

	@Test
	public void caseTwo() {
		String[] board = {"XXXXXXXXX",
						  "A.......B",
						  "XXXXXXXXX"};
		assertEquals(-1, pathFinding.minTurns(board));
	}

	@Test
	public void caseThree() {
		String[] board = {"XXXXXXXXX",
						  "A.......B",
				 		  "XXXX.XXXX"};
		assertEquals(8, pathFinding.minTurns(board));
	}

	@Test
	public void caseFour() {
		String[] board = {"...A.XXXXX.....",
						  ".....XXXXX.....",
						  "...............",
						  ".....XXXXX.B...",
						  ".....XXXXX....."};
		assertEquals(13, pathFinding.minTurns(board));
	}

	@Test
	public void caseFive() {
		String[] board = 	
			{"AB.................X",
			 "XXXXXXXXXXXXXXXXXXX.",
			 "X..................X",
			 ".XXXXXXXXXXXXXXXXXXX",
			 "X..................X",
			 "XXXXXXXXXXXXXXXXXXX.",
			 "X..................X",
			 ".XXXXXXXXXXXXXXXXXXX",
			 "X..................X",
			 "XXXXXXXXXXXXXXXXXXX.",
			 "X..................X",
			 ".XXXXXXXXXXXXXXXXXXX",
			 "X..................X",
			 "XXXXXXXXXXXXXXXXXXX.",
			 "X..................X",
			 ".XXXXXXXXXXXXXXXXXXX",
			 "X..................X",
			 "XXXXXXXXXXXXXXXXXXX.",
			 "...................X",
			 ".XXXXXXXXXXXXXXXXXXX"};
		assertEquals(379, pathFinding.minTurns(board));
	}
}
