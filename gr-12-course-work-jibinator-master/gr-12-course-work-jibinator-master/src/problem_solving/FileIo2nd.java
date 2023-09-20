package problem_solving;

import java.io.*;
import java.util.Scanner;


public class FileIo2nd {

	public static void main(String[] args) throws IOException {
	     Scanner scanner = new Scanner(System.in);

		FileWriter myWriter = new FileWriter("multiple entries.txt");
		PrintWriter myPrinter = new PrintWriter(myWriter);
		
			System.out.println("What is the name of the object? (seperate by space)");//finds all the objects the user wants
			String nameObject1 = scanner.nextLine();
			System.out.println("What is the price of the object? (seperate by space)");//finds all the prices of the objects the user wants
			String priceObject1 = scanner.nextLine();
			
		String[] nameObject=nameObject1.split(" ");//makes it into an array seperated by a space
		String[] priceObject=priceObject1.split(" ");//makes it into an array seperated by a space

		myPrinter.print("Name of Objects: ");
		for (int i=0;i<nameObject.length;i++) {
			myPrinter.print(nameObject[i]+", ");//prints out the name of the objects
		}

		myPrinter.print("\nPrice of Objects: ");
		for (int i=0;i<nameObject.length;i++) {
			myPrinter.print("$"+priceObject[i]+", ");//prints out the price ofthe objects
		}
		int[] intPriceObject=new int[priceObject.length];//creates an int array to make the string array in the priceObject into an int
		 for(int i=0; i<priceObject.length; i++) {
	         intPriceObject[i] = Integer.parseInt(priceObject[i]);//makes all the price objectsinto an int array
	      }
		myPrinter.print("\nReceipt: ");
		int totalPrice=0;
		for (int i=0;i<nameObject.length;i++) {
			myPrinter.print("Your price for "+ nameObject[i] + " costs $" + intPriceObject[i]+", ");
			totalPrice=totalPrice+intPriceObject[i];
			
		}
		myPrinter.print("\nYour total comes to: $"+totalPrice);
		
		
		myPrinter.close();
		scanner.close();


	}

}
