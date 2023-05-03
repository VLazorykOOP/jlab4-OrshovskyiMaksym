import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input fail name: ");
        String fileName = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("^Z")) { // комбінація Ctrl+Z
                    break;
                }
                fileWriter.write(line + "\n");
            }
            System.out.println("The data was successfully written to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
