package de.andrena.readablecode.bad;

import static java.lang.Math.sqrt;

public class Coordinate {
    public double x;
    public double y;
    public double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Coordinate target) {
        double distance = 0.0;

        double dX = this.x - target.x;
        double dY = this.y - target.y;
        double dZ = this.z - target.z;

        distance = sqrt(dX * dX + dY * dY + dZ * dZ);

        return distance;
    }
}
