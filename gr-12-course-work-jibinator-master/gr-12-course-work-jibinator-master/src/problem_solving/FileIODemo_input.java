package problem_solving;

import java.io.*;

public class FileIODemo_input {
    public static void main(String[] args) {
        // Open the file for reading
        File file = new File("highscores.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder builder = new StringBuilder();
            int lineNumber = 3; // Insert the new line after the 3rd line
            
            // Read the file line by linew
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
                if (--lineNumber == 0) {
                    // Insert the new line here
                    builder.append("Jibin: 100\n");
                }
            }
            reader.close();
            
            // Write the modified contents back to the file
            FileWriter writer = new FileWriter(file);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
