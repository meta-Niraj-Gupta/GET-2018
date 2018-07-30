package Calculator;

import org.junit.Assert;
import org.junit.Test;

public class TestHexCalc{
	HexCalc hexCalc = new HexCalc();
	@Test
	public void positiveTestCases() throws CannotSubtractException{
		Assert.assertEquals("C2", hexCalc.add("4b", "77"));
		Assert.assertEquals("1", hexCalc.subtract("3c", "3b"));
		Assert.assertEquals("DD4", hexCalc.multiply("3b", "3c"));
		Assert.assertEquals("1", hexCalc.divide("3b", "3b"));
		Assert.assertEquals(true, hexCalc.equalsTo("dd4", "dd4"));
		Assert.assertEquals(false, hexCalc.greaterThan("4b", "77"));
		Assert.assertEquals(true, hexCalc.lessThan("3b", "77"));
	}
	
	@Test
	public void negativeTestCases() throws CannotSubtractException{
		Assert.assertEquals("C1", hexCalc.add("4b", "77"));
		Assert.assertEquals("2", hexCalc.subtract("3c", "3b"));
		Assert.assertEquals("DD", hexCalc.multiply("3b", "3c"));
		Assert.assertEquals("4", hexCalc.divide("3b", "3b"));
		Assert.assertEquals(false, hexCalc.equalsTo("dd4", "dd4"));
		Assert.assertEquals(true, hexCalc.greaterThan("4b", "77"));
		Assert.assertEquals(false, hexCalc.lessThan("3b", "77"));
	}

}
