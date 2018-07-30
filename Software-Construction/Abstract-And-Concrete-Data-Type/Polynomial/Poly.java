package Polynomial;

/**
 * @author Niraj Gupta
 * Class to perform operation on polynomial of degree n. It can perform operations like
 * finding the degree of the polynomial, it can evaluate the polynomial for a particular value
 * and can also calculate the sum and multiplication of two polynomials.
 * The class is immutable.
 */
public final class Poly{
	private final int[] polynomial;
	
	/**
	 * Default Constructor
	 */
	public Poly(){
		this.polynomial = new int[0];
	}
	
	/**
	 * Parameterized Constructor
	 * @param array : the array containing the non-zero coefficient of the polynomials
	 */
	public Poly(int[] array){
		this.polynomial = array;
	}
	
	/**
	 * Method to evaluate the polynomial for a certain value passed by the user
	 * @param valueOfVariable : is the value of variable say X passed by user
	 * @return : the result after putting the value of variable and evaluating the polynomial.
	 */
	public int evaluate(int valueOfVariable){
		if(polynomial.length == 0){
			throw new IllegalArgumentException("The polynomial array is empty");
		}
		int sum = polynomial[0];
		for(int i = 1; i < polynomial.length; i++){
			sum += polynomial[i] * Math.pow(valueOfVariable, i);
		}
		return sum;
	}
	
	/**
	 * Method to get the degree of the polynomial.
	 * @return : the degree of the polynomial
	 */
	public int degree(){
		return polynomial.length - 1;
	}
	
	/**
	 * Method to get the polynomial array
	 * @return : the polynomial array
	 */
	public int[] getPolynomialArray(){
		return this.polynomial;
	}
	
	/**
	 * Method to add two polynomial
	 * @param inputPoly : the first polynomial array
	 * @param polyInput : the second polynomial array
	 * @return : the addition of the above two parameters
	 */
	public Poly addPoly(Poly inputPoly, Poly polyInput){
		if(inputPoly.polynomial.length == 0 || polyInput.polynomial.length == 0){
			throw new IllegalArgumentException("Invalid Input: The polynomial array is empty. Please Enter a valid input");
		}
		int[] addPoly = new int[(inputPoly.polynomial.length > polyInput.polynomial.length) 
		                        ? inputPoly.polynomial.length : polyInput.polynomial.length];
		int i = 0, j = 0, k = 0;
		while(i < inputPoly.polynomial.length && j < polyInput.polynomial.length){
			addPoly[k++] = inputPoly.polynomial[i++] + polyInput.polynomial[j++];
		}
		while(i < inputPoly.polynomial.length){
			addPoly[k++] = inputPoly.polynomial[i++];
		}
		while(j < polyInput.polynomial.length){
			addPoly[k++] = polyInput.polynomial[j++];
		}
		return new Poly(addPoly);
	}
	
	/**
	 * Method to calculate the multiplication of two polynomial
	 * @param inputPoly : is the first polynomial
	 * @param polyInput : is the second polynomial
	 * @return : the multiplication of above two polynomials
	 */
	public Poly multiplyPoly(Poly inputPoly, Poly polyInput){
		if(inputPoly.polynomial.length == 0 || polyInput.polynomial.length == 0){
			throw new IllegalArgumentException("Invalid Input: The polynomial array is empty. Please Enter a valid input");
		}
		int degreeOfInputPoly = inputPoly.degree()+1;
		int degreeOfPolyInput = polyInput.degree()+1;
		int[] multiplyPoly = new int[degreeOfInputPoly + degreeOfPolyInput - 1];
		for(int i = 0; i < inputPoly.polynomial.length; i++){
			for(int j = 0; j < polyInput.polynomial.length; j++){
				multiplyPoly[i+j] += inputPoly.polynomial[i] * polyInput.polynomial[j];
			}
		}
		return new Poly(multiplyPoly);
	}
}
