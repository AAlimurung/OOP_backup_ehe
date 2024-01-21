package CloseToYou;
import java.util.Comparator;
public class Point implements Comparable<Point>{
    int ex; //x variable
    int why; //y variable

    public Point(int ex, int why) {
        this.ex = ex;
        this.why = why;
    }

    public int compareTo(Point there){ //there is other
        int wae = Integer.compare(there.why, this.why); //wae is another variable
        if(wae != 0){
            return wae;
        }
        return Integer.compare(this.ex, there.ex);
    }

    @Override
    public String toString() {
        return "(" + ex + ", " + why + ")";
    }

    public static class GoToDistance implements Comparator<Point>{
        private Point target;
        public GoToDistance(Point target){
            this.target = target;
        }

        protected double tip(Point o1, Point o2){
            int dis_ex = o2.ex - o1.ex;
            int dis_why = o2.why - o1.why;
            int disx_2 = dis_ex * dis_ex; //square x
            int disy_2 = dis_why * dis_why; //square y

            return Math.sqrt(disx_2 + disy_2); //sqrt sa sum sa square of x and y
        }

        public int compare(Point o1, Point o2){
            double Dis1 = tip(target, o1); //another variable to store the values of the distance
            double Dis2 = tip(target, o2);  //and target

            return Double.compare(Dis1, Dis2);
        }

    }
}
