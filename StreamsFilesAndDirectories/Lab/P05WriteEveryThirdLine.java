package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader in = new BufferedReader(new FileReader(inputPath));
        PrintWriter out = new PrintWriter(new FileWriter(outputPath));

        int counter = 1;
        String line;
        while ((line = in.readLine()) != null) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
        }

        out.close();

    }
}
