package OperationsOnArray;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPerfromingDifferentOperationOnArray_fixXYInArray {
	private int[] inputArray;
	private int[] expectedOutput;
	private int firstValue;
	private int secondValue;
	private PerformingDifferentOperationOnArray array;
	
	@Before
	public void setUp(){
		array = new PerformingDifferentOperationOnArray();
	}
	
	public TestPerfromingDifferentOperationOnArray_fixXYInArray(int[] inputArray, int[] expectedOutput,
																	int firstValue, int secondValue){
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{ 5, 9, 4, 1, 5, 4, 3, 2 }, new int[]{ 1, 9, 4, 5, 3, 4, 5, 2 }, 4, 5 },
	            { new int[]{ 5, 4, 9, 1, 3, 4, 6, 1 }, new int[]{ 5, 4, 1, 9, 3, 4, 1, 6 }, 4, 1 },
	            { new int[]{ 5, 3, 1, 3, 6, 5, 5, 3, 2 }, new int[]{ 1, 3, 5, 3, 5, 6, 2, 3, 5}, 3, 5 },
				{ new int[]{ 1, 4, 3, 1, 4, 3, 1, 4, 3, 1, 4, 3 }, new int[]{ 1, 4, 3, 1, 4, 3, 1, 4, 3, 1, 4, 3 }, 1, 4 },
				
//				//Negative Test Cases				
				{ new int[]{}, new int[]{}, 0, 0},
				{ new int[]{ 5, 9, 4, 1, 4, 5, 4, 3, 2 }, new int[]{ 1, 9, 4, 5, 3, 4, 5, 2 }, 4, 5},
				{ new int[]{ 5, 9, 4, 1, 5, 4, 3, 2, 4 }, new int[]{ 1, 9, 4, 5, 3, 4, 5, 2 }, 4, 5 },
				{ new int[]{ 5, 9, 4, 4, 1, 5, 4, 3, 2 }, new int[]{ 1, 9, 4, 5, 3, 4, 5, 2 }, 4, 5 }
	        });
	}
	
	@Test
	public void test() throws EmptyArrayException{
		try{
			assertArrayEquals(expectedOutput, array.fixXYInArray(inputArray, firstValue, secondValue));
		}catch(EmptyArrayException exception){
			assertEquals("The array cannot be empty", exception.getMessage());
		}catch(AssertionError error){
			assertEquals("Cannot fit X and Y", error.getMessage());
		}
	}
}
