package main.java.marketplace;

import java.util.*;

public class Services {
    private int userId = 100;
    private int productId = 0;
    private List<Products> productsList;
    private List<Users> usersList;
    private Map<Integer, List<Products>> mapUsers;

    public void addProduct(Products product) {
        if (productsList == null) {
            productsList = new ArrayList<>();
        }
        productsList.add(product);
    }

    public void addUser(Users user) {
        if (usersList == null) {
            usersList = new ArrayList<>();
        }
        if (mapUsers == null) {
            mapUsers = new HashMap<>();
        }
        usersList.add(user);
        List<Products> productsBuy = new ArrayList<>();
        mapUsers.put(user.getId(), productsBuy);
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

    public void addProductForUser() {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No user!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the user Id: ");
            int userId = scanner.nextInt();
            System.out.print("Enter the product Id: ");
            int productId = scanner.nextInt();

            if (findUser(userId) != null && findProduct(productId) != null) {
                int temp = findUser(userId).getMoney() - findProduct(productId).getPrice();
                if (temp < 0) {
                    throw new MyExceptions("Insufficient funds to pay!");
                } else {
                    findUser(userId).setMoney(temp);
                    mapUsers.get(userId).add(findProduct(productId));
                    System.out.println("Product " + productId + " is add for user " + userId);
                }
            } else {
                System.out.println("No such user or product!");
            }
        }
    }

    private Products findProduct(int productId) {
        for (Products p : productsList) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;
    }

    private Users findUser(int userId) {
        for (Users u : usersList) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }

    public Products newProduct() {
        System.out.println("Create new product ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        if (productName == null || productName.isEmpty()) {
            throw new MyExceptions("Invalid product name");
        }
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        if (price <= 0) {
            throw new MyExceptions("Price must be more than 0!");
        }
        productId++;
        return new Products(productId, productName, price);
    }

    public Users newUser() {
        System.out.println("Create new user: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        if (firstName == null || firstName.isEmpty()) {
            throw new MyExceptions("Name must not be empty!");
        }
        System.out.print("Enter second name: ");
        String secondName = scanner.nextLine();
        if (secondName == null || secondName.isEmpty()) {
            throw new MyExceptions("Second Name must not be empty!");
        }
        System.out.print("Enter money: ");
        int money = scanner.nextInt();
        if (money <= 0) {
            throw new MyExceptions("Money must be more than 0!");
        }
        userId++;
        return new Users(userId, firstName, secondName, money);
    }

    public void removeUser(int id) {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("There are no users to remove!");
        } else if (mapUsers.containsKey(id)) {
            mapUsers.remove(id);
            usersList.remove(findUser(id));
        } else {
            System.out.println(id + " is absent!");
        }
    }

    public void removeProduct(int id) {
        if (productsList == null || productsList.isEmpty()) {
            System.out.println("There are no products to remove!");
        } else if (productsList != null) {
            mapUsers.forEach((key, value) -> {
                value.removeIf(products -> products.getId() == id);
            });
            productsList.remove(findProduct(id));
        } else {
            System.out.println(id + " is absent!");
        }
    }

    public void showUserProducts(int userId) {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No users!");
            System.out.println();
        } else {
            mapUsers.forEach((key, value) -> {
                if (key == userId) {
                    System.out.println("User " + key + " have products: ");
                    value.forEach(v -> System.out.print(v.getName() + " "));
                    System.out.println();
                }
            });
        }
    }

    public void showUserWithProduct(int productId) {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No product buy!");
            System.out.println();
        } else {
            mapUsers.forEach((key, value) -> {
                if (value.stream().anyMatch(v -> v.getId() == productId)) {
                    System.out.println("Users that bought product: ");
                    System.out.print(key + " ");
                }
            });
            System.out.println();
        }
    }
}
