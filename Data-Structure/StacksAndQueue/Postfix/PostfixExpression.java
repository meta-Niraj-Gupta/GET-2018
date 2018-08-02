package Postfix;

public class PostfixExpression {
	private int[] stack;
	private String expression;
	private int topOfStack;
	
	public PostfixExpression(String expression){
		this.expression = expression;
		topOfStack = -1;
		stack = new int[expression.length()];
	}
	
	public int evaluatingPostfixExpression(){ 
		for(int i = 0; i < expression.length(); i++){
			char character = expression.charAt(i);
			
			if(character == ' '){
				continue;
			}else if(Character.isDigit(character)){
				int sum = 0;
				while(Character.isDigit(character)){
					sum = sum * 10 + (int) (character - '0');
					i++;
					character = expression.charAt(i);
				}
				i--;
				stack[++topOfStack] = sum;
			}else{
				int topElement1 = stack[topOfStack--];
				int topElement2 = stack[topOfStack--];
				
				if(character == '+'){
					stack[++topOfStack] = topElement2 + topElement1;
				}else if(character == '-'){
					stack[++topOfStack] = topElement2 - topElement1;
				}else if(character == '*'){
					stack[++topOfStack] = topElement2 * topElement1;
				}else{
					stack[++topOfStack] = topElement2 / topElement1;
				}
			}
		}
		return stack[topOfStack--];
	}
}
