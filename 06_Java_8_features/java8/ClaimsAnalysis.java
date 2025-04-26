package java8;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C1", "P1001", 6000, LocalDate.of(2025, 1, 10), "Approved"),
            new Claim("C2", "P1002", 4500, LocalDate.of(2025, 2, 5), "Approved"),
            new Claim("C3", "P1001", 12000, LocalDate.of(2025, 3, 12), "Approved"),
            new Claim("C4", "P1003", 7000, LocalDate.of(2025, 1, 20), "Pending"),
            new Claim("C5", "P1002", 8000, LocalDate.of(2025, 4, 1), "Approved"),
            new Claim("C6", "P1003", 15000, LocalDate.of(2025, 2, 28), "Approved"),
            new Claim("C7", "P1004", 3000, LocalDate.of(2025, 3, 15), "Approved"),
            new Claim("C8", "P1001", 9000, LocalDate.of(2025, 4, 10), "Approved")
        );

        List<PolicyStats> topPolicies = analyzeClaims(claims, 5000, "Approved", 3);

        System.out.println("Top policies by total approved claim amount:");
        topPolicies.forEach(ps -> System.out.printf(
            "Policy %s → total=%.2f, average=%.2f%n",
            ps.getPolicyNumber(), ps.getTotalAmount(), ps.getAverageAmount()
        ));
    }

    
    public static List<PolicyStats> analyzeClaims(
            List<Claim> claims,
            double minAmount,
            String status,
            int topN
    ) {
        Map<String, DoubleSummaryStatistics> statsByPolicy = claims.stream()
            .filter(c -> status.equals(c.getStatus()) && c.getClaimAmount() > minAmount)
            .collect(Collectors.groupingBy(
                Claim::getPolicyNumber,
                Collectors.summarizingDouble(Claim::getClaimAmount)
            ));

        return statsByPolicy.entrySet().stream()
            .map(e -> new PolicyStats(
                e.getKey(),
                e.getValue().getSum(),
                e.getValue().getAverage()
            ))
            .sorted(Comparator.comparingDouble(PolicyStats::getTotalAmount).reversed())
            .limit(topN)
            .collect(Collectors.toList());
    }

    static class Claim {
        private final String claimId;
        private final String policyNumber;
        private final double claimAmount;
        private final LocalDate claimDate;
        private final String status;

        public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
        public String getClaimId()       { return claimId; }
        public String getPolicyNumber()  { return policyNumber; }
        public double getClaimAmount()   { return claimAmount; }
        public LocalDate getClaimDate()  { return claimDate; }
        public String getStatus()        { return status; }
    }
    static class PolicyStats {
        private final String policyNumber;
        private final double totalAmount;
        private final double averageAmount;

        public PolicyStats(String policyNumber, double totalAmount, double averageAmount) {
            this.policyNumber = policyNumber;
            this.totalAmount = totalAmount;
            this.averageAmount = averageAmount;
        }
        public String getPolicyNumber() { return policyNumber; }
        public double getTotalAmount()  { return totalAmount; }
        public double getAverageAmount(){ return averageAmount; }
    }
}
