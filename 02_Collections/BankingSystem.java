import java.util.*;

public class BankingSystem {

    private Map<Integer, Double> accountMap = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double initialBalance) {
        accountMap.put(accountNumber, initialBalance);
    }

    public void deposit(int accountNumber, double amount) {
        if (accountMap.containsKey(accountNumber)) {
            accountMap.put(accountNumber, accountMap.get(accountNumber) + amount);
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void requestWithdrawal(int accountNumber, double amount) {
        if (accountMap.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request of $" + amount + " from account " + accountNumber + " added to queue.");
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            double currentBalance = accountMap.getOrDefault(request.accountNumber, 0.0);
            
            if (currentBalance >= request.amount) {
                accountMap.put(request.accountNumber, currentBalance - request.amount);
                System.out.println("Withdrawal of $" + request.amount + " successful for account " + request.accountNumber);
            } else {
                System.out.println("Insufficient funds for account " + request.accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");

        // Create TreeMap with balance as key
        TreeMap<Double, List<Integer>> balanceMap = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accountMap.entrySet()) {
            int accountNumber = entry.getKey();
            double balance = entry.getValue();

            balanceMap.putIfAbsent(balance, new ArrayList<>());
            balanceMap.get(balance).add(accountNumber);
        }

        for (Map.Entry<Double, List<Integer>> entry : balanceMap.entrySet()) {
            double balance = entry.getKey();
            for (int account : entry.getValue()) {
                System.out.println("Account " + account + " → $" + balance);
            }
        }
    }

    // Inner class for withdrawal requests
    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount(101, 1000.0);
        bank.addAccount(102, 500.0);
        bank.addAccount(103, 1200.0);

        // Depositing
        bank.deposit(102, 300.0);

        // Requesting Withdrawals
        bank.requestWithdrawal(101, 200.0);
        bank.requestWithdrawal(102, 100.0);
        bank.requestWithdrawal(103, 1500.0); // Should fail (insufficient funds)

        // Processing Withdrawals
        bank.processWithdrawals();

        // Display accounts sorted by balance
        bank.displayAccountsSortedByBalance();
    }
}

