import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class IOHelper {
    private static JFileChooser chooser = new JFileChooser();
    public static String readFile(ArrayList<String> output) throws IOException {
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String rec = "";
                while (reader.ready()) {
                    rec = reader.readLine();
                    output.add(rec);
                }
                reader.close(); // must close the file to seal it and clear buffer
                return file.getFileName().toString();
            } else {
                System.out.println("File not selected. Please restart program.");
                System.exit(0); //Shuts down program
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(ArrayList<String> recs) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String r : recs) {
                System.out.printf("Writing %s\n", r);
                writer.write(r, 0, r.length());
                writer.newLine();
            }
            writer.close(); //closes file and clears buffer
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}