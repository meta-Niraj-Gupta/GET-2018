package SetOperations;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSetOperation_isMember {
	private int inputItem;
	private boolean expectedOutput;
	private IntSet intSet;
	
	@Before
	public void setUp(){
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		//int[] emptyArray = new int[]{};
		intSet = new IntSet(array);
	}
	
	public TestSetOperation_isMember(int inputItem, boolean expectedOutput){
		this.inputItem = inputItem;
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{ 5,  true},
	            { 14, true },
	            { 20, false },
				{ 19, false },
				
//				//Negative Test Cases				
				{ 0, true},
	        });
	}
	
	@Test
	public void testisMember(){
		try{
			assertEquals(expectedOutput, intSet.isMember(inputItem));
		}catch(AssertionError error){
			assertEquals("The array is empty", error.getMessage());
		}
	}
}
