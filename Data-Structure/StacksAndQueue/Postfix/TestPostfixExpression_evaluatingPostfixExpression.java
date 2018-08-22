package Postfix;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * @author Niraj Gupta
 * Parameterized Junit Test Case Class to check if the postfix evaluation is working properly or not.
 * 
 *
 */
@RunWith(Parameterized.class)
public class TestPostfixExpression_evaluatingPostfixExpression{
	private String expression;
	private int expectedResult;
	private PostfixExpression postfix;
	
	/**
	 * Parameterized Constructor : To assign the postfix expression and the result
	 * @param expression : The user entered postfix expression for evaluation 
	 * @param expectedResult : The expected outcome after the successful evaluation of the postfix expression 
	 */
	public TestPostfixExpression_evaluatingPostfixExpression(String expression, int expectedResult){
		this.expression = expression;
		postfix = new PostfixExpression(this.expression);
		this.expectedResult = expectedResult;
	}
	
	/**
	 * Parameterized Junit Test Cases.
	 * @return : The ArrayList object containing the expression and the expected outcome
	 */
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{ "2 3 4 + * 6 -", 8 },
				{ "2 3 1 * + 9 -", -4 },
				{ "100 200 + 2 / 5 * 7 +", 757 }
		});
	}
	
	/**
	 * Method to test the evaluatingPostfixExpression() from the class PostfixExpression
	 */
	@Test
	public void evaluatingPostfixExpression_HappyFlow(){
		assertEquals(expectedResult, postfix.evaluatingPostfixExpression());
		}
}
