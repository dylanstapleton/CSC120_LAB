import java.util.Scanner;

/**
 * StreetMaintenance program prioritizes spending on street maintenance based on
 * the ages of the people who live in the street.
 *
 * This program collects house numbers, the number of people in each house, and their ages.
 * It then reports the total age of the people in each house and the total age of the street.
 *
 * @author Dylan Stapleton
 */
public class StreetMaintenance {
    // Scanner object to read input from the keyboard
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Main method to run the program. It handles input and output.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        int numHouses;
        int[] houseNumbers;
        int[][] ages;

        // Get the number of houses on the street
        System.out.print("How many houses in the street?   : ");
        numHouses = keyboard.nextInt();

        // Initialize arrays for house numbers and ages of people in each house
        houseNumbers = new int[numHouses];
        ages = new int[numHouses][];

        // Input house numbers and residents' ages
        inputHouseData(numHouses, houseNumbers, ages);

        // Analyze and display the results for each house and the entire street
        analyzeAndReportAges(houseNumbers, ages);
    }

    /**
     * This method inputs the house number and ages of the residents.
     * It populates the houseNumbers array with house numbers and the ages array with
     * the ages of people living in each house.
     *
     * @param numHouses    The number of houses on the street
     * @param houseNumbers The array to store house numbers
     * @param ages         The irregular two-dimensional array to store residents' ages
     */
    private static void inputHouseData(int numHouses, int[] houseNumbers, int[][] ages) {
        for (int i = 0; i < numHouses; i++) {
            // Input house number
            System.out.print("What is the next house number?   : ");
            houseNumbers[i] = keyboard.nextInt();

            // Input number of people living in the house
            System.out.print("How many people live in number " + houseNumbers[i] + " : ");
            int numPeople = keyboard.nextInt();

            // Initialize the array for storing ages of residents in this house
            ages[i] = new int[numPeople];

            // Input the age of each person in the house
            for (int j = 0; j < numPeople; j++) {
                System.out.print("What is the age of person " + (j + 1) + "      : ");
                ages[i][j] = keyboard.nextInt();
            }

            System.out.println(); // Adding a blank line after each house entry
        }
    }

    /**
     * This method analyzes the data structure to calculate and report the total age of each house
     * and the total age of the entire street.
     *
     * @param houseNumbers The array storing house numbers
     * @param ages         The irregular two-dimensional array storing residents' ages
     */
    private static void analyzeAndReportAges(int[] houseNumbers, int[][] ages) {
        int totalStreetAge = 0;

        // Loop through each house to calculate and report total age for each house
        for (int i = 0; i < houseNumbers.length; i++) {
            int houseTotalAge = 0;

            // Sum up the ages of residents in the house
            for (int age : ages[i]) {
                houseTotalAge += age;
            }

            // Output the total age for the house
            System.out.println("House " + houseNumbers[i] + " has a total age of " + houseTotalAge);
        }


    }
}