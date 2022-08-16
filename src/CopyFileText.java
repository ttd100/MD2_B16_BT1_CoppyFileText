import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) throws Exception {
        String source = "source.txt";
        String dest = "dest.txt";
        copyFileText(source, dest);
    }

    public static void copyFileText(String source, String dest) {
        Scanner sc = new Scanner(System.in);
        File sourceFile = new File(source);
        File destFile = new File(dest);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist");
            return;
        }
        boolean next = true;
        if (destFile.exists()) {
            next = false;
            System.out.println("Destination file existed. Do you want to overwrite?");
            System.out.println("1. Yes    2. No");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("File will be overwritten");
                    next = true;
                    break;
                case 2:
                    System.out.println("File will not be overwritten");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        if (next) {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
            System.out.println("Copy completed successfully");
        }
        System.out.println("EXIT");
    }
}
