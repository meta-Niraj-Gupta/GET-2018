package Postfix;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPostfixExpression_evaluatingPostfixExpression{
	private String expression;
	private int expectedResult;
	private PostfixExpression postfix;
		
	public TestPostfixExpression_evaluatingPostfixExpression(String expression, int expectedResult){
		this.expression = expression;
		postfix = new PostfixExpression(this.expression);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{ "2 3 4 + * 6 -", 8 },
				{ "2 3 1 * + 9 -", -4 },
				{ "100 200 + 2 / 5 * 7 +", 757}
		});
	}
	
	@Test
	public void testEvaluatingPostfixExpression(){
		assertEquals(expectedResult, postfix.evaluatingPostfixExpression());
	}
	
}
