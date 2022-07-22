package main.java.marketplace;


import java.util.*;


public class Marketplace {
    public static void main(String[] args) {
        int key;
        String nickName;
        Scanner scanner = new Scanner(System.in);
        Services services = new Services();
        int choise = 6;

        services.addProduct(new Products(1, "apple", 10));
        services.addProduct(new Products(2, "cherry", 15));
        services.addProduct(new Products(3, "cola", 7));

        services.addUser(new Users(101,"Nazar", "Nazarov",50));
        services.addUser(new Users(102,"Ivan", "Ivanov", 60));
        services.addUser(new Users(103,"Stepan", "Stepanov", 70));


        while (choise > 0) {
            System.out.println();
            System.out.println("Menu by marketplace:");
            System.out.println(" 1. Display list of all users ");
            System.out.println(" 2. Display list of all products ");
            System.out.println(" 3. User buy product");
            System.out.println(" 4. Display list of user products by user id.");
            System.out.println(" 5. Display list of users that bought product by product id");
            System.out.println(" 0. Exit.");
            System.out.print(" Enter your choice: ");
            choise = scanner.nextInt();
            System.out.println();
            switch (choise) {
                case 1:
                    services.showUsers();
                    break;
                case 2:
                    services.showProducts();
                    break;
                case 3:
                    services.addProductForUser();
                    break;
                case 4:
                    System.out.print("Enter the person Id: ");
                    key = scanner.nextInt();
                    services.showUserProducts(key);
                    break;
                case 5:
                    System.out.print("Enter the product Id : ");
                    key = scanner.nextInt();
                    services.showUserWithProduct(key);
                    break;

                /*case 1:
                    Users user = services.newUser();
                    services.addUser(user);;
                    break;
                case 2:
                    Animal animal = clubService.newAnimal();
                    clubService.addAnimal(animal);
                    break;
                case 3:
                    System.out.print("Enter the person: ");
                    key = scanner.next();
                    System.out.print("Enter the nickname of animal: ");
                    nickName = scanner.next();
                    clubService.removeAnimal(key, nickName);
                    break;
                case 4:
                    System.out.print("Enter the person: ");
                    key = scanner.next();
                    clubService.removePerson(key);
                    break;
                case 5:
                    clubService.showClub();
                    break;*/
                default:
                    break;
            }
        }
    }
}
