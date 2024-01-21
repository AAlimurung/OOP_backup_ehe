package Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<Person>();
        String input, name, name2;
        int age;
        double salary;
        while (true){
            System.out.print("Enter person type: ");
            input = sc.nextLine();
            if (input.equals("DONE")) {
                break;
            }
            switch (input.charAt(0)) { //four cases
                case 'c':  //1
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter customer age: ");
                    age = sc.nextInt();
                    // TODO add new Customer in persons here
                    persons.add(new Customer(name, age));
                    break;
                case 'e': //2
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee age: ");
                    age = sc.nextInt();
                    System.out.print("Enter employee salary: ");
                    salary = sc.nextDouble();
                    // TODO add new Employee in persons here
                    persons.add(new Employee(name, age, salary));
                    break;
                // TODO add more cases for other Person subclasses here
                case 'd': //3
                    System.out.print("Enter developer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter developer age: ");
                    age = sc.nextInt();
                    System.out.print("Enter developer salary: ");
                    salary = sc.nextDouble();

                    persons.add(new Developer(name, age, salary));
                    break;
                case 'm': //4
                    System.out.print("Enter manager name: ");
                    name = sc.nextLine();
                    System.out.print("Enter manager age: ");
                    age = sc.nextInt();
                    System.out.print("Enter manager salary: ");
                    salary = sc.nextDouble();

                    persons.add(new Manager(name, age, salary));
                    break;
            }
            sc.nextLine();
        }

        while (true) {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    return;
                case "Birthday":
                    System.out.print("Whose birthday? ");
                    name = sc.nextLine();
                    // TODO find name and call birthday
                    boolean hbd = false;
                    for(Person w : persons){
                        if(w.getNamae().equals(name)){
                            w.bday();
                            hbd = true;
                            break;
                        }
                    }

                    if(!hbd)
                        System.out.println("Invalid input");
                    break;
                case "Assign PM":
                    System.out.print("Select developer: ");
                    name = sc.nextLine();
                    System.out.print("Select manager: ");
                    name2 = sc.nextLine();
                    // TODO find developer "name" and manager "name2" and assign PM

                    Person dev = null;
                    for(Person dv : persons){ //check if person is dev
                        if(dv.getNamae().equals(name) && dv instanceof Developer){
                            dev = dv;
                            break;
                        }
                    }

                    if(name2.equals("NULL")){
                        if(dev != null){
                            ((Developer) dev).fire();
                        }
                    }else {
                        Person mgn = null;
                        for (Person mg : persons){
                            if(mg.getNamae().equals(name2) && mg instanceof Manager){
                                mgn = mg;
                                break;
                            }
                        }
                        if(dev != null && mgn != null){
                            ((Developer) dev).setPm((Manager) mgn);
                        }else{
                            System.out.println("Invalid input");
                        }
                    }
                    break;
                // TODO add more action cases here
                case "Customer List":
                    int aps = 0;
                    for(Person cstm : persons){
                        if(cstm instanceof Customer){
                            System.out.println(((Customer)cstm).toString());
                            aps++;
                        }
                    }
                    if(aps == 0){
                        System.out.println("No customers in list");
                    }else{
                        System.out.println("Total Count: " + aps);
                    }
                    break;
                case "Developer List":
                    int devs = 0;
                    for(Person dvlp : persons){
                        if(dvlp instanceof Developer){
                            System.out.println(((Developer)dvlp).toString());
                            devs++;
                        }
                    }
                    if(devs == 0){
                        System.out.println("No developers in list");
                    }else{
                        System.out.println("Total Count: " + devs);
                    }
                    break;
                case "Manager List":
                    int foo = 0;
                    for(Person mngr : persons){
                        if(mngr instanceof Manager){
                            System.out.println(((Manager)mngr).toString());
                            foo++;
                        }
                    }
                    if(foo == 0){
                        System.out.println("No managers in list");
                    }else{
                        System.out.println("Total Count: " + foo);
                    }
                    break;
                case "Person List":
                    if(persons.isEmpty()){
                        System.out.println("No persons in list");
                    }else {
                        for(Person pers : persons){
                            System.out.println(pers.toString());
                        }
                        System.out.println("Total Count: " + persons.size());
                    }
                    break;
                case "Employee List":
                    int ye = 0;
                    for(Person mply : persons){
                        if(mply instanceof Employee){
                            System.out.println(((Employee)mply).toString());
                            ye++;
                        }
                    }
                    if(ye == 0){
                        System.out.println("No employees in list");
                    }else{
                        System.out.println("Total Count: " + ye);
                    }
                    break;
                case "Perform Task":
                    for(Person em : persons){
                        em.performTask();
                    }
                    break;
                case "Give Raise":
                    System.out.print("Enter manager: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee: ");
                    name2 = sc.nextLine();
                    System.out.print("Enter increase: ");
                    double bdo = sc.nextDouble();
                    sc.nextLine();
                    Person gou = null;
                    for(Person pr : persons){
                        if(pr.getNamae().equals(name) && pr instanceof Manager){
                            gou = pr;
                            break;
                        }
                    }

                    Person emp = null;
                    for(Person pi : persons){
                        if(pi.getNamae().equals(name2) && pi instanceof Employee){
                            emp = pi;
                            break;
                        }
                    }
                    if(gou != null && emp != null){
                        ((Manager)gou).Raise((Employee) emp, bdo);
                    }else {
                        System.out.println("Invalid input");
                    }
                    break;
                case "Customer Speak":
                    System.out.print("Select customer: ");
                    name = sc.nextLine();
                    System.out.print("Select employee: ");
                    name2 = sc.nextLine();

                    int fcn = 0;
                    for(Person cs : persons){
                        if(cs instanceof Customer && name.equals(cs.getNamae())){
                            for(Person ee : persons){
                                if(ee instanceof Employee && name2.equals(ee.getNamae())){
                                    ((Customer)cs).talk((Employee) ee);
                                    fcn = 1;
                                }
                            }
                        }
                    }

                    if(fcn == 0){
                        System.out.println("Invalid input");
                    }
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }

}