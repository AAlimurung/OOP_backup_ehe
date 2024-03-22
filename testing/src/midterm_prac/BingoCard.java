package midterm_prac;
import java.util.*;
public class BingoCard {
    List<Integer> bingo;
    private int[][] binCards;
    int id;

    //Random rand = new Random();

    public BingoCard(int id) {
        this.id = id;
        /*
         * B = 1 - 15
         * I = 16 - 30
         * N = 31 - 45 [3rd element = 0]
         * G = 46 - 60
         * O = 61 - 75
         * */

        binCards = new int[5][5];
        List<Integer> b = randomize(1, 15);
        List<Integer> ii = randomize(16, 30);
        List<Integer> n = randomize(31, 45);
        List<Integer> g = randomize(46, 60);
        List<Integer> o = randomize(60, 75);

        for (int i = 0; i < 5; i++) {
            binCards[i][0] = b.get(i);
            binCards[i][1] = ii.get(i);
            binCards[i][2] = n.get(i);
            binCards[i][3] = g.get(i);
            binCards[i][4] = o.get(i);
        }

        binCards[2][2] = 0;
    }

    private List<Integer> randomize(int start, int end) {
        List<Integer> nos = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            nos.add(i);
        }
        Collections.shuffle(nos);
        return nos;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < 5; j++) { //row
            for (int k = 0; k < 5; k++) { //col
                str.append((binCards[j][k])).append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }
}