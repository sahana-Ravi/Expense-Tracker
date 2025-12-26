import java.util.Scanner;

public class Options {
    public static void main(String args[]) {
        ExpenceService es = new ExpenceService();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("\nEXPENSE TRACKER OPTIONS");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expenses");
            System.out.println("5. Summary of all Expenses");
            System.out.println("6. Summary of monthly Expenses");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline after number input

            switch (choice) {
                case 1:
                    System.out.println("Add Expense selected");
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    es.addExpense(description, amount);
                    System.out.println("Expense added: " + description + " - " + amount);
                    break;

                case 2:
                    System.out.println("View Expenses selected");
                    es.viewExpenses();
                    break;

                case 3:
                    System.out.println("Delete Expense selected");
                    System.out.print("Enter Expense ID to delete: ");
                    String id = scanner.nextLine();
                    es.deleteExpense(id);
                    break;

                case 4:
                    System.out.println("Update Expenses selected");
                    System.out.print("Enter Expense ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter new amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    es.updateExpense(updateId, newDescription, newAmount);
                    break;

                case 5:
                    System.out.println("Summary of all Expenses selected");
                    es.summaryOfExpenses();
                    break;

                case 6:
                    System.out.println("Summary of monthly Expenses selected");
                    System.out.print("Enter the month and year (MM YYYY): ");
                    int m = scanner.nextInt();
                    int y = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    es.monthlySummaryOfExpenses(m, y);
                    break;
                case 7:   
                    System.out.println("set budget for the month");
                    System.out.print("Enter budget amount: ");
                    double budgetAmount = scanner.nextDouble(); 
                    System.out.print("Enter month and year for the budget (MM YYYY): ");   
                    int month = scanner.nextInt();
                    int year = scanner.nextInt(); // consume newline
                    es.setBudget(budgetAmount, month, year);
                    System.out.println("Budget of " + budgetAmount + " set for the month.");        
                    break; 
                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}