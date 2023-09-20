package problem_solving;

import java.io.*;

public class FileModificationExample {
	    public static void main(String[] args) throws IOException {
	    	
	    }
	    public static void addMiddle() throws IOException {
	        File file = new File("highscores.txt");
	        RandomAccessFile raf = new RandomAccessFile(file, "rw");
	        int position=3;//if i want the position to be equal to 3
	        
	        // Read the first half of the file (idk about the math I just tried random integers to add and subtrtact and it worked
	        byte[] firstHalf = new byte[(int) ((file.length()-(file.length()-position)+1)) ];
	        raf.read(firstHalf);

	        // Read the other half of the file and copies it
	        byte[] secondHalf = new byte[(int) file.length() - firstHalf.length];
	        raf.read(secondHalf);

	        //Sets the string middle as what I want to input into the file
	        String middle = "userInput";
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        outputStream.write(firstHalf);//writes the first half
	        outputStream.write(middle.getBytes());//writes the middle as I wanted
	        outputStream.write(secondHalf);//writes the rest
	        byte[] modifiedFileContent = outputStream.toByteArray();

	        // Write the modified file content back to the file
	        raf.seek(0);
	        raf.write(modifiedFileContent);

	        raf.close();
	    	}
	    public static void addEnd() throws IOException{
	    	File file = new File("append.txt");
	    	FileWriter fr = new FileWriter(file, true);
	    	fr.write("\nuserInput");
	    	fr.close();
	    }
	}
