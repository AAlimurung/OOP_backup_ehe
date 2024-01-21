package Shapes3D;

import java.lang.Math;
public class Cone extends Solid{
    private double baseDia;
    private double cheight;

    public Cone(int x, int y, double baseDia, double cheight) {
        super(x, y);
        this.baseDia = baseDia;
        this.cheight = cheight;
    }

    protected double slantHeight(double baseDia, double cheight){
        double rad = baseDia/2;
        double sum = (rad*rad) + (cheight*cheight);
        double slheight = Math.sqrt(sum);

        return slheight;
    }
    @Override
    public double volume() {
        double radii = baseDia/2;
        double vol = 1.0/3*Math.PI*(radii*radii)*cheight;
        return vol;
    }

    @Override
    public double surfaceArea() {
        double slant = slantHeight(baseDia, cheight);
        double rad = baseDia/2;
        double sa = Math.PI*rad*(slant+rad);
        return sa;
    }

    @Override
    public String toString() {
        return super.toString() + " which is a Cone";
    }
}
