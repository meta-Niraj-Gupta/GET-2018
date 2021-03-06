package MultiVariatePolynomialUsingNestedList;

import static org.junit.Assert.*;

import org.apache.poi.util.Beta;
import org.junit.Before;
import org.junit.Test;

public class TestMultiVariatePolynmial{
	MultiVariatePolynomial multiVariatePolynomial;

	@Before
	public void setUp(){
		multiVariatePolynomial = new MultiVariatePolynomial();
		Variable variable1 = new Variable('a', 3);
		Variable variable2 = new Variable('b', 5);
		Variable variable3 = new Variable('c', 7);
		Variable variable4 = new Variable('d', 3);
		Variable variable5 = new Variable('e', 5);
		Variable variable6 = new Variable('f', 5);

		Term term1 = new Term(4);
		term1.addVariable(variable1);
		term1.addVariable(variable4);
		term1.addVariable(variable3);

		Term term2 = new Term(5);
		term2.addVariable(variable2);
		term2.addVariable(variable4);

		Term term3 = new Term(6);
		term3.addVariable(variable5);
		term3.addVariable(variable6);

		multiVariatePolynomial.addTerm(term1);
		multiVariatePolynomial.addTerm(term2);
		multiVariatePolynomial.addTerm(term3);
	}

	@Test
	public void getPolynomial_HappyFlow(){
		String actualResult = multiVariatePolynomial.getPolynomial();
		String ExpectedResult = "4(a^3d^3c^7) + 5(b^5d^3) + 6(e^5f^5)";
		assertEquals(ExpectedResult, actualResult);
	}
}
