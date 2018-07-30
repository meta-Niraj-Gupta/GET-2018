package Queens;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNQueens{
	private NQueensProblem nQueen;
	private int numberOfQueens;
	private boolean expectedOutput;
	
	@Before
	public void setUp(){
		nQueen = new NQueensProblem();
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{ 
				//Positive Test Cases
				{4, true}, 
				{5, true}, 
				
				//Negative Test Cases
				{3, false},
				{2, false},
				{-1, false}
		});
	}
	
	public TestNQueens(int numberOfQueens, boolean expectedOutput){
		this.numberOfQueens = numberOfQueens;
		this.expectedOutput = expectedOutput;
	}
	
	@Test
	public void testNQueens(){
		try{
			assertEquals(expectedOutput, nQueen.nQueens(numberOfQueens));
		}catch(AssertionError error){
			assertEquals("The solution is not possible", error.getMessage());
		}catch(NegativeArraySizeException exception){
			assertEquals(null, exception.getMessage());
		}
	}	
}
