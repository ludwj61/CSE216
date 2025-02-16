package com.jackson.model;

import java.util.Arrays;
import java.util.List;

public class Quadrilateral implements Positionable, TwoDShape {

    private final TwoDPoint[] vertices = new TwoDPoint[4];

    public Quadrilateral(double... vertices) {
        this(TwoDPoint.ofDoubles(vertices));
    }

    public Quadrilateral(List<TwoDPoint> vertices) {
        int n = 0;
        for (TwoDPoint p : vertices)
            this.vertices[n++] = p;
        if (!isMember(vertices))
            throw new IllegalArgumentException(
                    String.format("Invalid set of vertices specified for %s", this.getClass().getCanonicalName()));
    }

    /**
     * Given a list of four points, adds them as the four vertices of this
     * quadrilateral in the order provided in the list. This is expected to be a
     * counterclockwise order of the four corners.
     *
     * @param points the specified list of points.
     * @throws IllegalStateException if the number of vertices provided as input is
     *                               not equal to four.
     */
    @Override
    public void setPosition(List<? extends Point> points) {
        // was todo
        if (points.size() != 4)
            throw new IllegalStateException("The input list must have exactly 4 items");

        int count = 0;
        for (Object point : points) {
            this.vertices[count++] = (TwoDPoint) point;
        }
    }

    @Override
    public List<TwoDPoint> getPosition() {
        return Arrays.asList(vertices);
    }

    /**
     * @return the lengths of the four sides of the quadrilateral. Since the setter
     *         {@link Quadrilateral#setPosition(List)} expected the corners to be
     *         provided in a counterclockwise order, the side lengths are expected
     *         to be in that same order.
     */
    protected double[] getSideLengths() {
        double side1 = Math.abs(this.vertices[0].coordinates()[0] - this.vertices[1].coordinates()[0]);
        double side2 = Math.abs(this.vertices[1].coordinates()[1] - this.vertices[2].coordinates()[1]);
        double side3 = Math.abs(this.vertices[3].coordinates()[0] - this.vertices[2].coordinates()[0]);
        double side4 = Math.abs(this.vertices[0].coordinates()[1] - this.vertices[3].coordinates()[1]);
        return new double[] { side1, side2, side3, side4 }; // was todo
    }

    // added by me
    /**
     * Get the smallest x-value in the list of quadrilateral vertices.
     */
    public double getSmallestXCoord() {
        double smallest = vertices[0].getX();

        for (TwoDPoint p : vertices) {
            if (p.getX() < smallest)
                smallest = p.getX();
        }

        return smallest;
    }

    @Override
    public int numSides() {
        return 4;
    }

    @Override
    public boolean isMember(List<? extends Point> vertices) {
        return vertices.size() == 4;
    }
}
