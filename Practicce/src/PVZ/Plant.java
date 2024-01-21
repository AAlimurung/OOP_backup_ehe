package PVZ;

import java.util.List;
public abstract class Plant extends Character{
    int sun_cost; //String breed

    public Plant(String name, int hp, int dmg, int sun_cost, float col, int row){
        super(name, hp, dmg, col, row);
        this.sun_cost = sun_cost;
    } //constructor ni Plant

    public abstract void atk(List<Zombie> everyone);

    public static class Peashooter extends Plant{ //Peashooter is a new Plant
        public Peashooter(float col, int row){
            super("Peashooter", 500, 20, 100, col, row); //inherit ang unsay naa ni Plant
        }

        @Override
        public void atk(List<Zombie> everyone){
            everyone.sort(new DistanceComp(this));
            for (Character c : everyone){
                if(c.row == this.row){
                    System.out.println("Attacking " + c);
                    c.takeDamage(dmg);
                    break;
                }
            }
        }
    }

    //    public static class Sunflower extends Plant{}
    public static class Wall_nut extends Plant{
        public Wall_nut(float col, int row){
            super("Wallnut", 4000, 0, 50, col, row);
        }

        public void atk(List<Zombie> everyone){
            everyone.sort(new DistanceComp(this));
            for(Character c : everyone){
                if(c.row == this.row){
                    System.out.println("Shielding from " + c);
                    c.takeDamage(dmg);
                    break;
                }
            }
        }
    }
    // Repeater, Cherry_Bomb, Potato_Mine, Snow_Pea, Chomper
}
