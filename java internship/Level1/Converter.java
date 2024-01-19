import java.util.*;

public class Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().charAt(0);

        double convertedTemperature;

        if (unit == 'C' || unit == 'c') {
            // Convert Celsius to Fahrenheit
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is equal to " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            // Convert Fahrenheit to Celsius
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is equal to " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit of measurement. Please enter C or F.");
        }

      
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
