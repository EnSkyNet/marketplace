package main.java.marketplace;

import java.util.*;

public class Services {
    private int userId = 103;
    private int productId = 3;
    private List<Products> productsList;
    private List<Users> usersList;
    private Map<Users, List<Products>> mapUsers;

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public void addUser(Users user) {
        if (usersList == null) {
            usersList = new ArrayList<>();
        }
        usersList.add(user);
        addUserProducts(user);
    }

    public void addProduct(Products product) {
        if (productsList == null) {
            productsList = new ArrayList<>();
        }
        productsList.add(product);
    }

    public void showUsers() {
        if (usersList == null || usersList.isEmpty()) {
            System.out.println("No users!");
            System.out.println();
        } else {
            System.out.println("There are users: ");
            for (Users u : usersList) {
                System.out.println(u.toString());
            }
        }
    }

    public void showProducts() {
        if (productsList == null || productsList.isEmpty()) {
            System.out.println("No products!");
            System.out.println();
        } else {
            System.out.println("There are products: ");
            for (Products p : productsList) {
                System.out.println(p.toString());
            }
        }
    }

    public void addUserProducts(Users user) {
        if (mapUsers == null) {
            mapUsers = new HashMap<>();
        }
        List<Products> productsBuy = new ArrayList<>();
        mapUsers.put(user, productsBuy);
    }

    public void addProductForUser() {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No user!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the person: ");
            int userId = scanner.nextInt();
            System.out.print("Enter the person: ");
            int productId = scanner.nextInt();

            if (findUser(userId) != null && productsList.get(productId) != null) {
                mapUsers.get(findUser(userId)).add(productsList.get(productId));

            } else {
                System.out.println(userId + " is absent!");
            }
        }
    }

    public Users newUser() {
        userId++;
        System.out.println("Create new user: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter second name: ");
        String secondName = scanner.next();
        System.out.print("Enter money: ");
        int money = scanner.nextInt();
        return new Users(userId, firstName, secondName, money);
    }

    public void showUserProducts() {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No users!");
            System.out.println();
        } else {
            System.out.println("Users are: ");
            mapUsers.forEach((key, value) -> {
                System.out.print(key.getId() + " " + key.getFirstName()
                        + " " + key.getSecondName()
                        + " " + key.getMoney());
                System.out.println();
            });
        }
    }

    private Users findUser(int id) {
        return mapUsers.entrySet()
                .stream()
                .filter(k -> k.getKey().getId() == (id))
                .findFirst().map(Map.Entry::getKey).orElse(null);
    }


}
