import java.util.Scanner;

public class IRSTaxProgram {


        public static final double RICH = 0.25;
        public static final double POOR_MEDIUM = 0.10;
        public static final double AVERAGE_REALISTIC = 0.25;
        public static final double STINKING_RICH = 500000;
        public static final double QUITE_RICH = 200000;
        public static final double MIAMI_POOR = 100000;
        public static final double AVERAGE = 500000;
        public static final double REALISTIC = 20000;


    public static void main(String[] args) {
        double[] incomeAndDeductions = inputIncomesAndDeductions();
        double income = incomeAndDeductions[0];
        double deduction = incomeAndDeductions[1];
        double taxableIncome = computeTaxableIncome(income, deduction);
        char taxGroup = chooseTaxGroup(taxableIncome);
        double taxOwed = computeTax(taxableIncome, taxGroup);
        displayTaxInformation(income, deduction, taxableIncome, taxGroup, taxOwed);
    }

    public static double[] inputIncomesAndDeductions() {
        Scanner scanner = new Scanner(System.in);
        double income = 0;
        double deduction = 0;
        while (true) {
            System.out.print("Enter next amount: ");
            double amount = scanner.nextDouble();
            if (amount == 0) break;
            if (amount > 0) {
                income += amount;
            } else {
                deduction += Math.abs(amount);
            }
        }
        return new double[]{income, deduction};
    }

    public static double computeTaxableIncome(double income, double deduction) {
        if (income >= deduction) {
            return income - deduction;
        } else {
            return 0.0;
        }
    }

    public static char chooseTaxGroup(double taxableIncome) {
        if (taxableIncome >= 500000) {
            return 'S'; // STINKING RICH
        } else if (taxableIncome >= 200000) {
            return 'Q'; // QUITE RICH
        } else if (taxableIncome >= 100000) {
            return 'M'; // MIAMI POOR
        } else if (taxableIncome >= 50000) {
            return 'A'; // AVERAGE
        } else if (taxableIncome >= 20000) {
            return 'R'; // REALISTIC
        } else {
            return 'P'; // POOR
        }
    }

    public static double computeTax(double taxableIncome, char taxGroup) {
        switch (taxGroup) {
            case 'S':
            case 'Q':
                return taxableIncome * 0.25;
            case 'M':
                return taxableIncome * 0.10;
            case 'A':
            case 'R':
                return taxableIncome * 0.03;
            case 'P':
                return 0.0;
            default:
                System.out.println("Error: Invalid tax group.");
                return 0.0;
        }
    }

    public static void displayTaxInformation(double income, double deduction, double taxableIncome, char taxGroup, double taxOwed) {
        System.out.printf("Income         = $%.2f%n", income);
        System.out.printf("Deductions     = $%.2f%n", deduction);
        System.out.printf("Taxable income = $%.2f%n", taxableIncome);
        System.out.printf("Tax group      = %c%n", taxGroup);
        System.out.printf("Tax owed       = $%.2f%n", taxOwed);
    }
}

