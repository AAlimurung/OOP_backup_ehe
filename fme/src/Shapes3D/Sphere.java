package Shapes3D;

public class Sphere extends Solid {
    private double dia;

    public Sphere(int x, int y, double dia) {
        super(x, y);
        this.dia = dia;
    }

    @Override
    public double volume() {
        double rad = dia/2;
        double vol = 4.0/3*Math.PI*(rad*rad*rad);
        return vol;
    }

    @Override
    public double surfaceArea() {
        double rad = dia/2;
        double sa = 4*Math.PI*(rad*rad);
        return sa;
    }

    @Override
    public String toString() {
        return super.toString() + " which is a Sphere";
    }

    public static class Hemisphere extends Sphere{
        private double hdia;
        public Hemisphere(int x, int y, double hdia){
            super(x, y, hdia);
            this.hdia = hdia;
        }

        @Override
        public double volume() {
            double radii = hdia/2;
            double vol = 2.0/3*Math.PI*(radii*radii*radii);
            return vol;
        }

        @Override
        public double surfaceArea() {
            double r = hdia/2;
            double sa = 3*Math.PI*(r*r);
            return sa;
        }

        @Override
        public String toString() {
            return super.toString() + " but only half of it";
        }
    }
}
