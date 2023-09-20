package problem_solving;

import java.util.Scanner;

public class Even_fibonacci_numbers {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);

		/*set the variable num1 to 0 and num2 to 1*/
		int  num1 = 1;
		int num2 = 1;
		int total=0;
		/*Set a for loop for the equation so it happens the amount you want it to*/
		/* just increase the number in the middle */
		do {
		
				int sumOfNum1andNum2= num1 + num2;
				num1 = num2;
				num2 = sumOfNum1andNum2;
				total+=sumOfNum1andNum2;
				if (sumOfNum1andNum2%2==0) 
				{
					total+=sumOfNum1andNum2;
				}
			
		}while(total<4000000);
		System.out.print(total+3);
	}
}

