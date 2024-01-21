package PVZ;
import java.util.List;
import java.util.Random;

public class Zombie extends Character{
    double spd; //speed sa zombie
    public Zombie(String name, int hp, int dmg, double spd){
        super(name, hp, dmg, 10, 0);
            Random rando = new Random();
            super.row = rando.nextInt(5) + 1;
            super.col = 10 + rando.nextFloat();
            this.spd = spd;
    }

    public void atk(List<Plant> everyone){
        Plant near = plantNear(everyone); //private method si plantNear
        if(near == null){
            col -= (float) (1 / spd);
        }else {
            near.takeDamage(this.dmg);
        }
    }

    private Plant plantNear(List<Plant> everyone){
        for(Character c : everyone){
            if(c instanceof Plant && c.row == this.row && c.col == Math.ceil(this.col)){
                return (Plant) c;
            }
        }
        return null;
    }
}
