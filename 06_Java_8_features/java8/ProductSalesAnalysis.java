package java8;

import java.util.*;
import java.util.stream.*;

public class ProductSalesAnalysis {

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P1", 5,  10.0),
            new Sale("P2", 12, 15.0),
            new Sale("P3", 20, 7.5),
            new Sale("P1", 15, 10.0),
            new Sale("P4", 30, 5.0),
            new Sale("P2",  8, 15.0),
            new Sale("P5", 25, 8.0),
            new Sale("P6", 50, 2.0),
            new Sale("P3",  5, 7.5),
            new Sale("P7", 11, 20.0)
        );

        List<ProductSales> top5 = analyze(sales);

        System.out.println("Top 5 products by total revenue:");
        top5.forEach(ps ->
            System.out.printf("%s → revenue = %.2f%n", ps.getProductId(), ps.getTotalRevenue())
        );
    }

    
    public static List<ProductSales> analyze(List<Sale> sales) {
        return sales.stream()
            .filter(s -> s.getQuantity() > 10)
            .collect(Collectors.groupingBy(
                Sale::getProductId,
                Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())
            ))
            .entrySet().stream()
            .map(e -> new ProductSales(e.getKey(), e.getValue()))
            .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
            .limit(5)
            .collect(Collectors.toList());
    }

    static class Sale {
        private final String productId;
        private final int quantity;
        private final double price;
        public Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
        public String getProductId() { return productId; }
        public int    getQuantity()  { return quantity; }
        public double getPrice()     { return price; }
    }

    static class ProductSales {
        private final String productId;
        private final double totalRevenue;
        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }
        public String getProductId()    { return productId; }
        public double getTotalRevenue() { return totalRevenue; }
    }
}

