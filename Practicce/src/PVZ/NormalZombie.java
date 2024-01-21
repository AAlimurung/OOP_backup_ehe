package PVZ;

public class NormalZombie extends Zombie{
    public NormalZombie(){
        super("Normal Zombie", 181, 100, 4.7);
    }

    public NormalZombie(String name){
        super(name, 181, 100, 4.7);
    }

    public static class Conehead extends NormalZombie implements Shieldable{
        Shield.Cone theCone;
        public Conehead(){
            super("Conehead Zombie");
            theCone = new Shield.Cone();
        }

        @Override
        public Shield getShield(){
            return theCone;
        }
    }

    public static class NewspaperZombie extends NormalZombie implements Shieldable{
        Shield.Newspaper theNews;
        public NewspaperZombie(){
            super("Newspaper Zombie");
            this.theNews = new Shield.Newspaper();
        }
        
        @Override
        public void takeDamage(int dmg){
            super.takeDamage(dmg);
            if(theNews.hp <= 0){
                spd = 1.8;
            }
        }

        public Shield getShield(){
            return theNews;
        }
    }
}
