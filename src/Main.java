import java.util.Scanner;
public class Main {
    public static void runPortionCostCalculator(Scanner scanner) {
        System.out.print("Enter cost per pound: ");
        double costPerPound = scanner.nextDouble();

        System.out.print("Enter number of portions: ");
        int portions = scanner.nextInt();

        System.out.print("Enter ounces per portion: ");
        double ouncesPerPortion = scanner.nextDouble();

        double totalOunces = portions * ouncesPerPortion;
        double totalPounds = totalOunces / 16.0;
        double totalCost = totalPounds * costPerPound;
        double costPerPortion = totalCost / portions;

        System.out.print("Enter target food cost percentage (example: 30 for 30%): ");
        double targetPercent = scanner.nextDouble();

        if (targetPercent <= 0) {
            System.out.println("Target percent must be greater than 0.");
            return;
        }

        double menuPrice = calculateMenuPrice(costPerPortion, targetPercent);

        System.out.printf("Total ounces needed: %.2f%n", totalOunces);
        System.out.printf("Total pounds needed: %.2f%n", totalPounds);
        System.out.printf("Total food cost: $%.2f%n", totalCost);
        System.out.printf("Cost per portion: $%.2f%n", costPerPortion);
        System.out.printf("Suggested menu price at %.1f%% FC: $%.2f%n", targetPercent, menuPrice);
    }

    public static double calculateMenuPrice(double costPerPortion, double targetPercent) {
        return costPerPortion / (targetPercent / 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
                System.out.println("\n=== Catering Cost Calculator ===");
                System.out.println("1) Portion Cost Calculator");
                System.out.println("2) Exit");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        runPortionCostCalculator(scanner);
                        break;
                        // === YOUR EXISTING CALCULATION CODE GOES HERE ===

                    case 2:
                        running = false;
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
