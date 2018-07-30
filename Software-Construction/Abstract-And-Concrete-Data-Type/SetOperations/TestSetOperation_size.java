package SetOperations;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSetOperation_size {
	private int[] inputArray;
	private int expectedOutput;
	private IntSet intSet;
	
	public TestSetOperation_size(int[] inputArray, int expectedOutput){
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{ 5, 9, 4 },  3 },
	            { new int[]{ 1, 3, 4, 6 }, 4 },
	            { new int[]{ 5, 3, 1, 16, 45 }, 5 },
				{ new int[]{ 1, 4, 3, 5, 19, 5, 7, 8}, 7 },
				
//				//Negative Test Cases				
				{ new int[]{}, 0},
	        });
	}
	
	@Test
	public void testIsSubset(){
		try{
			intSet = new IntSet(inputArray);
			assertEquals(expectedOutput, intSet.size());
		}catch(AssertionError error){
			assertEquals("The array is empty", error.getMessage());
		}
	}
}
