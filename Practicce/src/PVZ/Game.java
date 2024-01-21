package PVZ;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Game {
    List<Zombie> zombies;
    List<Plant> plants;
    List<Character> everyone;

    public Game(){
        zombies = new ArrayList<>();
        plants = new ArrayList<>();
        everyone = new ArrayList<>();
    }

    public void createGame(){

        //adding all zombies using for-loop due to being randomized
        Random random = new Random();
        for(int i = 0; i<5; i++){
            int type = random.nextInt(3) + 1;
            switch (type){
                case 1:
                    zombies.add(new NormalZombie());
                    break;
                case 2:
                    zombies.add(new NormalZombie.Conehead());
                    break;
                case 3:
                    zombies.add(new NormalZombie.NewspaperZombie());
                    break;
            }
        }
        everyone.addAll(zombies);

        //adding all plants without using for-loop
        //apparently pwede man ka mogamit ug for-loop but wth
        plants.add(new Plant.Peashooter(3, 1));
        plants.add(new Plant.Peashooter(3, 2));
        plants.add(new Plant.Peashooter(3, 3));
        plants.add(new Plant.Peashooter(3, 4));
        plants.add(new Plant.Peashooter(3, 5));
        plants.add(new Plant.Wall_nut(4, 1));
        plants.add(new Plant.Wall_nut(4, 2));
        plants.add(new Plant.Wall_nut(4, 3));
        plants.add(new Plant.Wall_nut(4, 4));
        plants.add(new Plant.Wall_nut(4, 5));
        everyone.addAll(plants);

        while(true){
            System.out.println("ZOMBIES");
            for(Zombie z : zombies){
                System.out.println(z);
            }
            System.out.println("PLANTS");
            for(Plant p: plants){
                System.out.println(p);
            }
            for (Character c : everyone){
                if(c instanceof Zombie){
                    ((Zombie)c).atk(plants);
                }else{
                    ((Plant)c).atk(zombies);
                }
            }
            ArrayList<Character> dead = new ArrayList<>();
            for(Character c : everyone){
                if(c.isDead()){
                    dead.add(c);
                    if(c instanceof Plant){
                        plants.remove(c);
                    }else if (c instanceof Zombie){
                        zombies.remove(c);
                    }
                }
            }
            everyone.removeAll(dead);
            if(zombies.size() == 0){
                System.out.println("YOU WON!");
                return;
            }
            for (Zombie z : zombies){
                if(z.col <=0){
                    System.out.println("Zombies ate your brains!");
                    return;
                }
            }
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }
    }
}
