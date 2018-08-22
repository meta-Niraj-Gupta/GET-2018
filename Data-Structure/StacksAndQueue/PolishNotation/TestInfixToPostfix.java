package PolishNotation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Postfix.PostfixExpression;

@RunWith(Parameterized.class)
public class TestInfixToPostfix{
	private String expression;
	private String expectedResult;
	private InfixToPostfix postfix;
		
	public TestInfixToPostfix(String expression, String expectedResult){
		this.expression = expression;
		postfix = new InfixToPostfix(this.expression);
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Object[]> testCases(){
		return Arrays.asList(new Object[][]{
				//Positive Test Cases
				{ "a + b * ( c ^ d - e ) ^ ( f + g * h ) - i", "a b c d ^ e - f g h * + ^ * + i -" },
				{ "( A + B ) * ( C + D )", "A B + C D + *" },
				{ "A + B + C + D", "A B + C + D +" },
				{ "( Ax + By ) * C - ( D - E ) * ( F + G )", "Ax By + C * D E - F G + * -" },
				{ "( a || b ) && ( c || d )", "a b || c d || &&" },
				{ "( ( a <= b ) || ( b >= c ) ) && ( a != c )", "a b <= b c >= || a c != &&"}
		});
	}
	
	@Test
	public void convertFromInfixToPostfix_HappyFlow(){
		assertEquals(expectedResult, postfix.convertFromInfixToPostfix());
	}
	
}
