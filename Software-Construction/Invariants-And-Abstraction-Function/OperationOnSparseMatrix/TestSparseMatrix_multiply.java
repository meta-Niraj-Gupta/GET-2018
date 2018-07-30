package OperationOnSparseMatrix;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMatrix_multiply {
	private int[][] matrix;
	private int[][] inputMatrix;
	private int[][] expectedResult;
	private SparseMatrix testSparse;
	

	public TestSparseMatrix_multiply(int[][] matrix, int[][] inputMatrix, int[][] expectedResult){
		this.matrix = matrix;
		this.inputMatrix = inputMatrix;
		testSparse = new SparseMatrix(this.matrix);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[][]> testCases(){
		return Arrays.asList(new Object[][][]{
				//Positive test cases
				{ new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} }, 
					new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} }, 
					new int[][]{ {14, 14, 16}, {14, 26, 26}, {16, 26, 29} },
				},
				
				{new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} }, 
					new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} },
					new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 0, 1} }
				},
				
				//Negative test cases
				{new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } , 
					new int[][] { {1, 5, 9}, {2, 6, 10}, {3, 7, 11} },
					new int[][] {}
				}
		});
	}
	
	@Test
	public void testMultiply(){
		try{
			int[][] array = testSparse.multiplyTwoMatrix(new SparseMatrix(inputMatrix)).getSparseMatrix();
			for(int i = 0; i < array.length; i++){
				Assert.assertArrayEquals(expectedResult[i], array[i]);
			}
		}catch(IllegalArgumentException exception){
			Assert.assertEquals("Invalid Input : The row of first matrix is not same as "
					+ "column of second matrix. Matrix multiplication is not possible "
					+ "Enter valid matrix with same order.",
									exception.getMessage());
		}
	}

}
