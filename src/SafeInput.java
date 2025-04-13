import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";

        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                if (retInt >= low && retInt <= high) {
                    done = true;
                } else {
                    System.out.println("Input is out of range.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pipe.nextLine(); // clear invalid input
            }
        } while (!done);

        return retInt;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();

            if (response.equals("Y") || response.equals("N")) {
                valid = true;
            } else {
                System.out.println("Please enter Y or N.");
            }
        } while (!valid);

        return response.equals("Y");
    }
}
