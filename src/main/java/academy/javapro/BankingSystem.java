package academy.javapro;

/**
 * Main class demonstrating the banking system functionality.
 * Creates and operates on different types of accounts using polymorphism.
 */
public class BankingSystem
{

    public static void main(String[] args)
    {
        System.out.println("======= Banking System Demonstration =======\n");

        // Create different types of accounts
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe", 1000.0, 2.5);
        CheckingAccount checking = new CheckingAccount("CA001", "Jane Smith", 2000.0, 500.0);

        // Store accounts in an array to demonstrate polymorphism
        Account[] accounts = {savings, checking};

        // Display initial information for all accounts
        System.out.println("--- Initial Account Information ---");
        for (Account account : accounts)
        {
            account.displayInfo();
            System.out.println();
        }

        // Demonstrate account operations
        System.out.println("--- Performing Account Operations ---");

        // Test deposit operations
        System.out.println("\n1. Testing deposits:");
        savings.deposit(500.0);
        checking.deposit(300.0);

        // Test withdrawal operations
        System.out.println("\n2. Testing withdrawals:");
        savings.withdraw(1300.0); // Should fail
        savings.withdraw(200.0);  // Should succeed
        checking.withdraw(2500.0); // Should overdraft

        // Test account-specific operations
        System.out.println("\n3. Testing account-specific operations:");

        // Savings account - apply interest
        System.out.println("\nSavings Account - Applying interest:");
        savings.applyInterest();

        // Checking account - modify overdraft
        System.out.println("\nChecking Account - Modifying overdraft limit:");
        checking.setOverdraftLimit(1000.0);

        // Display updated information for all accounts
        System.out.println("\n--- Updated Account Information ---");
        for (Account account : accounts)
        {
            account.displayInfo();
            System.out.println();
        }


        // Display transaction history
        System.out.println("--- Transaction History ---");

        System.out.println("\nSavings Account Transactions:");
        for (String transaction : savings.getTransactionHistory())
        {
            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transactions:");
        for (String transaction : checking.getTransactionHistory())
        {
            System.out.println(transaction);
        }

        System.out.println("\n======= End of Banking System Demonstration =======");
    }
}