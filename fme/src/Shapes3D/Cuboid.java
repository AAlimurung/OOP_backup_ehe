package Shapes3D;

public class Cuboid extends Solid {
    private double height;
    private double base;
    private double length;

    public Cuboid(int x, int y, double height, double base, double length) {
        super(x, y);
        this.height = height;
        this.base = base;
        this.length = length;
    }

    @Override
    public double volume() {
        double v = length*base*height;
        return v;
    }

    @Override
    public double surfaceArea() {
        double tsa = 2*((length*base) + (base*height) + (length*height));
        return tsa;
    }

    public String toString() {
        return super.toString() + " which is a Cuboid";
    }

    public static class Cube extends Cuboid{
        private double side;
        public Cube(int x, int y, double side){
            super(x, y, side, side, side);
            this.side = side;
        }

        public String toString() {
            return super.toString() + " which is also a Cube";
        }

        @Override
        public double volume() {
            double v = side*side*side;
            return v;
        }

        @Override
        public double surfaceArea() {
            double tsa = 6*(side*side);
            return tsa;
        }
    }
}
