import java.util.*;

public class StrengthChecker {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int strength = checkPasswordStrength(password);

        switch (strength) {
            case 5:
                System.out.println("Password is very strong!");
                break;
            case 4:
                System.out.println("Password is strong.");
                break;
            case 3:
                System.out.println("Password is moderate.");
                break;
            case 2:
                System.out.println("Password is weak.");
                break;
            case 1:
                System.out.println("Password is very weak!");
                break;
            default:
                System.out.println("Invalid password.");
                break;
        }

    }

    private static int checkPasswordStrength(String password) {
        int strength = 0;

        // Check length
        if (password.length() >= 8) {
            strength++;
        }

        // Check for uppercase letters
        if (containsUppercase(password)) {
            strength++;
        }

        // Check for lowercase letters
        if (containsLowercase(password)) {
            strength++;
        }

        // Check for numbers
        if (containsNumber(password)) {
            strength++;
        }

        // Check for special characters
        if (containsSpecialCharacter(password)) {
            strength++;
        }

        return strength;
    }

    private static boolean containsUppercase(String str) {
        return !str.equals(str.toLowerCase());
    }

    private static boolean containsLowercase(String str) {
        return !str.equals(str.toUpperCase());
    }

    private static boolean containsNumber(String str) {
        return str.matches(".*\\d.*");
    }

    private static boolean containsSpecialCharacter(String str) {
        return !str.matches("[a-zA-Z0-9 ]*");
    }
}
