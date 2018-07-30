package OperationOnSparseMatrix;

import java.util.Arrays;
import java.util.Collection;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrix_transposeOfMatrix{
	
	private int[][] matrix;
	private int[][] expectedResult;
	private SparseMatrix testSparse;
	

	public TestSparseMatrix_transposeOfMatrix(int[][] matrix, int[][] expectedResult){
		this.matrix = matrix;
		testSparse = new SparseMatrix(this.matrix);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[][]> testCases(){
		return Arrays.asList(new Object[][][]{
				//Positive test cases
				{new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} }, new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} } },
				{new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} }, new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} } },
				
				//Negative test cases
				{new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } , new int[][] { {1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12} }}
		});
	}
	
	@Test
	public void testTransposeOfMatrix(){
		try{
			int[][] array = testSparse.transposeOfMatrix().getSparseMatrix();
			for(int i = 0; i < array.length; i++){
				Assert.assertArrayEquals(expectedResult[i], array[i]);
			}
		}catch(AssertionError error){
			Assert.assertEquals("Invalid Input : Please input matrix with same number of rows and columns",
									error.getMessage());
		}
	}

}
