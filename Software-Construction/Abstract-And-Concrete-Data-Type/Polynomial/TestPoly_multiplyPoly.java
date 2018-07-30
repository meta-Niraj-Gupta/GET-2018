package Polynomial;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPoly_multiplyPoly {
	private int[] inputPoly;
	private int[] polyInput;
	private Poly poly, polynomial, pol;
	private int[] expectedResult;
	
	@Before
	public void setUp(){
		pol = new Poly();
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Case
				{ new int[]{ 5, 0, 2, 3 }, new int[]{ 4, 3, 2 }, new int[]{ 20, 15, 18, 18, 13, 6 } },
				{ new int[]{ 4, 3, 0, 1, 5 }, new int[]{ 1, 0, 4, 3 }, new int[]{ 4, 3, 16, 25, 14, 4, 23, 15 } },
				{ new int[]{ 3, 0, 2, 1 }, new int[]{ 0, 4, 0, 1, 2 }, new int[]{ 0, 12, 0, 11, 10, 2, 5, 2 } },
				
				//Negative Test Case
				{ new int[]{}, new int[]{}, new int[]{1, 2, 3} }
		});
	}
	
	public TestPoly_multiplyPoly(int[] inputPoly, int[] polyInput, int[] expectedResult){
		this.inputPoly = inputPoly;
		poly = new Poly(this.inputPoly);
		this.polyInput = polyInput;
		polynomial = new Poly(this.polyInput);
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void testMultiplyPoly(){
		try{
			int[] array = pol.multiplyPoly(poly, polynomial).getPolynomialArray();
			Assert.assertArrayEquals(expectedResult, array);
		}catch(IllegalArgumentException exception){
			Assert.assertEquals("Invalid Input: The polynomial array is empty. Please Enter a valid input",
								exception.getMessage());
		}
	}

}
