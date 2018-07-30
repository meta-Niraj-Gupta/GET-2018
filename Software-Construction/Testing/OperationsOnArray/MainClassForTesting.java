package OperationsOnArray;

import org.junit.Test;
import org.junit.Assert;


public class MainClassForTesting {
	PerformingDifferentOperationOnArray testing = new PerformingDifferentOperationOnArray();
	@Test
	public void testSplitArray() throws EmptyArrayException{
		Assert.assertEquals("The test case is passed", 3, testing.splitArray(new int[]{1, 1, 1, 2, 1}));
	}

	@Test
	public void testClumpsInArray() throws EmptyArrayException{
		Assert.assertEquals("The test Case is Passed", 2, testing.clumpsInArray(new int[] { 1, 2, 2, 3, 4, 4 }));
	}
	
	@Test
	public void testMirrorInArray() throws EmptyArrayException{
		Assert.assertEquals("The test Case is Passed", 3, testing.maximumSizeOfMirror(new int[]{1, 2, 1, 4}));
	}
	
	@Test
	public void testFixXYInArray() throws EmptyArrayException{
		Assert.assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, testing.fixXYInArray(new int[]{5, 4, 9, 4, 9, 5}, 4, 5));
		Assert.assertArrayEquals(new int[]{5, 4, 9, 4, 9, 5, 8, 5, 4}, new int[]{});
	}
}
