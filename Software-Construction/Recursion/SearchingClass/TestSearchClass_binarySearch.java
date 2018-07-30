package SearchingClass;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSearchClass_binarySearch{
	
	private int[] inputArray;
	private int key;
	private int start;
	private int end;
	private int expectedOutput;
	private SearchClass search;
	
	@Before
	public void setUp(){
		search = new SearchClass();
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//positive Test case
				{4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, 0, 8},
				{5, new int[]{2, 4, 6, 8, 10, 12, 10, 8, 6, 4, 2}, 10, 0, 10},
				{3, new int[]{1, 3, 7, 9, 11, 13, 15, 17, 19}, 7, 0, 8},
				{-1, new int[]{1, 2, 3, 4, 5}, 6, 0, 4},
				
				//Negative Test Case
				{0, new int[]{}, 0, 0, 0}
		});
	}
	
	public TestSearchClass_binarySearch(int expectedOutput, int[] inputArray, int key, int start, int end){
		this.expectedOutput = expectedOutput;
		this.inputArray = inputArray;
		this.key = key;
		this.start = start;
		this.end = end;
	}
	
	@Test
	public void testBinarySearch(){
		try{
			Assert.assertEquals(expectedOutput, search.binarySearch(inputArray, key, start, end));
		}catch(AssertionError error){
			Assert.assertEquals("The array is empty", error.getMessage());
		}
	}
}