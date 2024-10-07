import java.util.Scanner;

public class ScubaNitrox {

    //-----------------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    // STATIC VARIABLES:

    private static final byte FEET_PER_ATH = 33;
    private static final double MAX_02_PRESSURE = 1.4;
    private static final double CONTINGENCY_02_PRESSURE = 1.6;

    //-----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Input from user
        System.out.print("Enter depth and percentage O2   : ");
        int depth = keyboard.nextInt();
        int percentage02 = keyboard.nextInt();

        // Calculate the ambient pressure
        double ambientPressure = (depth / (double) FEET_PER_ATH) + 1;

        // Compute the partial pressure of oxygen (ppO2)
        double pp02 = computePP02(depth, percentage02);

        // Calculate the oxygen pressure group
        char o2Group = calculateOxygenPressureGroup(pp02);

        // Output results
        System.out.printf("Ambient pressure    : %.1f%n", ambientPressure);
        System.out.printf("O2 pressure         : %.2f%n", pp02);
        System.out.printf("O2 group            : %c%n", o2Group);
        displayWarnings(pp02);

    }

    //-----------------------------------------------------------------------------------------------------
    private static double computePP02(int depthInFeet, int percentage02InGas) {
        double ambientPressure = (depthInFeet / (double) FEET_PER_ATH) + 1;
        return (percentage02InGas / 100.0) * ambientPressure;
    }

    //-----------------------------------------------------------------------------------------------------
    private static void displayWarnings(double pp02) {
        System.out.println("Exceeds maximal O2 pressure     : " + (pp02 > MAX_02_PRESSURE));
        System.out.println("Exceeds contingency O2 pressure : " + (pp02 > CONTINGENCY_02_PRESSURE));
    }

    //-----------------------------------------------------------------------------------------------------
    private static char calculateOxygenPressureGroup(double pp02) {
        int group = (int) (pp02 * 10);  // Convert pressure to corresponding group
        return (char) ('A' + group);
    }
    //-----------------------------------------------------------------------------------------------------
} //end of the ScubaNitrox class
//=========================================================================================================


