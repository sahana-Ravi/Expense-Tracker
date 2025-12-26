import java.io.FileWriter;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.List; 
public class ExpenceService {
    private List<Expence> expences = new ArrayList<>();
    private double budget;
    private int month;
    private int year;


    public void setBudget(double budget, int month, int year) {
        this.budget = budget;
        this.month = month;
        this.year = year;
    }

    public void addExpense(String description, double amount) {
        Expence expence = new Expence(description, amount);
        expences.add(expence);  
        int m = expence.getTimeStamp().getMonthValue();
        int y = expence.getTimeStamp().getYear();
        if(this.monthlySummaryOfExpenses(m,y) > budget) {
            System.out.println("Warning: You have exceeded your budget for " + month + "/" + year);
        }
        exportToCSV();
    }

    public void viewExpenses() {
        for (Expence expence : expences) {
            System.out.println("ID: " + expence.getId() + ", Description: " + expence.getDescription() + ", Amount: " + expence.getAmount() + ", TimeStamp: " + expence.getTimeStamp());
        }
    }

    public void deleteExpense(String id) {
        expences.removeIf(expence -> expence.getId().toString().equals(id));
        exportToCSV();
    }

    public void updateExpense(String id, String newDescription, double newAmount) {
        // Find the expense by ID and update its details    
        for (Expence expence : expences) {
            if (expence.getId().toString().equals(id)) {
                expence.setDescription(newDescription);
                expence.setAmount(newAmount);
                break;
            }
        }
        exportToCSV();
    }

    public void summaryOfExpenses() {
        double total = 0;
        for (Expence expence : expences) {
            total += expence.getAmount();
        }
        System.out.println("Total Expenses: " + total);
    }
    public double monthlySummaryOfExpenses(int month, int year) {
        double total = 0;
        for (Expence expence : expences) {
            if (expence.getTimeStamp().getMonthValue() == month && expence.getTimeStamp().getYear() == year) {
                total += expence.getAmount();
            }
        }
        System.out.println("Total Expenses for " + month + "/" + year + ": " + total);
        return total;
    }
    public void exportToCSV() {
        try (FileWriter writer = new FileWriter("expenses.csv")) {
            // Header
            writer.append("ID,Description,Amount,Timestamp\n");

            // Data
            for (Expence e : expences) {
                writer.append(e.getId().toString()).append(",");
                writer.append(e.getDescription()).append(",");
                writer.append(String.valueOf(e.getAmount())).append(",");
                writer.append(e.getTimeStamp().toString()).append("\n");
            }
            System.out.println("CSV file updated: expenses.csv");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}