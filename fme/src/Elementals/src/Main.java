null
package Elementals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        List<Alloy> alloys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        int aps;
        do {
            System.out.print("Enter element/alloy: ");
            input = sc.nextLine();
            switch (input) {
                case "Copper":
                    elements.add(new TransitionMetal.Copper());
                    break;
                // TODO add more cases here
                case "Iron":
                    elements.add(new TransitionMetal.Iron());
                    break;
                case "Gold":
                    elements.add(new TransitionMetal.Gold());
                    break;
                case "Zinc":
                    elements.add(new TransitionMetal.Zinc());
                    break;
                case "Titanium":
                    elements.add(new TransitionMetal.Titanium());
                    break;
                case "Technetium":
                    elements.add(new TransitionMetal.Technetium());
                    break;
                case "Tin":
                    elements.add(new PostTransitionMetal.Tin());
                    break;
                case "Aluminum":
                    elements.add(new PostTransitionMetal.Aluminum());
                    break;
                case "Uranium":
                    elements.add(new Actinide.Uranium());
                    break;
                case "Steel":
                    alloys.add(new Alloy.Steel());
                    break;
                case "Brass":
                    alloys.add(new Alloy.Brass());
                    break;
                case "Bronze":
                    alloys.add(new Alloy.Bronze());
                    break;
            }
        } while (!input.equals("DONE"));

        do {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            aps = 0; //index
            switch (input){
                case "Radiate":
                    // TODO Radiate here
                    for(Element el : elements){
                        if(el instanceof Radioactive){ //check if element is radioactive
                            aps++; //if radioactive, index++
                            ((Radioactive)el).hanyo(); //call ang katong interface
                        }
                    }
                    if(aps == 0){
                        System.out.println("No radioactive materials present");
                    }
                    break;
                case "Magnetize":
                    // TODO Radiate here
                    for(Element e : elements){
                        if (e instanceof Magnetic){
                            aps = 1;
                            System.out.println(e.toString() + " is " + ((Magnetic)e).magn_type() + " with strength of " + ((Magnetic) e).magn_strength());
                        }
                    }

                    for (Alloy al : alloys){
                        if(al instanceof Magnetic){
                            aps = 1;
                            System.out.println(al.getName() + " is " + ((Magnetic) al).magn_type() + " with strength of " + ((Magnetic) al).magn_strength());
                        }
                    }

                    if(aps == 0){
                        System.out.println("No magnetic materials present");
                    }
                    break;
                case "Conduct":
                    // TODO Radiate here
                    for (Element le : elements){
                        if (le instanceof Conductive){
                            aps = 1; //di nako TT
                            double con = Math.round(((((Conductive)le).percent_c()*1)/1.0)*100);
                            System.out.println(le.toString() + " conductivity is " + con + "%");
                        }
                    }

                    for(Alloy lo : alloys){
                        if(lo instanceof Conductive){
                            aps = 1;
                            double duc = Math.round(((((Conductive)lo).percent_c()*1)/1.0)*100);
                            System.out.println(lo.toString() + " conductivity is " + duc + "%");
                        }
                    }

                    if(aps == 0){
                        System.out.println("No conductive materials present");
                    }
                    break;
                case "Alloy Components":
                    // TODO Radiate here
                    for (Alloy hori : alloys){
                        aps = 0;
                        System.out.print(hori.getName() + " consists of ");

                        for(Element ment : hori.newdawn){
                            System.out.print(ment.getElname()); //kuhaa ang ln sa println

                            if(aps < hori.newdawn.size()-1){
                                aps++;
                                System.out.print(", ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get State":
                    System.out.print("Enter temperature: ");
                    double temp = sc.nextDouble();
                    sc.nextLine(); // This is to clear the newline
                    // TODO print state of elements
                    for(Element e : elements){
                        System.out.println(e.toString() + " is " + e.state((float) temp));
                    }
                    break;
                case "Sort by Weight":
                    Collections.sort(elements);
                    for (Element e : elements) {
                        System.out.println(e + " = " + e.getAtomweight());
                    }
                    if (elements.isEmpty()) {
                        System.out.println("No elements present");
                    }
                    break;
            }
        } while (!input.equals("DONE"));
    }
}