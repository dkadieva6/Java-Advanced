package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt";
        String outPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inPath));
        PrintWriter writer = new PrintWriter(new FileWriter(outPath));

        String line;
        int count = 1;
        while ((line = reader.readLine()) != null) {
            writer.println(count + ". " + line);
            count++;
        }

        writer.close();
    }
}
