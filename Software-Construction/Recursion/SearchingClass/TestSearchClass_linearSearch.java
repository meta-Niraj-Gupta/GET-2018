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
public class TestSearchClass_linearSearch{
	
	private int[] inputArray;
	private int key;
	private int index;
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
				{4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, 0},
				{5, new int[]{2, 4, 6, 8, 10, 12, 10, 8, 6, 4, 2}, 10, 0},
				{3, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 8, 0},
				{-1, new int[]{1, 2, 3, 4, 5}, 6, 0},
				
				//Negative Test Case
				{0, new int[]{}, 0, 0}
		});
	}
	
	public TestSearchClass_linearSearch(int expectedOutput, int[] inputArray, int key, int index){
		this.expectedOutput = expectedOutput;
		this.inputArray = inputArray;
		this.key = key;
		this.index = index;
	}
	
	@Test
	public void testLinearSearch(){
		try{
			Assert.assertEquals(expectedOutput, search.linearSearch(inputArray, key, index));
		}catch(AssertionError error){
			Assert.assertEquals("The array is empty", error.getMessage());
		}
	}
}
