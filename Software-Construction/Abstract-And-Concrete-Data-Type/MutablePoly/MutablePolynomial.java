package MutablePoly;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Niraj Gupta
 * Class to perform operation on polynomial of degree n. It can perform operations like
 * finding the degree of the polynomial, it can evaluate the polynomial for a particular value, can 
 * add and remove elements dynamically and can also calculate the sum and multiplication of two polynomials.
 * The class is mutable.
 */
public class MutablePolynomial{
	
	private Map<Integer, Integer> polynomial;
	
	/**
	 * Parameterized Constructor to load map with polynomial
	 * @param array : the array containing the non-zero coefficient of the polynomials
	 */
	public MutablePolynomial(int[] array){
		polynomial = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; i++){
			if(array[i] != 0){
				polynomial.put(i, array[i]);
			}
		}
	}
	
	/**
	 * Method to evaluate the polynomial for a certain value passed by the user
	 * @param valueOfVariable : is the value of variable say X passed by user
	 * @return : the result after putting the value of variable and evaluating the polynomial.
	 */
	public int evaluate(int valueOfVariable){
		if(polynomial.isEmpty()){
			throw new IllegalArgumentException("The Hash Map containing polynomial is empty");
		}
		int sum = polynomial.get(0);
		for(Map.Entry<Integer, Integer> poly : polynomial.entrySet()){  
			   sum += (int) poly.getValue() * Math.pow(valueOfVariable, (int) poly.getKey());  
		}  
		return sum;
	}
	
	/**
	 * Method to get the degree of the polynomial.
	 * @return : the degree of the polynomial
	 */
	public int degree(){
		int maximum = 0;
		for(Map.Entry<Integer, Integer> poly : polynomial.entrySet()){
			if(maximum < poly.getKey()){
				maximum = poly.getKey();
			}
		}
		return maximum;
	}
	
	/**
	 * Method to get the polynomial array
	 * @return : the polynomial array
	 */
	public Map<Integer, Integer> getPolynomialArray(){
		return polynomial;
	}
	
	/**
	 * Method to add two polynomial
	 * @param inputPoly : the first polynomial array
	 * @param polyInput : the second polynomial array
	 * @return : the addition of the above two parameters
	 */
	public MutablePolynomial addPoly(MutablePolynomial inputPoly, MutablePolynomial polyInput){ 
		int size = inputPoly.degree();
		int length = polyInput.degree();
		if(size == 0 || length == 0){
			throw new IllegalArgumentException("Invalid Input: The polynomial array is empty. Please Enter a valid input");
		}
		int[] addPoly = new int[(size > length) ? size + 1 : length + 1];
		int i = 0, j = 0, k = 0;
		while(i < size && j < length){
			addPoly[k++] = inputPoly.polynomial.get(i++) + polyInput.polynomial.get(j++);
		}
		while(i < size){
			addPoly[k++] = inputPoly.polynomial.get(i++);
		}
		while(j < length){
			addPoly[k++] = polyInput.polynomial.get(j++);
		}
		return new MutablePolynomial(addPoly);
	}
	
	/**
	 * Method to calculate the multiplication of two polynomial
	 * @param inputPoly : is the first polynomial
	 * @param polyInput : is the second polynomial
	 * @return : the multiplication of above two polynomials
	 */
	public MutablePolynomial multiplyPoly(MutablePolynomial inputPoly, MutablePolynomial polyInput){
		if(inputPoly.degree() == 0 || polyInput.degree() == 0){
			throw new IllegalArgumentException("Invalid Input: The polynomial array is empty. Please Enter a valid input");
		}
		int degreeOfInputPoly = inputPoly.degree();
		int degreeOfPolyInput = polyInput.degree();
		int[] multiplyPoly = new int[degreeOfInputPoly + degreeOfPolyInput];
		for(int i = 0; i < degreeOfInputPoly; i++){
			for(int j = 0; j < degreeOfPolyInput; j++){
				multiplyPoly[i+j] += inputPoly.polynomial.get(i) * polyInput.polynomial.get(j);
			}
		}
		return new MutablePolynomial(multiplyPoly);
	}
	
	/**
	 * Method to add members to the polynomial
	 * @param power : is the power of the polynomial and is also the key to which the value is associated
	 * @param variable : is the value which is attached to a key
	 * @return : the new polynomial map having new value added
	 */
	public Map<Integer, Integer> add(int power, int variable){
		if(polynomial.containsKey(power)){
			throw new AssertionError("Invalid Input : The map already contains the key. The value cannot be replaced");
		}else{
			polynomial.put(power, variable);
		}
		return polynomial;
	}
	
	/**
	 * Method to delete the element from the map
	 * @param power : is the power of the polynomial and is also the key to which the value is associated
	 * @param variable : is the value which is attached to a key
	 * @return : the new polynomial map having value removed
	 */
	public Map<Integer, Integer> delete(int power, int variable){
		if(polynomial.containsKey(power)){
			polynomial.remove(power);
		}else{
			throw new AssertionError("Invalid Input : The map doesn't contain the key.");
		}
		return polynomial;
	}
}