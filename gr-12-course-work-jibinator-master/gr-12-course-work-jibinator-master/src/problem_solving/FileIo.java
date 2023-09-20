package problem_solving;

import java.io.*;
import java.util.Scanner;

public class FileIo {
    public static void main(String[] args) throws IOException {
        Scanner myInput = new Scanner(System.in);
        File originalFile = new File("highscores.txt");
        String newInfo = "stuff - 100";
        System.out.println("What line do you want the input to be in");
        int wantedLine = myInput.nextInt();
        
        // Create a temporary file to store the modified data
        File temp = new File("temp.txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(temp));
             BufferedReader reader = new BufferedReader(new FileReader(originalFile))) {

            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                count++;
                if (count == wantedLine) {
                    writer.println(newInfo);
                }
                writer.println(line);
                line = reader.readLine();
            }
        }
        
        // Replace the original file with the temporary file
        originalFile.delete();
        temp.renameTo(originalFile);
    }
}
