package driver;
import java.text.DecimalFormat;
public class Test003 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        DataSet bankData = new DataSet();
        bankData.add(new BankAccount(0));
        bankData.add(new BankAccount(10000));
        bankData.add(new BankAccount(2000));
        System.out.println("Bank Average Balance: " + df.format(bankData.getAverage()));
        Measurable max = bankData.getMax();
        System.out.println("Bank Highest Balance: " + max.getMeasure());

        DataSet coinData = new DataSet();
        coinData.add(new Coin(0.25, "Quarter"));
        coinData.add(new Coin(0.1, "Dime"));
        coinData.add(new Coin(0.05, "Nickel"));
        System.out.println("Average Coin Value: " + df.format(coinData.getAverage()));
        max = coinData.getMax();
        System.out.println("Highest Coin Value: " + df.format(max.getMeasure()));
        System.out.println("Highest Coin's Name: " + max.getName());

        DataSet studentData = new DataSet();
        studentData.add(new Student("Ali", 157.50));
        studentData.add(new Student("Alex", 165.00));
        studentData.add(new Student("Maria", 147.00));
        System.out.println("Average Student's Height: " + df.format(studentData.getAverage()));
        max = studentData.getMax();
        System.out.println("Tallest Height: " + df.format(max.getMeasure()));
        System.out.println("Tallest Student's Name: " + max.getName());
    }
}
interface Measurable {
    double getMeasure();
    String getName();
}
class Student implements Measurable {
    private String name;
    private double height;
    public Student(String name, double height) {
        this.name = name;
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    @Override
    public double getMeasure() {
        return height;
    }
    @Override
    public String getName() {
        return name;
    }
}
class BankAccount implements Measurable {
    private int accNumber;
    private double balance;
    private static int LastAssignedNumber = 0;
    public BankAccount() {
        balance = 0.0;
        LastAssignedNumber++;
        accNumber = LastAssignedNumber;
    }
    public BankAccount(double b) {
        balance = b;
        LastAssignedNumber++;
        accNumber = LastAssignedNumber;
    }
    public int getAccountNumber() {
        return accNumber;
    }
    @Override
    public double getMeasure() {
        return balance;
    }
    @Override
    public String getName() {
        return "Account " + accNumber;
    }
}
class Coin implements Measurable {
    private double value;
    private String name;

    public Coin(double v, String n) {
        this.value = v;
        this.name = n;
    }
    public double getValue() {
        return value;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getMeasure() {
        return value;
    }
}
class DataSet {
    private double sum;
    private Measurable max;
    private int count;
    public DataSet() {
        sum = 0;
        count = 0;
    }
    public void add(Measurable x) {
        sum += x.getMeasure();
        if (count == 0 || max.getMeasure() < x.getMeasure()) {
            max = x;
        }
        count++;
    }
    public Measurable getMax() {
        return max;
    }
    public double getAverage() {
        if (count == 0) return 0; // Avoid division by zero
        return sum / count;
    }
}



















