package MutablePoly;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Polynomial.Poly;

@RunWith(Parameterized.class)
public class TestMutablePolynomial_degree {
	private int[] inputPolynomial;
	private int expectedResult;
	private Poly poly;
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{ new int[]{ 0, 1, 2, 3, 4 }, 4 },
				{ new int[]{ 1, 2, 3 }, 2 },
				{ new int[]{ 0, 2, 0, 3, 0, 4 }, 5 },
				
				//Negative test cases
				{ new int[]{}, 0 }
		});
	}
	
	public TestMutablePolynomial_degree(int[] inputPolynomial, int expectedResult){
		this.expectedResult = expectedResult;
		this.inputPolynomial = inputPolynomial;
		poly = new Poly(this.inputPolynomial);
	}
	
	@Test
	public void testDegree(){
		try{
			Assert.assertEquals(expectedResult, poly.degree());
		}catch(AssertionError error){
			//do-nothing
		}
	}

}
