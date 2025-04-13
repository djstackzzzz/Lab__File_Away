import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int id = 1;

        boolean done = false;
        while (!done) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String formattedId = String.format("%06d", id++);
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int year = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2024);

            String record = firstName + ", " + lastName + ", " + formattedId + ", " + email + ", " + year;
            records.add(record);

            done = !SafeInput.getYNConfirm(in, "Add another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter CSV file name (without extension)") + ".csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            for (String rec : records) {
                writer.println(rec);
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
