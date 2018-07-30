package SetOperations;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSetOperation_union {
	private int[] inputArray;
	private int[] inputSet;
	private int[] expectedOutput;
	private IntSet intSet;
	
	@Before
	public void setUp(){
		intSet = new IntSet();
	}
	
	public TestSetOperation_union(int[] inputSet, int[] inputArray, int[] expectedOutput){
		this.inputSet = inputSet;
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 6} ,new int[]{1, 2, 3, 4, 5, 6} },
				{ new int[]{1, 2, 3}, new int[]{3, 4, 5} ,new int[]{1, 2, 3, 4, 5} },
				{ new int[]{5, 4, 3, 2, 1}, new int[]{10, 9, 6, 5, 4} ,new int[]{1, 2, 3, 4, 5, 6, 9, 10} },
				{ new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7} ,new int[]{1, 2, 3, 4, 5, 6, 7, 8} },
				{ new int[]{}, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4} },
				{ new int[]{1, 2, 3, 4}, new int[]{}, new int[]{1, 2, 3, 4} },
				
				//Negative Test Cases				
				{ new int[]{}, new int[]{}, new int[]{} },
				{ new int[]{}, new int[]{}, new int[]{} } 
	        });
	}
	
	@Test
	public void testUnion(){
		try{
			assertArrayEquals(expectedOutput, intSet.union(new IntSet(inputArray), new IntSet(inputSet)));
		}catch(AssertionError error){
			assertEquals("The array is empty", error.getMessage());
		}
	}
}
