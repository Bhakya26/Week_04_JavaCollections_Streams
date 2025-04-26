package java8;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class FraudDetection {

    public static void main(String[] args) {
        List<Transaction> txns = Arrays.asList(
            new Transaction("T1", "P1001", 15000, LocalDate.of(2025,1,10), true),
            new Transaction("T2", "P1001", 20000, LocalDate.of(2025,1,15), true),
            new Transaction("T3", "P1002", 12000, LocalDate.of(2025,2, 5), true),
            new Transaction("T4", "P1001", 18000, LocalDate.of(2025,2,10), true),
            new Transaction("T5", "P1003",  9000, LocalDate.of(2025,2,12), true),
            new Transaction("T6", "P1001", 11000, LocalDate.of(2025,3, 1), true),
            new Transaction("T7", "P1001", 13000, LocalDate.of(2025,3, 5), true),
            new Transaction("T8", "P1002", 16000, LocalDate.of(2025,3,10), true),
            new Transaction("T9", "P1003", 20000, LocalDate.of(2025,3,15), true),
            new Transaction("T10","P1003", 25000, LocalDate.of(2025,4, 1), true)
        );

        List<PolicyAlert> alerts = detectFraud(txns);

        System.out.println("Policies requiring alert:");
        alerts.forEach(a ->
            System.out.printf("Policy %s → count=%d, totalAmount=%.2f%n",
                              a.getPolicyNumber(), a.getFraudCount(), a.getTotalFraudAmount())
        );
    }

    public static List<PolicyAlert> detectFraud(List<Transaction> txns) {
        List<Transaction> filtered = txns.stream()
            .filter(t -> t.isFraudulent() && t.getAmount() > 10_000)
            .collect(Collectors.toList());

        Map<String, Long> countByPolicy = filtered.stream()
            .collect(Collectors.groupingBy(
                Transaction::getPolicyNumber,
                Collectors.counting()
            ));
        Map<String, Double> sumByPolicy = filtered.stream()
            .collect(Collectors.groupingBy(
                Transaction::getPolicyNumber,
                Collectors.summingDouble(Transaction::getAmount)
            ));

        return countByPolicy.entrySet().stream()
            .map(e -> {
                String policy = e.getKey();
                long cnt = e.getValue();
                double total = sumByPolicy.getOrDefault(policy, 0.0);
                return new PolicyAlert(policy, cnt, total);
            })
            .filter(a -> a.getFraudCount() > 5 || a.getTotalFraudAmount() > 50_000)
            .collect(Collectors.toList());
    }

  
    static class Transaction {
        private final String transactionId;
        private final String policyNumber;
        private final double amount;
        private final LocalDate transactionDate;
        private final boolean isFraudulent;
        public Transaction(String transactionId, String policyNumber,
                           double amount, LocalDate transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber  = policyNumber;
            this.amount        = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent  = isFraudulent;
        }
        public String getTransactionId() { return transactionId; }
        public String getPolicyNumber()  { return policyNumber; }
        public double getAmount()        { return amount; }
        public LocalDate getTransactionDate() { return transactionDate; }
        public boolean isFraudulent()     { return isFraudulent; }
    }

    static class PolicyAlert {
        private final String policyNumber;
        private final long fraudCount;
        private final double totalFraudAmount;
        public PolicyAlert(String policyNumber, long fraudCount, double totalFraudAmount) {
            this.policyNumber     = policyNumber;
            this.fraudCount       = fraudCount;
            this.totalFraudAmount = totalFraudAmount;
        }
        public String getPolicyNumber()    { return policyNumber; }
        public long   getFraudCount()      { return fraudCount; }
        public double getTotalFraudAmount(){ return totalFraudAmount; }
    }
}

