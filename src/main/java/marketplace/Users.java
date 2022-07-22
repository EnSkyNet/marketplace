package main.java.marketplace;

public class Users {
    private int id;
    private String firstName;
    private String secondName;
    private int money;

    public Users(int id, String firstName, String secondName, int money) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return id +" " + firstName + " "+ secondName + " " + money;
    }
}
