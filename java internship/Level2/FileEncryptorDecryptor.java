import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptorDecryptor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an operation (1 for encryption, 2 for decryption): ");
        int operation = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the input file name or path: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the output file name: ");
        String outputFile = scanner.nextLine();

        try {
            if (operation == 1) {
                encryptFile(inputFile, outputFile);
                System.out.println("Encryption complete. Result saved to " + outputFile);
            } else if (operation == 2) {
                decryptFile(inputFile, outputFile);
                System.out.println("Decryption complete. Result saved to " + outputFile);
            } else {
                System.out.println("Invalid operation. Please choose 1 for encryption or 2 for decryption.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void encryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                // Perform simple encryption (shift each character by 1)
                char encryptedChar = (char) (currentChar + 1);
                writer.write(encryptedChar);
            }
        }
    }

    private static void decryptFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                // Perform simple decryption (shift each character back by 1)
                char decryptedChar = (char) (currentChar - 1);
                writer.write(decryptedChar);
            }
        }
    }
}
