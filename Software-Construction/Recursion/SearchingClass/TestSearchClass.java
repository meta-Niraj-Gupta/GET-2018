package SearchingClass;

import org.junit.Assert;
import org.junit.Test;

public class TestSearchClass{
	
	SearchClass search = new SearchClass();
	
	@Test
	public void testLinearSearch(){
		Assert.assertEquals(3, search.linearSearch(new int[]{5, 6, 7, 8, 9, 10}, 7, 0));
		
	}

	@Test
	public void testBinarySearch(){
		Assert.assertEquals(-1, search.binarySearch(new int[]{5, 6, 7, 8, 9, 10}, 4, 0, 5));
	}
}
