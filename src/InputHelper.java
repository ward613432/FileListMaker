import java.util.Scanner;
public class InputHelper {
    public static int getInt(Scanner in, String prompt) {
        boolean verify = false;
        int input = 0;
        System.out.println(prompt);
        do {
            if (in.hasNextInt()) {
                input = in.nextInt();
                verify = true;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); // clear buffer
        } while (!verify);
        return input;
    }

    public static int getRangedInt(Scanner in, String prompt, int min, int max){
        boolean verify = false;
        int input = 0;
        System.out.println(prompt);
        do {
            if (in.hasNextInt()) {
                input = in.nextInt();
                if (input >= min && input <= max) {
                    verify = true;
                }
                else {
                    System.out.println("Out of range. Please try again.");
                }
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); // clear buffer
        } while (!verify);
        return input;
    }

    public static int getPositiveNonZeroInt(Scanner in, String prompt) {
        boolean verify = false;
        int input = 0;
        System.out.println(prompt);
        do {
            if (in.hasNextInt()) {
                input = in.nextInt();
                if (input > 0) {
                    verify = true;
                } else {
                    System.out.println("Out of range. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); // clear buffer
        } while (!verify);
        return input;
    }

    public static double getDouble(Scanner in, String prompt) {
        boolean verify = false;
        double input = 0;
        System.out.println(prompt);
        do {
            if (in.hasNextDouble()) {
                input = in.nextDouble();
                verify = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); // clear buffer
        } while (!verify);
        return input;
    }

    public static double getRangedDouble(Scanner in, String prompt, double min, double max) {
        boolean verify = false;
        double input = 0;
        System.out.println(prompt);
        do {
            if (in.hasNextDouble()) {
                input = in.nextDouble();
                if (input >= min && input <= max) {
                    verify = true;
                } else {
                    System.out.println("Out of range. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            in.nextLine(); // clear buffer
        } while (!verify);
        return input;
    }

    public static String getRegExString(Scanner in, String prompt, String regEx) {
        boolean verify = false;
        String input;
        do {
            System.out.println(prompt);
            input = in.nextLine();
            if (input.matches(regEx)) {
                verify = true;
            } else {
                System.out.println("Invalid Input.");
            }
        } while (!verify);
        return input;
    }

    public static String getNonZeroLenString(Scanner in, String prompt) {
        boolean verify = false;
        String input;
        do {
            System.out.println(prompt);
            input = in.nextLine();
            if (!input.isEmpty()) {
                verify = true;
            } else {
                System.out.println("String cannot be blank. Try again.");
            }
        } while (!verify);
        return input;
    }

    public static boolean getYNConfirm(Scanner in, String prompt) {
        boolean verify = false;
        boolean confirmed = false;
        String input;
        do {
            System.out.println(prompt);
            input = in.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                confirmed = true;
                verify = true;
            } else if (input.equalsIgnoreCase("N")) {
                verify = true;
            } else {
                System.out.println("Invalid Input.");
            }
        } while (!verify);
        return confirmed;
    }
}