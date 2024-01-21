package CloseToYou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        int size = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter point " + (i+1) + " : ");
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        System.out.println("USING COMPARABLE");
        // TODO sort using Comparable
        Collections.sort(points);
        for (Point p : points) {
            System.out.println(p);
        }
        while (true) {
            System.out.print("Enter target: ");
            int ex = sc.nextInt();
            if (ex < -9 || ex > 9) {
                break;
            }
            int why = sc.nextInt();
            if (why < -9 || why > 9) {
                break;
            }
            Point target = new Point(ex, why);
            print(points, target);
        }
    }

    static void print(ArrayList<Point> points, Point target) {
        System.out.println("Sorted nearest to " + target);
        // TODO sort using Comparator<Point>
        points.sort(new Point.GoToDistance(target));
        for (Point p : points) {
            System.out.println(p);
        }
        // TODO sort using Comparable
        Collections.sort(points);
        int index = 0;
        for (int j = 9; j >= -9; j--) {
            for (int i = -9; i <= 9; i++) {
                if (target.ex == i && target.why == j) {
                    if (index < points.size() && points.get(index).ex == i && points.get(index).why == j) {
                        System.out.print("|1o");
                        index++;
                    } else {
                        System.out.print("| o");
                    }
                } else if (index < points.size() && points.get(index).ex == i && points.get(index).why == j) {
                    Point p = points.get(index);
                    // TODO sort using Comparator<Point>
                    points.sort(new Point.GoToDistance(target));
                    int ind = points.indexOf(p)+1;
                    if (ind < 10) {
                        System.out.print("| " + ind);
                    } else {
                        System.out.print("|" + ind);
                    }
                    // TODO sort using Comparable
                    Collections.sort(points);
                    index++;
                } else {
                    System.out.print("|  ");
                }
            }
            System.out.println();
        }
    }
}