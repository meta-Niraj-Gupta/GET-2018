package MultiVariatePolynomialUsingNestedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to represent the term of an polynomial.
 *
 */
public class Term{
	int coefficient;
	List<Variable> variables;

	/**
	 * Parameterized Constructor.
	 * @param coefficient : The coefficient of the term.
	 */
	public Term(int coefficient){
		this.coefficient = coefficient;
		variables = new ArrayList<Variable>();
	}

	/**
	 * Method to add variable to the term.
	 * @param variable : The variable which is to be added to the list.
	 * @return : True if the variable is added, false otherwise.
	 */
	public boolean addVariable(Variable variable){
		return variables.add(variable);
	}

	/**
	 * Method to delete variable form the term.
	 * @param variable : The variable which is to be deleted.
	 * @return : True if the variable is deleted, false otherwise.
	 */
	public boolean deleteVariable(Variable variable){
		return variables.remove(variable);
	}

	/**
	 * Method to get the string representing the term.
	 * @return : The string of term containing variable and its power.
	 */
	public String getTerm(){
		String termString = "";
		termString += coefficient + "(";
		for(Variable variable: variables){
			termString += variable.getVariableSymbol() + "^" + variable.getPower();
		}
		return  termString + ")";
	}
}
