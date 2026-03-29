import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "expenses.txt";
    private static double budget = 1000.0;

    public static void main(String[] args) {
        loadFromFile();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Set Budget | 2. Add Expense | 3. View All | 4. View Total | 5. Exit");
            System.out.print("Choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setBudget();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    viewTotal();
                    break;
                case 5:
                    saveToFile();
                    running = false;
                    System.out.println("Exiting... Data saved.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Amount: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double amt = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Category: ");
        String cat = scanner.nextLine();

        expenses.add(new Expense(desc, amt, cat));
        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    private static void viewTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }

        System.out.printf("Total: Rs.%.2f\n", total);
        System.out.printf("Budget: Rs.%.2f\n", budget);

        if (total > budget) {
            System.out.println("⚠️ Warning: You are over budget!");
        }
    }

    private static void setBudget() {
        System.out.print("Enter new budget: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input.");
            scanner.next();
            return;
        }

        budget = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Budget updated successfully!");
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.println(e.getDescription() + "," + e.getAmount() + "," + e.getCategory());
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    expenses.add(new Expense(parts[0], Double.parseDouble(parts[1]), parts[2]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}
