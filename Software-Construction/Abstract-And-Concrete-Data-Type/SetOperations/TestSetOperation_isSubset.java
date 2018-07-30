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
public class TestSetOperation_isSubset {
	private int[] inputArray;
	private boolean expectedOutput;
	private IntSet intSet;
	
	@Before
	public void setUp(){
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		intSet = new IntSet(array);
	}
	
	public TestSetOperation_isSubset(int[] inputArray, boolean expectedOutput){
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{ 5, 9, 4,},  true},
	            { new int[]{ 1, 3, 4, 6 }, true },
	            { new int[]{ 5, 3, 1, 16 }, false },
				{ new int[]{ 1, 4, 3, 19 }, false },
				
//				//Negative Test Cases				
				{ new int[]{}, true},
	        });
	}
	
	@Test
	public void testIsSubset(){
		try{
			assertEquals(expectedOutput, intSet.isSubset(new IntSet(inputArray)));
		}catch(AssertionError error){
			assertEquals("The array is empty", error.getMessage());
		}
	}
}
