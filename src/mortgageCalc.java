import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalc {
	
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		final int MONTHS = 12;
		final int PERCENT = 100;
		
		int principal = setPrincipal();
		float interest = setInterest()/PERCENT/MONTHS;
		int period = setPeriod()*MONTHS;
		
		userInput.close();
		
		calcTotal(principal, period, interest);
	}
	
	private static int setPrincipal() {
		int principal;
		
		while(true){
			System.out.println("Enter principal (between $1K and $1M): ");
			try {
				principal = Integer.parseInt(userInput.next()); //Attempt to convert to a integer.
				
				if (principal >= 1000 && principal <= 1_000_000){
					break;	//If the input converts properly the loop will stop here.
				}
			}
			catch(Exception e){
				System.out.println("Invalid input.");
			}
		}
		
		return principal;
	}
	
	private static byte setPeriod() {
		byte period;
		
		while(true){
			System.out.println("Enter period (between 1 to 30 years): ");
			try {
				period = Byte.parseByte(userInput.next());	//Attempt to convert to a integer.
				
				if (period >= 1 && period <= 30){
					break;	//If the input converts properly the loop will stop here.
				}
			}
			catch(Exception e){
				System.out.println("Invalid input.");
			}
		}
		
		return period;
	}

	private static float setInterest() {
		float interest;
		
		while(true){
			System.out.println("Enter interest rate (between 1 and 100): ");
			try {
				interest = Float.parseFloat(userInput.next());
				
				if (interest >= 1 && interest <= 100){	//Attempt to convert to a float.
					break;	//If the input converts properly the loop will stop here.
				}
			}
			catch(Exception e){
				System.out.println("Invalid input.");
			}
		}
		
		return interest;
	}

	private static void calcTotal(int principal, int period, float interest) {
		double mortgage = principal*(interest*(Math.pow(1+interest, period))/(Math.pow(1 + interest, period) - 1));
		NumberFormat numForm = NumberFormat.getCurrencyInstance();
		
		System.out.println("Total: " + numForm.format(mortgage));
	}
}