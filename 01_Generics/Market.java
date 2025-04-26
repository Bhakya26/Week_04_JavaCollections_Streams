import java.util.*;

interface Category {
    String getcategoryName();
}

class BookCategory implements Category {
    private String categoryName;
    public BookCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getcategoryName() {
        return categoryName;
    }
}

class ClothingCategory implements Category {
    private String categoryName;
    public ClothingCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getcategoryName() {
        return categoryName;
    }
}

class GadgetCategory implements Category {
    private String categoryName;
    public GadgetCategory(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getcategoryName() {
        return categoryName;
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }
    public void setPrice(double price) { this.price = price; }

    public void displayInfo() {
        System.out.println(name + " [" + category.getcategoryName() + "] - Rs: " + price);
    }
}

class DiscountMethod {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("Applied discount " + percentage + "% on product " + product.getName());
    }
}

public class Market {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Basics", 50.0, new BookCategory("Educational"));
        Product<ClothingCategory> tshirt = new Product<>("Cool T-Shirt", 25.0, new ClothingCategory("Men"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 700.0, new GadgetCategory("Mobile"));

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(phone);

        DiscountMethod.applyDiscount(book, 15);
        DiscountMethod.applyDiscount(tshirt, 10);
        DiscountMethod.applyDiscount(phone, 10);

        System.out.println("\nFinal Catalog:");
        for (Product<? extends Category> item : catalog) {
            item.displayInfo();
        }
    }
}
