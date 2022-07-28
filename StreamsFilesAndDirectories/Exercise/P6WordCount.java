package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P6WordCount {
    public static void main(String[] args) throws IOException {
        Path words = Paths.get("C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path text = Paths.get("C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        String results = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        PrintWriter writer = new PrintWriter(new FileWriter(results));
        Map<String, Integer>  wordsInFile = new HashMap<>();
        Arrays.stream(Files.readString(words).split("\\s+")).forEach(s -> wordsInFile.put(s, 0));
        Arrays.stream(Files.readString(text).split("\\s+"))
                .forEach(s -> {
                    if (wordsInFile.containsKey(s)) {
                        wordsInFile.put(s, wordsInFile.get(s) + 1);
                    }
                });

        wordsInFile.entrySet().stream().sorted(Map.Entry
                .comparingByValue(Comparator.reverseOrder()))
                        .forEach(s -> writer.println(s.getKey() + " - " + s.getValue()));
        writer.close();
    }
}
