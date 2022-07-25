package Advanced.StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P09CopyPicture {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outPath = "C:\\Users\\Kadiev\\Desktop\\SoftUni\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";

        InputStream in = new FileInputStream(inPath);
        OutputStream out = new FileOutputStream(outPath);

        byte[] allBytes = in.readAllBytes();
        out.write(allBytes);
    }
}
