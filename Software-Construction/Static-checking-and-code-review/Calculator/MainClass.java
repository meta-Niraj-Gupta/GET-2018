package Calculator;

import java.util.Scanner;

/**
 * @author Niraj Gupta
 * This is the main class containing main function to check the functionality of the HexCalc.
 *
 */
public class MainClass {
	public static void main(String[] args) throws CannotSubtractException{
		HexCalc hexCalc = new HexCalc();
		String inputHexNumber1 = "";
		String inputHexNumber2 = "";
		Scanner scan = new Scanner(System.in);
		char repeat;
		do{
			System.out.println("Operations you can perform on Hexadecimal number");
			System.out.println("Press 1 for Addition");
			System.out.println("Press 2 for Subtraction");
			System.out.println("Press 3 for Multiplication");
			System.out.println("Press 4 for Division");
			System.out.println("Press 5 for Comparing Equality");
			System.out.println("Press 6 for Comparing Greater Than");
			System.out.println("Press 7 for Comparing Less Than");
			System.out.println("Press 8 to Convert from hexadecimal to decimal");
			System.out.println("Press 9 to Convert from decimal to hexadecimal");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			if(choice > 0 && choice < 8){
				System.out.println("Enter first hex number");
				inputHexNumber1 = scan.next();
				System.out.println("Enter second hex number");
				inputHexNumber2 = scan.next();
			}
			switch(choice){
			
			case 1:
				System.out.println("Addition of " + inputHexNumber1 + " and " + inputHexNumber2 + " is " + 
									hexCalc.add(inputHexNumber1, inputHexNumber2));
				break;
			
			case 2: 
				System.out.println("Subtraction of " + inputHexNumber1 + " and " + inputHexNumber2 + " is " + 
										hexCalc.subtract(inputHexNumber1, inputHexNumber2));
				break;
			
			case 3:
				System.out.println("Multiplication of " + inputHexNumber1 + " and " + inputHexNumber2 + " is " + 
									hexCalc.multiply(inputHexNumber1, inputHexNumber2));
				break;
			
			case 4:
				try{
					System.out.println("Division of " + inputHexNumber1 + " and " + inputHexNumber2 + " is " + 
										hexCalc.divide(inputHexNumber1, inputHexNumber2));
				}catch(ArithmeticException exception){
					System.out.println(exception.getMessage());
				}
				break;
			
			case 5:
				if(hexCalc.equalsTo(inputHexNumber1, inputHexNumber2)){
					System.out.println("Both are equal");
				}else{
					System.out.println("Both are different.");
				}
				break;
			
			case 6:
				if(hexCalc.greaterThan(inputHexNumber1, inputHexNumber2)){
					System.out.println(inputHexNumber1 + " is greater than " + inputHexNumber2);
				}else{
					System.out.println(inputHexNumber2 + " is greater than " + inputHexNumber1);
				}
				break;
			
			case 7:
				if(hexCalc.lessThan(inputHexNumber1, inputHexNumber2)){
					System.out.println(inputHexNumber1 + " is less than " + inputHexNumber2);
				}else{
					System.out.println(inputHexNumber2 + " is less than " + inputHexNumber1);
				}
				break;
				
			case 8:
				System.out.println("Enter hex number to convert in decimal");
				String str = scan.next();
				System.out.println("Conversion from hexadecimal to decimal of " + str + " is " 
									+ hexCalc.convertFromHexToDecimal(str));
				break;
				
			case 9:
				System.out.println("Enter decimal number to convert in hexadecimal");
				Integer string = scan.nextInt();
				System.out.println("Conversion from decimal to hexadecimal of " + string + " is " 
									+ hexCalc.convertFromDecimalToHex(string));
				break;
				
			default:
				System.out.println("Enter a Valid choice from the menu.");
			}
			System.out.println("Press y to continue: ");
			repeat = scan.next().charAt(0);
		}while(repeat == 'y');
		scan.close();
	}
}
