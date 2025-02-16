package com.jackson.model;

/**
 * An unmodifiable point in the three-dimensional space. The coordinates are
 * specified by exactly three doubles (its <code>x</code>, <code>y</code>, and
 * <code>z</code> values).
 */
public class ThreeDPoint implements Point {
    private final double x, y, z; // added by me

    public ThreeDPoint(double x, double y, double z) {
        this.x = x; // was todo, added by me
        this.y = y;
        this.z = z;
    }

    /**
     * @return the (x,y,z) coordinates of this point as a <code>double[]</code>.
     */
    @Override
    public double[] coordinates() {
        return new double[] { x, y, z }; // was todo, added by me
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
