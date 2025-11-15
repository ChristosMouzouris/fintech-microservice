public class Person {

    private int id;
    private String name;
    private double balance;

    public Person(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Person{ " +
                "id = " + id +
                ", name = " + name +
                ", balance = " + balance +
                "}";
    }
}
