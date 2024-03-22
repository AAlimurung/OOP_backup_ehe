import java.util.ArrayList;

public abstract class Card {
    public String color;
    public String shape;


    public Card(String color,String shape) {
        this.color = color;
        this.shape = shape;
    }

    /*static class Queen extends Card{
        public Queen(String color, String shape) {
            super(color, shape);
        }
        @Override
        public String toString() {
            return "Queen "+shape;
        }
    }
    static class Jack extends Card{
        public Jack(String color, String shape) {
            super(color, shape);
        }
        @Override
        public String toString() {
            return "Jack "+shape;
        }
    }
    static class King extends Card{
        public King(String color, String shape) {
            super(color, shape);
        }
        @Override
        public String toString() {
            return "King "+shape;
        }
    }*/

    static class FaceCard extends Card{
        int num;
        public FaceCard(String color, String shape, int num){
            super(color, shape);
            this.num = num;
        }

        public String toString(){
            switch (num){
                case 11: return "Jack"+" of "+shape;
                case 12: return "Queen"+" of "+shape;
                case 13: return "King "+" of "+shape;
                default: return "Cannot comply";
            }
        }
    }
    static class Ace extends Card{
        public Ace(String color, String shape) {
            super(color, shape);
        }
        @Override
        public String toString() {
            return "Ace of "+shape;
        }
    }
     static class NumCard extends Card{
        int num;
        public NumCard(String color, String shape, int num) {
            super(color, shape);
            this.num = num;
        }

        @Override
        public String toString() {
            return num+" of "+shape;
        }


    }

    public static void main(String[] args) {
        Kalkaburo kb=new Kalkaburo();
    }



}
