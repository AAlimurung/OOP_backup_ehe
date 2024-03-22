import java.util.ArrayList;
import java.util.Collections;


public class Kalkaburo{
    ArrayList<Card> cards;

    public Kalkaburo() {
        cards=new ArrayList<>();
        String dia = "Diamond";
        String clo = "Clubs";
        String spa = "Spades";
        String hea = "Heart";

        cards.add(new Card.Ace("red", hea));
        cards.add(new Card.Ace("black", spa));
        cards.add(new Card.Ace("red", dia));
        cards.add(new Card.Ace("black",clo));

        for(int i=1;i<10;i++){
            cards.add(new Card.NumCard("red","heart",i+1));
            cards.add(new Card.NumCard("black","spades",i+1));
            cards.add(new Card.NumCard("red","Diamond",i+1));
            cards.add(new Card.NumCard("black","clubs",i+1));

        }

        cards.add(new Card.FaceCard("red","heart", 11));
        cards.add(new Card.FaceCard("black","spades", 11));
        cards.add(new Card.FaceCard("red","diamond", 11));
        cards.add(new Card.FaceCard("black","clubs", 11));


        cards.add(new Card.FaceCard("red","heart", 12));
        cards.add(new Card.FaceCard("black","spades", 12));
        cards.add(new Card.FaceCard("red","diamond", 12));
        cards.add(new Card.FaceCard("black","clubs",12));

        cards.add(new Card.FaceCard("red","heart", 13));
        cards.add(new Card.FaceCard("black","spades", 13));
        cards.add(new Card.FaceCard("red","diamond", 13));
        cards.add(new Card.FaceCard("black","clubs", 13))
    }
}
