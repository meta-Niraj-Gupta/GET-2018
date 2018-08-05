package PolishNotation;

import StackDataStructure.Stack;
import StackDataStructure.StackUsingArray;

/**
 * @author Niraj Gupta
 * Class to convert infix expression into postfix expression.
 */
public class InfixToPostfix{
	private String infixExpression;
	Stack<String> stack;
	
	/**
	 * Parameterized Constructor
	 * @param infixExpression : To be converted into postfix
	 */
	public InfixToPostfix(String infixExpression){
		this.infixExpression = infixExpression;
		stack = new StackUsingArray<String>(this.infixExpression.length());
	}
	
	/**
	 * Method to check if the given string is a operator or not. 
	 * @param operator : The string to be checked whether it is operator or not.
	 * @return : True if it is operator, false otherwise.
	 */
	private static boolean isOperator(final String operator){
		switch(operator){
		case "+":
		case "-":
		case "^":
		case "*":
		case "/":
		case "==":
		case "!=":
		case "<":
		case ">":
		case ">=":
		case "<=":
		case "&&":
		case "||":
			return true;
		}
		return false;
	}
	
	/**
	 * Method to convert the infix expression to postfix expression.
	 * @return : The string of postfix expression.
	 */
	public String convertFromInfixToPostfix(){
		String postfixExpression = "";
		String[] expression = infixExpression.trim().split(" ");
		for(int i = 0; i < expression.length; i++){
			if(isOperator(expression[i])){
				while(!stack.isEmpty() && checkPrecedence(expression[i]) <= checkPrecedence(stack.getTopElement())){
					postfixExpression += stack.pop() + " ";
				}
				stack.push(expression[i]);
			}else if("(".equals(expression[i])){
				stack.push(expression[i]);
			}else if(")".equals(expression[i])){
				while(!stack.isEmpty() && !("(".equals(stack.getTopElement()))){
					postfixExpression += stack.pop() + " ";
				}
                stack.pop();
			}else{
				postfixExpression += expression[i] + " ";
            }
		}
		while(!stack.isEmpty()){
			postfixExpression += stack.pop() + " ";
		}
      
        return postfixExpression.trim();
	}
	
	/**
	 * Method to check the precedence of the operator. Bigger value, greater precedence. 
	 * @param operator : The operator like arithmetic, relational, logical etc.
	 * @return : The precedence of the operator.
	 */
	private static int checkPrecedence(final String operator){
		switch(operator){
		case "||":
			return 0;
		case "&&":
			return 1;
		case "==":
		case "!=":
			return 2;
		case "<":
		case ">":
		case ">=":
		case "<=":
			return 3;
		case "+":
		case "-":
			return 4;
		case "*":
		case "/":
			return 5;
		case "^":
			return 6;
		}
		return -1;
	}
}
