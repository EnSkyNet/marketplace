package main.java.marketplace;

import java.util.*;

public class Services {
    private int userId = 103;
    private int productId = 3;
    private List<Products> productsList;
    private List<Users> usersList;
    private Map<Integer, List<Products>> mapUsers;

    public List<Users> getUsersList() {
        return usersList;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

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

  /*  public void addUserProduct(Users user) {
        if (mapUsers == null) {
            mapUsers = new HashMap<>();
        }
        List<Products> productsBuy = new ArrayList<>();
        mapUsers.put(user.getId(), productsBuy);
    }*/

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
                    System.out.println("Insufficient funds to pay!");
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

    public Products findProduct(int productId) {
        for (Products p : productsList) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;
    }

    public Users findUser(int userId) {
        for (Users u : usersList) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
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

   /* public void showUsers() {
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
    }*/

    public void showUserProducts(int userId) {
        if (mapUsers == null || mapUsers.isEmpty()) {
            System.out.println("No users!");
            System.out.println();
        } else {
            System.out.println("User have products: ");
            mapUsers.forEach((key, value) -> {
                if (key == userId) {
                    System.out.print(key + ": ");
                    value.forEach(v -> System.out.print(v.getName()));
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
            System.out.println("This product is buy by user: ");
            mapUsers.forEach((key, value) -> {

                    //System.out.print(key + ": ");
                    value.forEach(v -> {
                        if(v.getId() == productId){
                            System.out.println(key);
                        };
                    });
                    System.out.println();

            });
        }
    }

    /*private Integer findUser(int id) {
        return mapUsers.entrySet()
                .stream()
                .filter(k -> k.getKey() == id)
                .findFirst().map(Map.Entry::getKey).orElse(null);
    }*/
}
