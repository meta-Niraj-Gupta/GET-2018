package MultiVariatePolynomialUsingNestedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj gupta
 * Class to represent the Multivariate Polynomial using list.
 */
public class MultiVariatePolynomial {
	List<Term> terms;

	/**
	 * Non-Parameterized Constructor.
	 */
	public MultiVariatePolynomial() {
		terms = new ArrayList<Term>();
	}

	/**
	 * Method to add Term to the multivariate polynomial list.
	 * @param term : The term which is to be added.
	 * @return : True if the term is added successfully, false otherwise.
	 */
	public boolean addTerm(Term term) {
		return terms.add(term);
	}

	/**
	 * Method to remove Term from the multivariate polynomial list.
	 * @param term : The term which is to be removed.
	 * @return : True if the term is removed successfully, false otherwise.
	 */
	public boolean removeTerm(Term term) {
		return terms.add(term);
	}

	/**
	 * Method to get the list of terms.
	 * @return : The list of terms.
	 */
	public List<Term> getListOfTerm() {
		return this.terms;
	}

	/**
	 * Method to get the Polynomial.
	 * @return : The string of polynomial.
	 */
	public String getPolynomial() {
		String polynomial = "";
		for(int i = 0; i < terms.size(); i++){
			if(i == terms.size()-1){
				polynomial += terms.get(i).getTerm();
			}else{
				polynomial += terms.get(i).getTerm() + " + ";
			}
		}
		return polynomial;
	}
}
