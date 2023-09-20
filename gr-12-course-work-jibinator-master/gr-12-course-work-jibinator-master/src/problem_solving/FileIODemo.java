package problem_solving;

import java.io.*; 
public class FileIODemo {
	public static void main(String[] args) throws IOException {
		
		FileWriter myWriter = new FileWriter("myTextFileName.txt");
		PrintWriter myPrinter = new PrintWriter(myWriter);
		
		myPrinter.println("I made a file");//write lines to text to the file
		myPrinter.println("I put a text in it");
		
		myPrinter.close();
	}
}
