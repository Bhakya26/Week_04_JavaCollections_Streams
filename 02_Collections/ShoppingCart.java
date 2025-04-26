import java.util.*;

public class ShoppingCart {

    private Map<String, Double> productPriceMap = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPriceMap.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPriceMap.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not available: " + product);
        }
    }

    public void displayCartInOrder() {
        System.out.println("\nItems in Cart (Order Added):");
        cart.forEach((product, quantity) -> 
            System.out.println(product + " x" + quantity + " @ $" + productPriceMap.get(product)));
    }

    public void displayCartSortedByPrice() {
        System.out.println("\nItems in Cart (Sorted by Price):");
        
        // Create a TreeMap where key is Price, and value is List of Products
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        
        for (String product : cart.keySet()) {
            double price = productPriceMap.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }
        
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                System.out.println(product + " @ $" + price + " (x" + cart.get(product) + ")");
            }
        }
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 1.2);
        cart.addProduct("Milk", 2.5);

        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 5);
        cart.addToCart("Milk", 1);
        cart.addToCart("Orange", 3);

        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
    }
}
