package Shapes3D;

import org.w3c.dom.ls.LSOutput;

public abstract class Solid {
    int x;
    int y;

    public Solid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Solid() {
       x = 50;
       y = 50;
    }

    public abstract double volume();
    public abstract double surfaceArea();

    @Override
    public String toString() {
        return "A solid at (" + x + ", " + y + ")";
    }
}
