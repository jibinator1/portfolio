package problem_solving;

import java.io.*;

public class EndOfFielDemo {

	public static void main(String[] args) throws IOException {
		FileReader myInputFile = new FileReader("myTextFileName.txt");
		BufferedReader myInput= new BufferedReader(myInputFile);
		//collects the information from the file
		int counter =0;
		String line = myInput.readLine();
		
		while(line !=null) {
			counter++;
			line = myInput.readLine();
		}
		System.out.println("There were "+counter+" lines in the file.");
		myInput.close();

	}

}
