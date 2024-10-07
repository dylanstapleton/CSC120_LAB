import java.util.Scanner;

/**
 * NumberChecker class for determining if numbers are Fibonacci and/or prime.
 */
public class LAB5 {

    // Constants
    private static final int MAX_NUMBERS = 10;
    private static final int STOP_NUMBER = 0;
    private static final int MIN_PRIME = 2;

    // Array to store the numbers
    int[] numbers = new int[MAX_NUMBERS];

    /**
     * Main method that runs the program.
     * It gets the user input, processes the numbers, and prints the results.
     * @author Dylan Stapleton
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] numbers = new int[10]; // Array to store up to 10 numbers
        int count = getNumbers(numbers); // Get numbers from the user

        // Process each number in the array
        for (int i = 0; i < count; i++) {
            int num = numbers[i];
            boolean isFib = isFibonacci(num); // Check if Fibonacci
            boolean isPrime = isPrime(num);   // Check if Prime

            // Print the results
            System.out.print(num + " is ");
            if (isFib) {
                System.out.print("Fibonacci");
            } else {
                System.out.print("not Fibonacci");
            }
            System.out.print(" and is ");
            if (isPrime) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
    }

    /**
     * Method to get up to 10 numbers from the user.
     * The input stops when the user enters 0.
     *
     * @param numbers The array to store the numbers.
     * @return The number of valid integers entered.
     */
    public static int getNumbers(int[] numbers) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int count = 0; // Number of valid integers entered
        int num;

        System.out.print("Please enter numbers (0 to stop) : "); // Single prompt
        do {
            num = sc.nextInt(); // Get the next number
            if (num > 0 && count < 10) { // Store if positive and within limit
                numbers[count] = num;
                count++;
            }
        } while (num != 0 && count < 10); // Stop on 0 or after 10 numbers

        return count; // Return the number of valid entries
    }

    /**
     * Method to check if a number is a Fibonacci number.
     *
     * @param n The number to check.
     * @return True if the number is Fibonacci, false otherwise.
     */
    public static boolean isFibonacci(int n) {
        if (n == 0 || n == 1) return true; // 0 and 1 are Fibonacci numbers
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == n; // Return true if n is Fibonacci
    }

    /**
     * Method to check if a number is prime.
     *
     * @param n The number to check.
     * @return True if the number is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false; // Numbers less than 2 are not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Not prime if divisible by any number other than 1 and itself
            }
        }
        return true; // Return true if prime
    }
}



