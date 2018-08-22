package UniqueCharacter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCountUniqueCharacter {
	private String inputString;
	private int expectedResult;
	private CountUniqueCharacter countUniqueCharacter;

	@Before
	public void setUp(){
		countUniqueCharacter = new CountUniqueCharacter();
	}
	
	public TestCountUniqueCharacter(String inputString, int expectedResult){
		this.inputString = inputString;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ "abcde", 5 }, 
				{ "abccddee", 5 },
				{ "abcde abcde", 6},
				{"", 0},
		});
	}
	
	@Test
	public void getNumberOfUniqueCharacter_HappyFlow(){
			assertEquals(expectedResult, countUniqueCharacter.getNumberOfUniqueCharacter(inputString));
		}
}
