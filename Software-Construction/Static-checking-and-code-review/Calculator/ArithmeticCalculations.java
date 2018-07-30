package Calculator;

/**
 * @author Niraj Gupta
 * This is an Interface having the following methods:
 * 1. add() it accepts 2 parameter of type string and return addition as a string
 * 2. subtract() it accepts 2 parameter of type string and return subtraction as a string
 * 3. multiply() it accepts 2 parameter of type string and return multiplication as a string
 * 4. divide() it accepts 2 parameter of type string and return division as a string
 * 5. equalsTo() it accepts 2 parameter of type string and return true if both string are equal, false otherwise
 * 6. greaterThan() it accepts 2 parameter of type string and return true if first string is greater than second, false otherwise
 * 7. subtract() it accepts 2 parameter of type string and return true if first string is less than second, false otherwise
 */
public interface ArithmeticCalculations {
	String add(String value1, String value2);
	String subtract(String value1, String value2) throws CannotSubtractException;
	String multiply(String value1, String value2);
	String divide(String value1, String value2);
	boolean equalsTo(String value1, String value2);
	boolean greaterThan(String value1, String value2);
	boolean lessThan(String value1, String value2);
}
