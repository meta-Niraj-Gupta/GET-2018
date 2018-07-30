package Polynomial;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPoly_evaluate{
	private int[] inputArray;
	private int expectedOutput;
	private int valueOfVariable;
	private Poly poly;
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Case
				{ new int[]{ 1, 2, 3, 4 }, 1, 10 },
				{ new int[]{ 5, 0, 1, 3}, 2, 33 },
				{ new int[]{ 0, 0, 3, 4}, 3, 135},
				
				//Negative Test Case
				{ new int[]{}, 0, 0 }
		});
	}
	
	public TestPoly_evaluate(int[] inputArray, int valueOfVariable, int expectedOutput){
		this.inputArray = inputArray;
		this.valueOfVariable = valueOfVariable;
		this.expectedOutput = expectedOutput;
		poly = new Poly(this.inputArray);
	}
	
	@Test
	public void testEvaluate(){
		try{
			Assert.assertEquals(expectedOutput, poly.evaluate(valueOfVariable));
		}catch(IllegalArgumentException exception){
			Assert.assertEquals("The polynomial array is empty", exception.getMessage());
		}
	}

}
