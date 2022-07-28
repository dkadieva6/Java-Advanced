package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {
        String inPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        Set<Character> punctuations = new HashSet<>();
        Collections.addAll(punctuations, ',', '.', '!', '?');

        try (InputStream in = new FileInputStream(inPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                if (!punctuations.contains((char) oneByte)) {
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
