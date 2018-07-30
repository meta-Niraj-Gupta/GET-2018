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
public class TestPerformingDifferentOperationOnArray_splitArray{
	private int[] inputArray;
	private int expectedOutput;
	private PerformingDifferentOperationOnArray array;
	
	@Before
	public void setUp(){
		array = new PerformingDifferentOperationOnArray();
	}
	
	public TestPerformingDifferentOperationOnArray_splitArray(int[] inputArray, int expectedOutput){
		this.inputArray = inputArray;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ new int[]{1, 2, 3, 3, 2, 1}, 3},
	            { new int[]{5, 4, 1, 4, 3, 2, 6, 1}, -1},
	            { new int[]{4, 2, 1, 3, 3, 4, 2, 1}, 4},
				{ new int[]{1 , 2 , 3 , 4 , 5 , 5}, 4},
				
				//Negative Test Cases
				{ new int[]{}, 0}
	        });
	}
	
	@Test
	public void test() throws EmptyArrayException{
		try{
			assertEquals(expectedOutput, array.splitArray((inputArray)));
		}catch(EmptyArrayException exception){
			assertEquals("The array cannot be empty", exception.getMessage());
		}
	}
}
