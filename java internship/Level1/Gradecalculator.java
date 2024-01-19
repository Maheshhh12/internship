import java.util.*;

public class Gradecalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of grades: ");
        int numberOfGrades = sc.nextInt();

        // Check if the number of grades is non-negative
        if (numberOfGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive integer.");
            return;
        }

        int sum = 0;

        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade #" + i + ": ");
            int grade = sc.nextInt();

            // Check if the grade is within a valid range (e.g., 0-100)
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                return;
            }

            sum += grade;
        }

        double average = (double) sum / numberOfGrades;

        System.out.println("The average grade is: " + average);

    }
}
