import java.util.InputMismatchException;
import java.util.Scanner;

public class ProficientCalculator {

    // Calculator class for performing operations
    static class Calculator {

        public double add(double num1, double num2) {
            return num1 + num2;
        }

        public double subtract(double num1, double num2) {
            return num1 - num2;
        }

        public double multiply(double num1, double num2) {
            return num1 * num2;
        }

        public double divide(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("Error: Division by zero is not allowed.");
            }
            return num1 / num2;
        }
    }

    // Method to handle valid input for numbers
    private static double getValidNumber(Scanner scanner) {
        double number = 0;
        boolean valid = false;
        while (!valid) {
            try {
                number = scanner.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        return number;
    }

    // Method to handle operation choice input validation
    private static int getValidOperation(Scanner scanner) {
        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please select a valid operation.");
                } else {
                    validChoice = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please select a number between 1 and 5.");
                scanner.next(); // Consume invalid input
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Welcome to the Proficient Calculator!");
        while (true) {
            // Display the calculator options
            System.out.println("\nSelect operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            // Get valid operation choice
            int choice = getValidOperation(scanner);

            if (choice == 5) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Exit the program
            }

            // Ask for user input for the numbers
            System.out.print("Enter the first number: ");
            double num1 = getValidNumber(scanner);
            System.out.print("Enter the second number: ");
            double num2 = getValidNumber(scanner);

            try {
                double result = 0;
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        break;
                    case 4:
                        result = calculator.divide(num1, num2);
                        break;
                }
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage()); // Handle division by zero
            }

            // Ask if the user wants to perform another operation
            System.out.print("\nWould you like to perform another operation? (yes/no): ");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
