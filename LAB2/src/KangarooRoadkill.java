import java.util.Scanner;

public class KangarooRoadkill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side of the square in km: ");
        double sideOfSquare = scanner.nextDouble();

        System.out.print("Enter road length in km: ");
        double roadLength = scanner.nextDouble();

        System.out.print("Enter the number of 'roos: ");
        int numberOfRoos = scanner.nextInt();

        final double ROAD_WIDTH = 0.01;
        final double ROADKILL_PROBABILITY = 1.47;

        double areaOfSquare = sideOfSquare * sideOfSquare;
        double kangarooDensity = numberOfRoos / areaOfSquare;

        double roadSurfaceArea = roadLength * ROAD_WIDTH;

        double expectedKills = kangarooDensity * roadSurfaceArea * ROADKILL_PROBABILITY;

        int kills = (int) expectedKills;
        int injuries = (expectedKills - kills) > 0 ? 1 : 0;

        System.out.println("The expected number of kills is: " + kills);
        System.out.println("Expected number of injuries: " + injuries);

        scanner.close();
    }
}


