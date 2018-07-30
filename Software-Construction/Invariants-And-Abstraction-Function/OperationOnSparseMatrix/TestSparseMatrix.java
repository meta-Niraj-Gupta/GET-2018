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
public class TestSparseMatrix{
	
	private int[][] matrix;
	private int[][] expectedResult;
	private SparseMatrix testSparse;
	

	public TestSparseMatrix(int[][] matrix, int[][] expectedResult){
		testSparse = new SparseMatrix(matrix);
		this.matrix = matrix;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testSquare(){
		return Arrays.asList(new Object[][]{
				{new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} }, new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} } },
				{new int[][]{ {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } , new int[][] { {1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12} }},
				{new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 1, 0} }, new int[][]{ {1, 0, 0}, {0, 1, 0}, {0, 1, 0} } },
		});
	}
	
	@Test
	public void testTranspose() throws Exception{
		Assert.assertEquals(expectedResult, testSparse.transposeOfMatrix());
		
	}

}
