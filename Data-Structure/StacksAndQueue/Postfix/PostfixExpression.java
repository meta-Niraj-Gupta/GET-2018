package Postfix;

import StackDataStructure.Stack;
import StackDataStructure.StackUsingArray;

/**
 * @author Niraj Gupta
 * Class to evaluate postfix expression. Using the stack interface we have created in the first assignment.
 */
public class PostfixExpression {
	private String expression;
	private Stack<Integer> stack;
	
	/**
	 * Parameterized Constructor
	 * @param expression : The user provided string of postfix expression which is to be evaluated.
	 */
	public PostfixExpression(String expression) {
		this.expression = expression;
		stack = new StackUsingArray<Integer>(expression.length());
	}
	
	/**
	 * Method to evaluate the postfix expression.
	 * @return : The result after evaluation of the postfix expression.
	 */
	public int evaluatingPostfixExpression(){
		for(int i = 0; i < expression.length(); i++){
			char character = expression.charAt(i);
				
			if(character == ' '){
				continue;
			}else if(Character.isDigit(character)){
				int sum = 0;
				//If the number contains more than one digit
				while(Character.isDigit(character)){
					sum = sum * 10 + (int) (character - '0');
					i++;
					character = expression.charAt(i);
				}
				i--;
				stack.push(sum);	//Push the number on the stack
			}else{
				//If an operator is encountered pop two elements form the stack for performing operation.
				int topElement1 = stack.pop();
				int topElement2 = stack.pop();
		
				if(character == '+'){
					stack.push(topElement2 + topElement1);
				}else if(character == '-'){
					stack.push(topElement2 - topElement1);
				}else if(character == '*'){
					stack.push(topElement2 * topElement1);
				}else{
					stack.push(topElement2 / topElement1);
				}
			}
		}
		return stack.pop();
	}
}
