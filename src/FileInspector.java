import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File("src"));
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                    charCount += line.length();
                    System.out.println(line); // Echo the line
                }

                System.out.println("\n--- File Summary ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Lines: " + lineCount);
                System.out.println("Words: " + wordCount);
                System.out.println("Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
