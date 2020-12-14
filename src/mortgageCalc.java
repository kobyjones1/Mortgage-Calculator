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
			System.out.println("Enter principal: ");
			try {
				principal = Integer.parseInt(userInput.next());	//Attempt to convert to a integer.
				break;	//If the input converts properly the loop will stop here.
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
			System.out.println("Enter period (in years): ");
			try {
				period = Byte.parseByte(userInput.next());	//Attempt to convert to a integer.
				break;	//If the input converts properly the loop will stop here.
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
			System.out.println("Enter interest rate: ");
			try {
				interest = Float.parseFloat(userInput.next());	//Attempt to convert to a double.
				break;	//If the input converts properly the loop will stop here.
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