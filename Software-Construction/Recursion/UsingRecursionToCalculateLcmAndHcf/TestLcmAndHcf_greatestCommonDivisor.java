package UsingRecursionToCalculateLcmAndHcf;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLcmAndHcf_greatestCommonDivisor {
	private LcmAndHcf lcmHcf;
	private int firstValue;
	private int secondValue;
	private int expectedOutput;
	
	@Before
	public void setUp() {
		lcmHcf = new LcmAndHcf();
	}
	
	public TestLcmAndHcf_greatestCommonDivisor(int expectedOutput, int firstValue, int secondValue){
		this.expectedOutput = expectedOutput;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{10, 30, 20},
				{40, 40, 80},
				{30, 90, 30},
				
				//Negative Test Cases
				{0, -30, 20},
				{0, 30, -20}
		});
	}
	
	@Test
	public void testLeastCommonMultiple() throws InvalidInputException {
		try{
			Assert.assertEquals(expectedOutput, lcmHcf.calculateGreatestCommonDivisor(firstValue, secondValue));
		}catch(InvalidInputException exception){
			Assert.assertEquals("Invalid Input. Please provide valid positive numbers.", exception.getMessage());
		}
	}
}
