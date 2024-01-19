import java.security.SecureRandom;
import java.util.*;
public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int passwordLength = sc.nextInt();

        if (passwordLength <= 0) {
            System.out.println("Invalid password length. Please enter a positive integer.");
            return;
        }

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = sc.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = sc.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = sc.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = sc.next().equalsIgnoreCase("y");

        String password = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);

        System.out.println("Generated Password: " + password);

    }

    private static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialCharacters) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        StringBuilder validChars = new StringBuilder();

        if (includeNumbers) {
            validChars.append(numbers);
        }
        if (includeLowercase) {
            validChars.append(lowercaseLetters);
        }
        if (includeUppercase) {
            validChars.append(uppercaseLetters);
        }
        if (includeSpecialCharacters) {
            validChars.append(specialCharacters);
        }

        if (validChars.length() == 0) {
            System.out.println("No character types selected. Please include at least one type.");
            System.exit(0);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            passwordBuilder.append(validChars.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
}
