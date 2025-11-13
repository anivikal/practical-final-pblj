import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCRUDApp {

    private static List<Product> products = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int idCounter = 1; // to auto-generate IDs

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> {
                    System.out.println("👋 Exiting... Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    // CREATE
    private static void addProduct() {
        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        Product p = new Product(idCounter++, name, price, quantity);
        products.add(p);
        System.out.println("✅ Product added successfully!");
    }

    // READ
    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠️ No products found!");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    // UPDATE
    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        Product p = findProductById(id);

        if (p != null) {
            sc.nextLine(); // consume newline
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter new Quantity: ");
            int quantity = sc.nextInt();

            p.setName(name);
            p.setPrice(price);
            p.setQuantity(quantity);

            System.out.println("✅ Product updated successfully!");
        } else {
            System.out.println("❌ Product not found!");
        }
    }

    // DELETE
    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        Product p = findProductById(id);

        if (p != null) {
            products.remove(p);
            System.out.println("✅ Product deleted successfully!");
        } else {
            System.out.println("❌ Product not found!");
        }
    }

    // Helper function to find product by ID
    private static Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
}
