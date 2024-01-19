import java.util.*;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Given word is a palindrome");
        } else {
            System.out.println("  given word is not a palindrome");
        }

    }

    private static boolean isPalindrome(String str) {
        // Remove spaces and punctuation, convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
