import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> objects = new ArrayList<String>();
    private static String fileName = "";
    private static Scanner scanner;
    private static boolean cont = true;
    private static boolean dirty = false;
    private static boolean saved = false;
    private static boolean fileLoaded = false;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);

        while (cont) {
            String input = InputHelper.getNonZeroLenString(scanner, "Options: A (add to list), D (delete from list), V (view the list), Q (quit the program), O (open a file), S (save a file), C (clear current list)");

            if (input.equalsIgnoreCase("a")) {
                String toAdd = InputHelper.getNonZeroLenString(scanner, "What would you like to add?");
                Add(toAdd);
            } else if (input.equalsIgnoreCase("d")) {
                int toDelIndex = InputHelper.getRangedInt(scanner, "What is the object's index?", 1, objects.size());
                Delete(toDelIndex);
            } else if (input.equalsIgnoreCase("v")) {
                View();
            } else if (input.equalsIgnoreCase("q")) {
                AttemptSave();
                if (InputHelper.getYNConfirm(scanner, "Are you sure you want to quit? [Y/N]")) {
                    cont = false;
                }
            } else if (input.equalsIgnoreCase("O")) {
                AttemptSave();
                objects.clear();
                fileName = IOHelper.readFile(objects);
                fileLoaded = true;
            } else if (input.equalsIgnoreCase("S")) {
                Save();
            } else if (input.equalsIgnoreCase("C")) {
                AttemptSave();
                objects.clear();
            } else {
                System.out.printf("\"%s\" is not an option.\n", input);
            }
        }
    }

    public static void Add(String toAdd) {
        objects.add(toAdd);
        dirty = true;
    }

    public static void Delete(int toDelIndex) {
        objects.remove(toDelIndex);
        dirty = true;
    }

    public static void View() {
        System.out.println("Current list");
        for (String o: objects) {
            System.out.printf("%d - %s\n", objects.indexOf(o), o);
        }
    }

    // called when the user is attempting to do an action that will delete unsaved data,
    // asks for confirmation before deleting the data
    public static void AttemptSave() {
        if (!(dirty && !saved)) { return; } // guardian clause to avoid nested if ig
        if (InputHelper.getYNConfirm(scanner, "Do you want to save? The data will be erased. [Y/N]")) {
            Save();
        }
    }

    // actually saves the file
    public static void Save() {
        IOHelper.writeFile(objects);
        dirty = false;
        saved = true;
    }
}