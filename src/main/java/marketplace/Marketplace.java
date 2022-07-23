package main.java.marketplace;


import java.util.*;


public class Marketplace {
    public static void main(String[] args) {
        int key;
        String nickName;
        Scanner scanner = new Scanner(System.in);
        Services services = new Services();
        int choise = 10;

        System.out.println("If you want to create a new Marketplace with the 3 products and  3 users you must enter 1 or else 2.");
        System.out.print("Enter your choice: ");
        key = scanner.nextInt();
        if (key == 1) {
            services.addProduct(new Products(21, "apple", 10));
            services.addProduct(new Products(22, "cherry", 15));
            services.addProduct(new Products(23, "cola", 7));

            services.addUser(new Users(201, "Nazar", "Nazarov", 50));
            services.addUser(new Users(202, "Ivan", "Ivanov", 60));
            services.addUser(new Users(203, "Stepan", "Stepanov", 70));
        }
        while (choise > 0) {
            System.out.println();
            System.out.println("Menu by marketplace:");
            System.out.println(" 1. Display list of all users ");
            System.out.println(" 2. Display list of all products ");
            System.out.println(" 3. User buy product");
            System.out.println(" 4. Display list of user products by user id.");
            System.out.println(" 5. Display list of users that bought product by product id");
            System.out.println(" 6. Add new product");
            System.out.println(" 7. Add new user");
            System.out.println(" 8. Delete product");
            System.out.println(" 9. Delete user");
            System.out.println(" 0. Exit.");
            System.out.print(" Enter your choice: ");
            choise = scanner.nextInt();
            System.out.println();
            switch (choise) {
                case 1 -> services.showUsers();
                case 2 -> services.showProducts();
                case 3 -> {
                    try {
                        services.addProductForUser();
                    } catch (MyExceptions e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    System.out.print("Enter the person Id: ");
                    key = scanner.nextInt();
                    services.showUserProducts(key);
                }
                case 5 -> {
                    System.out.print("Enter the product Id : ");
                    key = scanner.nextInt();
                    services.showUserWithProduct(key);
                }
                case 6 -> {
                    try {
                        Products product = services.newProduct();
                        services.addProduct(product);
                    } catch (MyExceptions e) {
                        e.printStackTrace();
                    }
                }
                case 7 -> {
                    try {
                        Users user = services.newUser();
                        services.addUser(user);
                    } catch (MyExceptions e) {
                        e.printStackTrace();
                    }
                }
                case 8 -> {
                    System.out.print("Enter the productId: ");
                    key = scanner.nextInt();
                    services.removeProduct(key);
                }
                case 9 -> {
                    System.out.print("Enter the userId: ");
                    key = scanner.nextInt();
                    services.removeUser(key);
                }
                default -> {
                }
            }
        }
    }
}
