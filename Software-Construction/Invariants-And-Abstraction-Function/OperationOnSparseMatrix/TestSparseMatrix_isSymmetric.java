package OperationOnSparseMatrix;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrix_isSymmetric {
	private int[][] matrix;
	private boolean expectedResult;
	private SparseMatrix testSparse;
	

	public TestSparseMatrix_isSymmetric(int[][] matrix, boolean expectedResult){
		this.matrix = matrix;
		testSparse = new SparseMatrix(this.matrix);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive test cases
				{new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} }, true },
				{new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} }, true },
				
				//Negative test cases
				{new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } , false }
		});
	}
	
	@Test
	public void testIsSymmetric(){
		try{
			Assert.assertEquals(expectedResult, testSparse.isSymmetric());
		}catch(AssertionError error){
			Assert.assertEquals("Invalid Input : Please input matrix with same number of rows and columns",
									error.getMessage());
		}
	}
}
