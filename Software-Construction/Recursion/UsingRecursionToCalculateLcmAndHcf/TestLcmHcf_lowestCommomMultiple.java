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
public class TestLcmHcf_lowestCommomMultiple {
	private LcmAndHcf lcmHcf;
	private int firstValue;
	private int secondValue;
	private int expectedOutput;
	private int multiple;
	
	@Before
	public void setUp() {
		lcmHcf = new LcmAndHcf();
	}
	
	public TestLcmHcf_lowestCommomMultiple(int expectedOutput, int firstValue, int secondValue, int multiple){
		this.expectedOutput = expectedOutput;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.multiple = multiple;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{60 ,30, 20, 30},
				{80, 40, 80, 80},
				{90, 90, 30, 90},
				
				//Negative Test Cases
				{0, -30, 20, 20},
				{0, 30, -20, 30}
		});
	}
	
	@Test
	public void testLeastCommonMultiple() throws InvalidInputException {
		try{
			Assert.assertEquals(expectedOutput, lcmHcf.calculateLeastCommomMultiple(firstValue, secondValue, multiple));
		}catch(InvalidInputException exception){
			Assert.assertEquals("Invalid Input. Please provide valid positive numbers.", exception.getMessage());
		}
	}
}
