package bankosentral;
import java.util.*;
public abstract class Card {
    String name;
    int age;
    double bal;
    double limit;
    int usage;
    int PIN;

    public Card(String name, int age, double bal, double limit, int usage, int PIN) {
        this.name = name;
        this.age = age;
        this.bal = bal;
        this.limit = limit;
        this.usage = usage;
        this.PIN = PIN;
    }

    Card(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();

        System.out.println("Enter age: ");
        age = sc.nextInt();

        System.out.println("Enter initial balance: ");
        bal = sc.nextDouble();

        do{
            System.out.println("Enter your permanent PIN: ");
            PIN = sc.nextInt();
            if(PIN < 1000 || PIN > 9999){
                System.out.println("Only 4 digit, please try again.");
            }
        }while(PIN < 1000 || PIN > 9999);
        usage = 0;
    }

    void withdraw(double money){
        if(bal < money){
            System.out.println("Lack of notes. Please come back again.");
            return;
        }
        bal -= money;
        usage++;
    }

    void deposit(double money){
        if(bal + money > limit){
            System.out.println("Reached the limit. Please come back again.");
            return;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Balance: " + bal;
    }

    void
}
