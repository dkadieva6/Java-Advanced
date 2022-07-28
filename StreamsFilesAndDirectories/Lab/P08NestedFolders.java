package Advanced.StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {
        File root = new File("C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        System.out.println(root.getName());
        int countDirectories = 1;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File f : Objects.requireNonNull(nestedFiles)) {
                if (f.isDirectory()) {
                    dirs.offer(f);
                    System.out.println(f.getName());
                    countDirectories++;
                }
            }
        }

        System.out.println(countDirectories + " folders");
    }
}
