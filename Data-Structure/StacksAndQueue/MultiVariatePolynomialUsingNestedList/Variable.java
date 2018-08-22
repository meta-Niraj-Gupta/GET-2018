package MultiVariatePolynomialUsingNestedList;

/**
 * @author Niraj gupta
 * Class to represent the variable used in a polynomial.
 */
public class Variable{
	private char variableSymbol;
	private int power;
	
	/**
	 * Parameterized Constructor.
	 * @param variableSymbol : The character used as a variable.
	 * @param power : The power of the variable.
	 */
	public Variable(char variableSymbol, int power) {
		this.variableSymbol = variableSymbol;
		this.power = power;
	}
	
	public char getVariableSymbol() {
		return variableSymbol;
	}

	public int getPower() {
		return power;
	}
}
