package PVZ;

public abstract class Shield {
    int hp;

    public Shield(int hp){
        this.hp = hp;
    }
    public static class Cone extends Shield{
        public Cone(){
            super(370);
        }
    }

    public static class Newspaper extends Shield{
        public Newspaper(){
            super(150);
        }
    }

    public static class Screen extends Shield{
        public Screen(){
            super(1281);
        }
    }

    public static class Wall extends Shield{
        public Wall(){
            super(4000);
        }
    }

}
