package ViratProblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestMinimizingViratScore {
	Map<String, Integer> bowlers;

	@Before
	public void setUp() {
		bowlers = new LinkedHashMap<String, Integer>();
		bowlers.put("abc", 7);
		bowlers.put("xyz", 9);
		bowlers.put("mno", 5);
	}

	@Test
	public void cricketMatchTest1() throws InsufficientBallsLeftException {
		MinimizingViratScore cricketMatch = new MinimizingViratScore(10, bowlers);
		List<String> expectedBowlingOrder = new ArrayList<String>(){{
			add("xyz");
			add("xyz");
			add("abc");
			add("xyz");
			add("abc");
			add("xyz");
			add("abc");
			add("xyz");
			add("mno");
			add("abc");
		}};
		assertEquals(expectedBowlingOrder, cricketMatch.bowlingOrder());
	}


	@Test
	public void cricketMatchTest2(){
		try{
			new MinimizingViratScore(40, bowlers);
		}catch(InsufficientBallsLeftException exception){
			assertEquals("Insufficient balls left!!", exception.getMessage());
		}
	}
}
