package java8;

import java.util.*;
import java.util.stream.*;

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H1", "Alice", 65, "Life", 1000.0),
            new PolicyHolder("H2", "Bob", 55, "Life", 1200.0),
            new PolicyHolder("H3", "Charlie", 70, "Health", 1500.0),
            new PolicyHolder("H4", "David", 75, "Life", 3000.0),
            new PolicyHolder("H5", "Eve", 62, "Life", 2000.0),
            new PolicyHolder("H6", "Frank", 80, "Life", 4000.0)
        );

        Map<String, List<RiskAssessment>> categorized = assessRisk(holders);

        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(r -> System.out.printf("%s (%s) -> riskScore=%.3f%n", r.getName(), r.getHolderId(), r.getRiskScore()));
            System.out.println();
        });
    }

    
    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        List<RiskAssessment> assessments = holders.stream()
            .filter(h -> "Life".equals(h.getPolicyType()) && h.getAge() > 60)
            .map(h -> new RiskAssessment(
                h.getHolderId(),
                h.getName(),
                h.getPremiumAmount() / h.getAge()
            ))
            .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
            .collect(Collectors.toList());

        return assessments.stream()
            .collect(Collectors.groupingBy(
                ra -> ra.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"
            ));
    }

    static class PolicyHolder {
        private final String holderId;
        private final String name;
        private final int age;
        private final String policyType;
        private final double premiumAmount;

        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
        public String getHolderId()    { return holderId; }
        public String getName()        { return name; }
        public int    getAge()         { return age; }
        public String getPolicyType()  { return policyType; }
        public double getPremiumAmount(){ return premiumAmount; }
    }
    static class RiskAssessment {
        private final String holderId;
        private final String name;
        private final double riskScore;

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }
        public String getHolderId() { return holderId; }
        public String getName()     { return name; }
        public double getRiskScore(){ return riskScore; }
    }
}

