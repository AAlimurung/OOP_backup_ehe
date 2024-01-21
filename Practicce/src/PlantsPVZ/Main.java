package PlantsPVZ;

//PAIR: KISTERIA
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int INFINITE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        boolean state = mode.equals("Fog") || mode.equals("Night");
        String input;

        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Sun-shroom":
                    plants.add(new Mushroom.SunShroom(state));
                    break;
                // add more plants here
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Puff-shroom":
                    plants.add(new Mushroom.PuffShroom(state));
                    break;
                case "Doom-shroom":
                    plants.add(new Mushroom.DoomShroom(state));
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail":
                    for(Plant p : plants){
                        if(p instanceof Plant.LilyPad){
                            int pin = plants.indexOf(p);
                            plants.add(pin, (Plant) ((Upgradable)p).upgrade());
                            plants.remove(p);
                            break;
                        }
                    }
                    break;
                case "Twin Sunflower":
                    for (Plant p : plants){
                        if(p instanceof Plant.Sunflower){
                            int pin = plants.indexOf(p);
                            plants.add(pin, (Plant)((Upgradable)p).upgrade());
                            plants.remove(p);
                            break;
                        }
                    }
                    break;
                case "Coffee Bean":
                    Plant.CoffeeBean cb = new Plant.CoffeeBean();
                    for (Plant p : plants){
                        if(p instanceof Mushroom && !((Mushroom)p).isAwake()){
                            ((Mushroom)p).awaken(cb);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));

        do {
            int counter = 0; //counter sun, total
            int pop = 0; //counter sun producers, num
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    // add implementation here
                    for(Plant p : plants){
                        if(p instanceof SunProducer && p.isAlive()){
                            pop++;
                            counter += ((SunProducer)p).produce_sun();
                        }
                    }
                    System.out.println(pop + " sun producers gather " + counter + " suns");
                    break;
                case "Attack":
                    // add implementation here
                    for(Plant p : plants){
                        if(p instanceof Attacker && p.isAlive()){
                            pop++;
                            counter += ((Attacker)p).attack();
                        }
                    }
                    if(pop == 0){
                        System.out.println("You have no attackers");
                    }else{
                        System.out.println(pop + " attackers dealing " + counter + " damage");
                    }
                    break;
                // add more cases here
                case "Attacker Status":
                    for(Plant p : plants){
                        if(p instanceof Attacker && p.isAlive()) {
                            pop++;
                            switch (((Attacker)p).rangeType()){
                                case SINGLE_LINE:
                                    System.out.println(p.name + " can attack on a single line");
                                    break;
                                case AOE:
                                    System.out.println(p.name + " can attack using area-of-effect");
                                    break;
                                case LIMITED:
                                    System.out.println(p.name + " can attack only when enemy is nearby");
                                    break;
                                case FREE_RANGE:
                                    System.out.println(p.name + " can attack any enemies from anywhere");
                                    break;
                            }
                        }
                    }
                    if(pop == 0){
                        System.out.println("You have no attackers");
                    }
                    break;
                case "Instant Kill Status":
                    for(Plant p : plants){
                        if(p instanceof InstantKiller && p.isAlive()){
                            pop++;
                            switch (((InstantKiller)p).killType()){
                                case INSTANT:
                                    System.out.println(p.name + " can kill instantly");
                                    break;
                                case CLOSE_ON:
                                    System.out.println(p.name + " can kill on contact");
                                    break;
                            }
                        }
                    }
                    if(pop == 0){
                        System.out.println("You have no plants which can kill instantly");
                    }
                    break;
                case "Sort by HP":
                    plants.sort(new Plant.sortbyHP());
                    for(Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                case "Sort by Sun Cost":
                    plants.sort(new Plant.sortbySunCost());
                    for(Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                case "Sort by Name":
                    plants.sort(new Plant.NameComparator());
                    for(Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}
