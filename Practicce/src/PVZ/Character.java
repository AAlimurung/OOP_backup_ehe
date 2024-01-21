package PVZ;
import java.util.Comparator;
import java.util.List;
public abstract class Character {
    String name; //names sa chara
    int hp; //hp of the chara
    int dmg; //dmg dealt
    float col; //col kung asa ibutang si plant and where moagi si zombie
    int row; //same goes here

    public Character(String name, int hp, int dmg, float col, int row) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.col = col;
        this.row = row;
    }

    public void takeDamage(int dmg){ //method to take dmg
        if(this instanceof Shieldable && ((Shieldable)this).getShield().hp > 0){
            Shieldable c = (Shieldable) this;
            c.getShield().hp -= dmg;
        }else {
            hp -= dmg;
        }
    }

    public boolean isDead(){
        return hp <= 0;
    }

    public String toString(){
        if(this instanceof Shieldable){
            return name + " <" + hp + "+" + ((Shieldable) this).getShield().hp + "> r: " + row + "| c: " + col;
        }else {
            return name + " <" + hp + "> r: " + row + "| c: " + col;
        }
    } //intro format

    public static class DistanceComp implements Comparator<Character>{
        Character source; //like ang nearest character
        public DistanceComp(Character source){
            this.source = source;
        }

        @Override
        public int compare(Character o1, Character o2){
            if(o1.row == source.row && o2.row == source.row){
                return Double.compare(o1.col - source.col, o2.col - source.col);
            }
            if(o1.row == source.row){
                return -1;
            }
            if(o2.row == source.row){
                return 1;
            }
            return  0;
        }
    }
}
