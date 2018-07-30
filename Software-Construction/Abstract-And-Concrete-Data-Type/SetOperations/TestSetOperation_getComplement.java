package SetOperations;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSetOperation_getComplement {
	private int[] inputArray;
	private int[] expectedOutput;
	private IntSet intSet;
	
	public TestSetOperation_getComplement(int[] inputArray, int[] expectedOutput){
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{1, 2, 3, 4, 5} ,new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20} },
				{ new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20} },
				{ new int[]{5, 6, 7, 10, 12, 14, 16, 18}, new int[]{1, 2, 3, 4, 8, 9, 11, 13, 15, 17, 19, 20} },
				{ new int[]{}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20} },
				
				//Negative Test Cases				
//				{ new int[]{}, new int[]{}, new int[]{} },
//				{ new int[]{}, new int[]{}, new int[]{} } 
	        });
	}
	
	@Test
	public void testGetComplement(){
		try{
			intSet = new IntSet(inputArray);
			assertArrayEquals(expectedOutput, intSet.getComplement());
		}catch(AssertionError error){
			assertEquals("The array is empty", error.getMessage());
		}
	}
}
