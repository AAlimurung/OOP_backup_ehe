package Shapes3D;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solid solid = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter solid: ");
        String option = sc.nextLine();
        int x, y = 0;
        System.out.print("Enter x: ");
        x = sc.nextInt();

        if(x == -1){
            x = 50;
            y = 50;
        }else{
            System.out.print("Enter y: ");
            y = sc.nextInt();
        }

     switch (option) {
            case "Cuboid":
                System.out.print("Enter height: ");
                double hei = sc.nextDouble();
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter length: ");
                double len = sc.nextDouble();
                // This nextLine is to rid the next line made by the previous scan
                // Do this in the future as well, before getting a String input
                sc.nextLine();
                solid = new Cuboid(x, y, len, hei, base);
                break;
            case "Cube":
                System.out.print("Enter side: ");
                double s = sc.nextDouble();
                sc.nextLine();
                solid = new Cuboid.Cube(x, y, s);
                break;
            // Add other cases for other shapes here
            case "Sphere":
                System.out.print("Enter diameter: ");
                double diamond = sc.nextDouble();
                sc.nextLine();
                solid = new Sphere(x, y, diamond);
                break;
            case "Hemisphere":
                System.out.print("Enter diameter: ");
                double diadia = sc.nextDouble();
                sc.nextLine();
                solid = new Sphere.Hemisphere(x, y, diadia);
                break;
            case "Cone":
                System.out.print("Enter base diameter: ");
                double bazzbee = sc.nextDouble();
                System.out.print("Enter height: ");
                double icecream = sc.nextDouble();
                sc.nextLine();
                solid = new Cone(x, y, bazzbee, icecream);
                break;
            default:
                System.out.print("Not a shape");
        }

        // This assert simply states that by the time the switch is done,
        // the shape should already be assigned to a particular shape
        // and is therefore not null anymore
        assert solid != null;
        System.out.println(solid);
        System.out.print("Surface Area is ");
        System.out.format("%.2f", solid.surfaceArea());
        System.out.print("\nVolume is ");
        System.out.printf("%.2f", solid.volume());
    }
}